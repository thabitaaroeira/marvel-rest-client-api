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

import br.com.thabita.business.ICreatorBusiness;
import br.com.thabita.model.Creator;

@Path("creators")
public class CreatorResource {

	@Autowired
	private ICreatorBusiness business;

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Creator read(@PathParam("id") int id) {
		return business.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Creator creator) {
		// Creator creator = (Creator) new Gson().fromJson(conteudo, Creator.class);
		business.create(creator);
		URI uri = URI.create("/carrinhos/" + creator.getId());
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		business.delete(id);
		return Response.ok().build();
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, String conteudo) {
		Creator creator = (Creator) new Gson().fromJson(conteudo, Creator.class);
		business.update(creator);
		return Response.ok().build();
	}

}
