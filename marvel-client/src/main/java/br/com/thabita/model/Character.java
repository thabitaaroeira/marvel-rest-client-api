package br.com.thabita.model;

import br.com.thabita.model.util.BaseEntidade;

/**
 * Character resource representation.
 */
public class Character extends BaseEntidade {

	/**
	 * The name of the character.
	 */
	private String name;

	/**
	 * A short bio or description of the character.
	 */
	private String description;

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

}
