package br.com.thabita.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.thabita.model.Character;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class CharacterDAO extends BaseDAO {

	@Value("${key.public}")
	private String publicKey;

	@Value("${key.private}")
	private String privateKey;

	private static Map<Integer, Character> banco = new HashMap<Integer, Character>();
	private static AtomicInteger contador = new AtomicInteger(1);

	public void create(Character comic) {
		int id = contador.incrementAndGet();
		comic.setId(id);
		banco.put(id, comic);
	}

	public Character read(Integer id) {
		return banco.get(id);
	}

	public void update(Character character) {
		banco.put(character.getId(), character);
	}

	public void delete(int id) {
		banco.remove(id);
	}

	public void fill() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Character> resultado = super.getApi().getCharacters(params);
		ConjuntoDados<Character> dados = resultado.getDados();
		List<Character> characters = dados.getValores();

		for (Character character : characters) {
			banco.put(character.getId(), character);
		}
	}

}
