package br.com.thabita.resource;

import java.net.URI;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.thabita.business.impl.CharacterBusiness;
import br.com.thabita.model.Character;

@Component
@Path("characters")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterResource {

	@Autowired
	private CharacterBusiness business;

	@Path("{id}")
	@GET
	public Character get(@PathParam("id") int id) {
		return business.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Character character) {
		// Character character = (Character) new Gson().fromJson(conteudo, Character.class);
		business.create(character);
		URI uri = URI.create("/carrinhos/" + character.getId());
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") int id) {
		business.delete(id);
		return Response.ok().build();
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, String conteudo) {
		Character character = (Character) new Gson().fromJson(conteudo, Character.class);
		business.update(character);
		return Response.ok().build();
	}
	
}
