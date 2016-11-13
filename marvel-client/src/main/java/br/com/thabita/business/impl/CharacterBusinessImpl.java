package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Result;

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
		Character character = banco.get(id);

		/**
		 * Se o personagem nao foi encontrado no banco local, repassa a chamada
		 * a api da marvel.
		 */
		if (character == null) {
			Result<Character> result = super.getApi().getCharacter(id);
			if (result != null && result.getData() != null) {
				List<Character> characters = result.getData().getResults();
				character = characters.iterator().next();
			}
		}

		return character;
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
	public List<Character> getAll(Map<String, Object> parametros) {
		Result<Character> result = super.getApi().getCharacters(parametros);
		List<Character> characters = result.getData().getResults();

		for (Character character : characters) {
			banco.put(character.getId(), character);
		}
		return new ArrayList<Character>(banco.values());
	}

}
