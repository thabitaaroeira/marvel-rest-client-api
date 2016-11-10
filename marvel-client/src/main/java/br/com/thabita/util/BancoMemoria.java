package br.com.thabita.util;

import java.util.List;

import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;

public class BancoMemoria {

	private List<Comic> comics;

	private List<Character> characters;

	private List<Creator> creators;

	public BancoMemoria() {
	}

	public BancoMemoria(List<Comic> comics, List<Character> characters, List<Creator> creators) {
		this.comics = comics;
		this.characters = characters;
		this.creators = creators;
	}

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public List<Creator> getCreators() {
		return creators;
	}

	public void setCreators(List<Creator> creators) {
		this.creators = creators;
	}

}
