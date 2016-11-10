package br.com.thabita.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.thabita.util.BaseEntidade;

/**
 * Representacao de entidade Character
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Character extends BaseEntidade {

	/**
	 * The name of the character.
	 */
	private String name;

	/**
	 * A short bio or description of the character.
	 */
	private String description;

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

	/**
	 * A resource list containing comics which feature this character.
	 */
	private List<Comic> comics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

}
