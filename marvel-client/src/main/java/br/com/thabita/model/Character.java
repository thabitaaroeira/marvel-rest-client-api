package br.com.thabita.model;

import br.com.thabita.model.util.BaseResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Character resource representation.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class Character extends BaseResource {

	/**
	 * The name of the character.
	 */
	private String name;

	/**
	 * A short bio or description of the character.
	 */
	private String description;

}
