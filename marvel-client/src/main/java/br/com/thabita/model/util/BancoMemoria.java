package br.com.thabita.model.util;

import java.util.List;

import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("unused")
public class BancoMemoria {

	private List<Comic> comics;

	private List<Character> characters;

	private List<Creator> creators;

	public BancoMemoria(List<Comic> comics, List<Character> characters, List<Creator> creators) {
		super();
		this.comics = comics;
		this.characters = characters;
		this.creators = creators;
	}

}
