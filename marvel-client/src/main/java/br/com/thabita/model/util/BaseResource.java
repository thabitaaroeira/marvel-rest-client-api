package br.com.thabita.model.util;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Base Entity for the resources provided by the API.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public abstract class BaseResource {

	/**
	 * The unique ID of the character resource.
	 */
	private Integer id;

	/**
	 * Resource URIs are references to the representation of a resource within
	 * the API.
	 */
	private String resourceURI;

	/**
	 * The date the resource was most recently modified.
	 */
	private Date modified;

}
