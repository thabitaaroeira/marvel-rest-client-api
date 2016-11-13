package br.com.thabita;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.thabita.model.Character;
import br.com.thabita.model.constants.Ordenacao;
import br.com.thabita.model.constants.Parametro;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharacterTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(CharacterTest.class);

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String URI = URI_ROOT + "/characters";

	@Test
	public void getAll() {
		// orderBy id por padrao
		Character[] result = restTemplate.getForObject(URI, Character[].class);
		logger.debug(result.toString());
		List<Character> characters = Arrays.asList(result);
		Assert.assertFalse(characters.isEmpty());
		Character character = null;
		for (Character c : characters) {
			if (c.getId().equals(1017100)) {
				character = c;
				break;
			}
		}
		// Base de dados Marvel
		Assert.assertEquals("A-Bomb (HAS)", character.getName());
		Assert.assertEquals("http://gateway.marvel.com/v1/public/characters/1017100", character.getResourceURI());
	}

	@Test
	public void getById() {
		// Base de dados Local
		Character entidade = createCharacter();
		ResponseEntity<Character> entity = restTemplate.getForEntity(getURIWithId(entidade, URI), Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		Assert.assertEquals(entity.getBody().getName(), entidade.getName());

		// Base de dados Marvel
		entity = restTemplate.getForEntity(URI + "/" + 1011334, Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		entidade = entity.getBody();
		Assert.assertTrue(entidade.getId() == 1011334);
		Assert.assertEquals(entidade.getName(), "3-D Man");
	}

	@Test
	public void getByName() {
		// Retorno unico
		String name = "Rogue";

		StringBuilder uri = new StringBuilder();
		uri.append(URI);
		uri.append("?");
		uri.append(Parametro.NAME.getName());
		uri.append("=");
		uri.append(name);
		uri.append("&");
		uri.append(Parametro.ORDER_BY.getName());
		uri.append("=");
		uri.append(Ordenacao.NAME.getValue());

		Character[] result = restTemplate.getForObject(uri.toString(), Character[].class);
		List<Character> characters = Arrays.asList(result);
		logger.debug(characters.toString());
		Assert.assertFalse(characters.isEmpty());
		Character character = null;
		for (Character chr : characters) {
			if (chr.getName().equals(name)) {
				character = chr;
				break;
			}
		}
		Assert.assertNotNull(character);
		Assert.assertTrue(character.getId().equals(1009546));
		Assert.assertEquals(name, character.getName());

		// Retorno em coleção
		String nameStartsWith = "Hu"; // Hulk
		uri = new StringBuilder();
		uri.append(URI);
		uri.append("?");
		uri.append(Parametro.NAME_STARTS_WITH.getName());
		uri.append("=");
		uri.append(nameStartsWith);
		uri.append("&");
		uri.append(Parametro.ORDER_BY.getName());
		uri.append("=");
		uri.append(Ordenacao.NAME.getValue());

		result = restTemplate.getForObject(uri.toString(), Character[].class);
		characters = Arrays.asList(result);
		logger.debug(characters.toString());
		Assert.assertFalse(characters.isEmpty());
		character = null;
		for (Character chr : characters) {
			if (chr.getName().startsWith(nameStartsWith)) {
				character = chr;
				break;
			}
		}
		Assert.assertTrue(character.getName().startsWith(nameStartsWith));
	}

	@Test
	public void add() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());

		Character created = entity.getBody();
		Assert.assertNotNull(created.getId());
		Assert.assertEquals(created.getName(), entidade.getName());
	}

	@Test
	public void remove() {
		Character entidade = createCharacter();

		String uri = getURIWithId(entidade, URI);
		logger.debug(uri);

		restTemplate.delete(uri);

		ResponseEntity<Character> entity = restTemplate.getForEntity(uri, Character.class);
		logger.debug(entity.toString());
		Assert.assertNull(entity.getBody().getId());
	}

	@Test
	public void update() {
		Character entidade = createCharacter();

		String uri = getURIWithId(entidade, URI);
		entidade.setDescription("Nova Descricao");
		restTemplate.put(uri, entidade);

		ResponseEntity<Character> entity = restTemplate.getForEntity(uri, Character.class);
		logger.debug(entity.toString());
		Assert.assertNotNull(entity.getBody());
		Assert.assertEquals(entidade.getDescription(), entity.getBody().getDescription());
	}

	public Character createCharacter() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		entidade = entity.getBody();
		return entidade;
	}

}
