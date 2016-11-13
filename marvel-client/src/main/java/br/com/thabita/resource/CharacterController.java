package br.com.thabita.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;

@Component
@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterController {

	private static Logger logger = LogManager.getLogger(CharacterController.class);

	@Autowired
	private CharacterBusiness business;

	@GET
	public List<Character> getAll() {
		List<Character> characters = business.getAll(null);
		logger.debug("> getAll = " + characters.toString());
		return characters;
	}

	@Path("{id}")
	@GET
	public Character get(@PathParam("id") int id) {
		Character character = business.read(id);
		logger.debug("> get/" + id + " = " + character.toString());
		return character;
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
