package br.com.thabita.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.thabita.util.BaseEntidade;

/**
 * Representacao de entidade Creator.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Creator extends BaseEntidade {

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
	private List<Comic> comics;

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

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

}
