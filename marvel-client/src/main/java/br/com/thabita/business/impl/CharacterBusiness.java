package br.com.thabita.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

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
	public void create(Character character) {
		int id = contador.incrementAndGet();
		character.setId(id);
		banco.put(id, character);
	}

	@Override
	public Character read(Integer id) {
		return banco.get(id);
	}

	@Override
	public void update(Character character) {
		banco.put(character.getId(), character);
	}

	@Override
	public void delete(int id) {
		banco.remove(id);
	}

	@PostConstruct
	public void init() {
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
	}

}
