package br.com.thabita.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.CreatorBusiness;
import br.com.thabita.model.Creator;
import br.com.thabita.model.Result;

@Component
public class CreatorBusinessImpl extends BaseBusiness implements CreatorBusiness {

	private static Map<Integer, Creator> banco = new HashMap<Integer, Creator>();
	private static AtomicInteger contador = new AtomicInteger(1);

	@Override
	public Creator create(Creator creator) {
		int id = contador.incrementAndGet();
		creator.setId(id);
		banco.put(id, creator);
		return creator;
	}

	@Override
	public Creator read(Integer id) {
		Creator creator = banco.get(id);

		/**
		 * Se o criador nao foi encontrado no banco local, repassa a chamada a
		 * api da marvel.
		 */
		if (creator == null) {
			Result<Creator> result = super.getApi().getCreator(id);
			if (result != null && result.getData() != null) {
				List<Creator> results = result.getData().getResults();
				creator = results.iterator().next();
			}
		}

		return creator;
	}

	@Override
	public Creator update(Creator creator) {
		banco.put(creator.getId(), creator);
		return creator;
	}

	@Override
	public void delete(int id) {
		banco.remove(id);
	}

	@Override
	public List<Creator> getAll(Map<String, Object> parametros) {
		Result<Creator> result = super.getApi().getCreators(parametros);
		List<Creator> creators = result.getData().getResults();

		for (Creator creator : creators) {
			banco.put(creator.getId(), creator);
		}

		return new ArrayList<Creator>(banco.values());
	}

}
