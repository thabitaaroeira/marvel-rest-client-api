package br.com.thabita.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.thabita.business.CreatorBusiness;
import br.com.thabita.model.Creator;
import br.com.thabita.model.constants.Parametro;

@Component
@Path("/creators")
@Produces(MediaType.APPLICATION_JSON)
public class CreatorController {

	private static final int DEFAULT_LIMIT = 10;

	@Autowired
	private CreatorBusiness business;

	private static Logger logger = LogManager.getLogger(CreatorController.class);

	@GET
	public List<Creator> getAll(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("orderBy") String orderBy) {
		Map<String, Object> params = createParameters(firstName, lastName, orderBy);
		logger.debug("> getAll params = " + params.toString());

		List<Creator> creators = business.getAll(params);
		logger.debug("> getAll result = " + creators.toString());
		return creators;
	}

	public Map<String, Object> createParameters(String firstName, String lastName, String orderBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (firstName != null) {
			params.put(Parametro.FIRST_NAME.getName(), firstName);
		}
		if (lastName != null) {
			params.put(Parametro.LAST_NAME.getName(), lastName);
		}
		if (orderBy != null) {
			params.put(Parametro.ORDER_BY.getName(), orderBy);
		}
		params.put(Parametro.LIMIT.getName(), DEFAULT_LIMIT);
		return params;
	}

	@Path("{id}")
	@GET
	public Creator get(@PathParam("id") int id) {
		Creator creator = business.read(id);
		logger.debug("> get/" + id + " = " + creator);
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
