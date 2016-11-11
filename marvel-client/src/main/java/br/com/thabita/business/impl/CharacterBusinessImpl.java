package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;

@Component
public class CharacterBusinessImpl extends BaseBusiness implements CharacterBusiness {

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
		Map<String, Object> params = new HashMap<String, Object>();
		List<Character> characters = super.getApi().getCharacters(params);

		for (Character character : characters) {
			params = new HashMap<String, Object>();
			List<Comic> comics = super.getApi().getCharacterComics(character.getId(), params);

			character.setComics(comics);

			banco.put(character.getId(), character);
		}

		return new ArrayList<Character>(banco.values());
	}
}
