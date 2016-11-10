package resource;

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

import com.google.gson.Gson;

import br.com.thabita.dao.CharacterDAO;
import br.com.thabita.model.Character;

@Path("characters")
public class CharacterResource {

	@Autowired
	private CharacterDAO dao;

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Character read(@PathParam("id") int id) {
		return dao.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Character character) {
		// Character character = (Character) new Gson().fromJson(conteudo, Character.class);
		dao.create(character);
		URI uri = URI.create("/carrinhos/" + character.getId());
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		dao.delete(id);
		return Response.ok().build();
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, String conteudo) {
		Character character = (Character) new Gson().fromJson(conteudo, Character.class);
		dao.update(character);
		return Response.ok().build();
	}

}
