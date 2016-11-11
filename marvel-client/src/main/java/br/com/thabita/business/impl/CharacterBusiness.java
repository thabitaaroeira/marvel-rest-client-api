package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.ICharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class CharacterBusiness extends BaseBusiness implements ICharacterBusiness {

	private static Map<Integer, Character> banco = new HashMap<Integer, Character>();
	private static AtomicInteger contador = new AtomicInteger(1);

	@Override
	public Character create(Character character) {
		int id = contador.incrementAndGet();
		character.setId(id);
		banco.put(id, character);
		return character;
	}

	@Override
	public Character read(Integer id) {
		return banco.get(id);
	}

	@Override
	public Character update(Character character) {
		banco.put(character.getId(), character);
		return character;
	}

	@Override
	public void delete(int id) {
		banco.remove(id);
	}

	@Override
	public List<Character> getAll() {
		// Buscando Todos os Characters
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Character> resultado = super.getApi().getCharacters(params);
		ConjuntoDados<Character> dados = resultado.getDados();
		List<Character> characters = dados.getValores();

		for (Character character : characters) {
			// Buscando as Comics para cada Char
			params = new HashMap<String, Object>();
			Resultado<Comic> comicsResultado = super.getApi().getCharacterComics(character.getId(), params);
			ConjuntoDados<Comic> comicsDados = comicsResultado.getDados();
			List<Comic> comics = comicsDados.getValores();

			// Preenchendo o banco em mem
			character.setComics(comics);
			banco.put(character.getId(), character);
		}
		
		return new ArrayList<Character>(banco.values());
	}
}
