package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.ComicBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;

@Component
public class ComicBusinessImpl extends BaseBusiness implements ComicBusiness {

	private static Map<Integer, Comic> banco = new HashMap<Integer, Comic>();
	private static AtomicInteger contador = new AtomicInteger(1);

	@Override
	public void create(Comic comic) {
		int id = contador.incrementAndGet();
		comic.setId(id);
		banco.put(id, comic);
	}

	@Override
	public Comic read(Integer id) {
		return banco.get(id);
	}

	@Override
	public void update(Comic comic) {
		banco.put(comic.getId(), comic);
	}

	@Override
	public void delete(int id) {
		banco.remove(id);
	}

	@Override
	public List<Comic> getAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Comic> comics = super.getApi().getComics(params);

		for (Comic comic : comics) {
			params = new HashMap<String, Object>();
			List<Character> characters = super.getApi().getComicCharacters(comic.getId(), params);
			comic.setCharacters(characters);
			
			params = new HashMap<String, Object>();
			List<Creator> creators = super.getApi().getComicCreators(comic.getId(), params);
			comic.setCreators(creators);

			banco.put(comic.getId(), comic);
		}

		return new ArrayList<Comic>(banco.values());
	}

}
