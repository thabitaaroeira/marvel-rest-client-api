package br.com.thabita.model;

import br.com.thabita.model.util.BaseResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Creator resource representation.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class Creator extends BaseResource {

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

}
