package service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;
import br.com.thabita.model.util.BaseResource;
import br.com.thabita.model.util.Resultado;

/**
 * Implementa a interface {@link com.pcab.marvel.IMarvelAPI} .
 */
public class MarvelAPICliente implements IMarvelAPI {

	public static final String COMICS = "comics";
	public static final String CHARACTERS = "characters";
	public static final String EVENTS = "events";
	public static final String SERIES = "series";
	public static final String STORIES = "stories";
	public static final String CREATORS = "creators";

	private static Logger logger = LogManager.getLogger(MarvelAPICliente.class);

	private String baseUrl = "http://gateway.marvel.com";
	private String version = "v1";

	private WebTarget baseTarget;

	private final Gson gson;

	private final CharSequence publicKey;
	private final CharSequence privateKey;
	private URLCodec encoder;

	private MarvelAPICliente(String publicKey, String privateKey) {
		this.publicKey = publicKey;
		this.privateKey = privateKey;

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		baseTarget = client.target(baseUrl);
		encoder = new URLCodec(CharEncoding.UTF_8);
		gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).create();
	}

	/**
	 * Cria uma instancia de {@link com.pcab.marvel.IMarvelAPI} .
	 * 
	 * @param publicKey
	 *            public key to be used on the requests.
	 * @param privateKey
	 *            private key to be used for the hash calculation.
	 * @return A client ready to start consuming the API.
	 */
	public static IMarvelAPI newInstance(String publicKey, String privateKey) {
		if (StringUtils.isEmpty(publicKey) || StringUtils.isEmpty(privateKey)) {
			throw new IllegalArgumentException("Eh necessario passar uma chave publica e uma chave privada.");
		}
		return new MarvelAPICliente(publicKey, privateKey);
	}

	@Override
	public Resultado<Comic> getComic(Integer comicId) {
		Response response = executeRequest(COMICS, comicId.toString());
		return getComicResponse(response);
	}

	@Override
	public Resultado<Character> getComicCharacters(Integer comicId, Map<String, Object> queryParams) {
		Response response = executeRequest(COMICS, comicId, CHARACTERS, queryParams);
		return getCharacterResponse(response);
	}

	@Override
	public Resultado<Creator> getComicCreators(Integer comicId, Map<String, Object> queryParams) {
		Response response = executeRequest(COMICS, comicId, CREATORS, queryParams);
		return getCreatorResponse(response);
	}

	@Override
	public Resultado<Character> getCharacter(Integer characterId) {
		Response response = executeRequest(CHARACTERS, characterId.toString());
		return getCharacterResponse(response);
	}

	@Override
	public Resultado<Comic> getCharacterComics(Integer characterId, Map<String, Object> queryParams) {
		Response response = executeRequest(CHARACTERS, characterId, COMICS, queryParams);
		return getComicResponse(response);
	}

	@Override
	public Resultado<Creator> getCreator(Integer creatorId) {
		Response response = executeRequest(CREATORS, creatorId.toString());
		return getCreatorResponse(response);
	}

	@Override
	public Resultado<Comic> getCreatorComics(Integer creatorId, Map<String, Object> queryParams) {
		Response response = executeRequest(CREATORS, creatorId, COMICS, queryParams);
		return getComicResponse(response);
	}

	@Override
	public Resultado<Comic> getComics(Map<String, Object> queryParams) {
		Response response = executeRequest(COMICS, queryParams);
		return getComicResponse(response);
	}

	@Override
	public Resultado<Character> getCharacters(Map<String, Object> queryParams) {
		Response response = executeRequest(CHARACTERS, queryParams);
		return getCharacterResponse(response);
	}

	@Override
	public Resultado<Creator> getCreators(Map<String, Object> queryParams) {
		Response response = executeRequest(CREATORS, queryParams);
		return getCreatorResponse(response);
	}

	private Response executeRequest(String resource, String subPath) {
		WebTarget baseRequest = buildBaseRequest(resource, Collections.emptyMap());
		Response response = baseRequest.path(subPath).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);
		return response;
	}

	private Response executeRequest(String resource, Integer id, String subPath, Map<String, Object> queryParams) {
		WebTarget baseRequest = buildBaseRequest(resource, queryParams);
		Response response = baseRequest.path(id.toString()).path(subPath).request(MediaType.APPLICATION_JSON_TYPE)
				.get(Response.class);
		return response;
	}

	private Response executeRequest(String resource, Map<String, Object> queryParams) {
		WebTarget baseRequest = buildBaseRequest(resource, queryParams);

		Response response = baseRequest.request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);
		return response;
	}

	/**
	 * Constroi um Request base pro resource especificado, e adiciona as query
	 * params.
	 * 
	 * @param resource
	 * @param queryParams
	 * @return WebTarget
	 */
	private WebTarget buildBaseRequest(String resource, Map<String, Object> queryParams) {
		Long currentTime = System.currentTimeMillis();

		byte[] hash = org.apache.commons.codec.digest.DigestUtils
				.md5(currentTime + getPrivateKey().toString() + getPublicKey().toString());

		final String Resultado = new String(Hex.encodeHex(hash));

		WebTarget baseRequest = baseTarget.path(version).path("public").path(resource).queryParam("ts", currentTime)
				.queryParam("apikey", publicKey).queryParam("hash", Resultado);

		if (queryParams != null) {

			for (Map.Entry<String, Object> entry : queryParams.entrySet()) {

				try {
					baseRequest = baseRequest.queryParam(entry.getKey(), encoder.encode(entry.getValue().toString()));

				} catch (EncoderException e) {
					throw new RuntimeException("Nao foi possivel codificar o valor do parametro: " + entry.getValue(),
							e);
				}
			}
		}
		return baseRequest;
	}

	private Resultado<Character> getCharacterResponse(Response response) {
		return getResponseWithToken(response, new TypeToken<Resultado<Character>>() {
		}.getType());
	}

	private Resultado<Comic> getComicResponse(Response response) {
		return getResponseWithToken(response, new TypeToken<Resultado<Comic>>() {
		}.getType());
	}

	private Resultado<Creator> getCreatorResponse(Response response) {
		return getResponseWithToken(response, new TypeToken<Resultado<Creator>>() {
		}.getType());
	}

	private <T extends BaseResource> Resultado<T> getResponseWithToken(Response response, Type token) {
		String entity = response.readEntity(String.class);
		logger.debug(entity);
		return gson.fromJson(entity, token);
	}

	public CharSequence getPublicKey() {
		return publicKey;
	}

	public CharSequence getPrivateKey() {
		return privateKey;
	}

	private static final String[] DATE_FORMATS = new String[] { "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss" };

	private class DateSerializer implements JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context)
				throws JsonParseException {
			for (String format : DATE_FORMATS) {
				try {
					return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
				} catch (ParseException e) {
				}
			}
			throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString() + "\". Supported formats: "
					+ Arrays.toString(DATE_FORMATS));
		}
	}

}
