package br.com.thabita.model;

import java.util.List;

import br.com.thabita.util.BaseEntidade;

/**
 * Representacao de entidade Character
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

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

}
