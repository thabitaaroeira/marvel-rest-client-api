package br.com.thabita.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.business.IComicBusiness;
import br.com.thabita.model.Comic;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class ComicBusiness extends BaseBusiness implements IComicBusiness {

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

	public void fill() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Comic> resultado = super.getApi().getComics(params);
		ConjuntoDados<Comic> dados = resultado.getDados();
		List<Comic> comics = dados.getValores();

		for (Comic comic : comics) {
			banco.put(comic.getId(), comic);
		}
	}

}
