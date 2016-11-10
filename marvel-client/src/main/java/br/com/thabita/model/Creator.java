package br.com.thabita.model;

import br.com.thabita.model.util.BaseEntidade;

/**
 * Creator resource representation.
 */
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

}
