package br.com.thabita.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.constants.Parametro;

@Component
@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterController {

	private static Logger logger = LogManager.getLogger(CharacterController.class);

	@Autowired
	private CharacterBusiness business;

	// @GET
	// public List<Character> getAll() {
	// List<Character> characters = business.getAll(null);
	// logger.debug("> getAll = " + characters.toString());
	// return characters;
	// }

	@Path("{id}")
	@GET
	public Character get(@PathParam("id") int id) {
		Character character = business.read(id);
		logger.debug("> get/" + id + " = " + character);
		return character;
	}

	@GET
	public List<Character> getAll(@QueryParam("name") String nome,
			@DefaultValue("id") @QueryParam("orderBy") String orderBy) {
		Map<String, Object> params = createParameters(nome, orderBy);
		logger.debug("> getAll params " + params.toString());

		List<Character> characters = business.getAll(params);
		logger.debug("> getAll result = " + characters.toString());
		return characters;
	}

	public Map<String, Object> createParameters(String nome, String orderBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (nome != null) {
			params.put(Parametro.NAME.getName(), nome);
		}
		if (nome != null) {
			params.put(Parametro.ORDER_BY.getName(), orderBy);
		}
		params.put(Parametro.LIMIT.getName(), 5);
		return params;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Character add(Character character) {
		character = business.create(character);
		logger.debug("> add/ = " + character);
		return character;
	}

	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") int id) {
		business.delete(id);
		logger.debug("> remove/ = " + id);
		return Response.ok().build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Character update(@PathParam("id") int id, Character character) {
		logger.debug("> update/ = " + id);
		character = business.update(character);
		return character;
	}

}
