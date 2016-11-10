package br.com.thabita.util;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Base Entity for the resources provided by the API.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseEntidade {

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public BaseEntidade() {
	}

	public BaseEntidade(Integer id) {
		this.id = id;
	}

}
