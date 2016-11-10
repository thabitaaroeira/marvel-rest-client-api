package br.com.thabita.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.thabita.util.BaseEntidade;
import br.com.thabita.util.ConjuntoDados;

/**
 * Representacao de entidade Creator.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Creator extends BaseEntidade {

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
	 * The first name of the creator.
	 */
	private String firstName;

	/**
	 * The middle name of the creator.
	 */
	private String middleName;

	/**
	 * The last name of the creator.
	 */
	private String lastName;

	/**
	 * The suffix or honorific for the creator.
	 */
	private String suffix;

	/**
	 * The full name of the creator (a space-separated concatenation of the
	 * above four fields).
	 */
	private String fullName;

	/**
	 * A resource list containing the comics which feature work by this creator.
	 */
	private ConjuntoDados<Comic> comics;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public ConjuntoDados<Comic> getComics() {
		return comics;
	}

	public void setComics(ConjuntoDados<Comic> comics) {
		this.comics = comics;
	}

}
