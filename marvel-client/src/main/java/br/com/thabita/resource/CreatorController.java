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

import br.com.thabita.business.CreatorBusiness;
import br.com.thabita.model.Creator;

@Component
@Path("/creators")
@Produces(MediaType.APPLICATION_JSON)
public class CreatorController {

	@Autowired
	private CreatorBusiness business;

	private static Logger logger = LogManager.getLogger(CreatorController.class);

	@GET
	public List<Creator> getAll() {
		List<Creator> creators = business.getAll(null);
		logger.debug("> getAll = " + creators.toString());
		return creators;
	}

	@Path("{id}")
	@GET
	public Creator get(@PathParam("id") int id) {
		Creator creator = business.read(id);
		logger.debug("> get/" + id + " = " + creator.toString());
		return creator;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Creator add(Creator creator) {
		creator = business.create(creator);
		logger.debug("> add/ = " + creator);
		return creator;
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
	public Creator update(@PathParam("id") int id, Creator creator) {
		logger.debug("> update/ = " + id);
		creator = business.update(creator);
		return creator;
	}

}
