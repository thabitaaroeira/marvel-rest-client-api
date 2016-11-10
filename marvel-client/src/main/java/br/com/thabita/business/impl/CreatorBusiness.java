package br.com.thabita.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.ICreatorBusiness;
import br.com.thabita.model.Creator;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class CreatorBusiness extends BaseBusiness implements ICreatorBusiness {

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

	public void fill() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Creator> resultado = super.getApi().getCreators(params);
		ConjuntoDados<Creator> dados = resultado.getDados();
		List<Creator> creators = dados.getValores();

		for (Creator creator : creators) {
			banco.put(creator.getId(), creator);
		}
	}

}
