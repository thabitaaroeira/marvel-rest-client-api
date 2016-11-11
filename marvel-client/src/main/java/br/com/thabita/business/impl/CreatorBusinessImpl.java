package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.CreatorBusiness;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;

@Component
public class CreatorBusinessImpl extends BaseBusiness implements CreatorBusiness {

	private static Map<Integer, Creator> banco = new HashMap<Integer, Creator>();
	private static AtomicInteger contador = new AtomicInteger(1);

	@Override
	public void create(Creator comic) {
		int id = contador.incrementAndGet();
		comic.setId(id);
		banco.put(id, comic);
	}

	@Override
	public Creator read(Integer id) {
		return banco.get(id);
	}

	@Override
	public void update(Creator creator) {
		banco.put(creator.getId(), creator);
	}

	@Override
	public void delete(int id) {
		banco.remove(id);
	}

	@Override
	public List<Creator> getAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Creator> creators = super.getApi().getCreators(params);

		for (Creator creator : creators) {
			params = new HashMap<String, Object>();
			List<Comic> comics = super.getApi().getCreatorComics(creator.getId(), params);
			creator.setComics(comics);
			
			banco.put(creator.getId(), creator);
		}

		return new ArrayList<Creator>(banco.values());
	}

}
