package br.com.thabita.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import br.com.thabita.model.Comic;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class ComicDAO extends BaseDAO {

	private static Map<Integer, Comic> banco = new HashMap<Integer, Comic>();
	private static AtomicInteger contador = new AtomicInteger(1);

	public void create(Comic comic) {
		int id = contador.incrementAndGet();
		comic.setId(id);
		banco.put(id, comic);
	}

	public Comic read(Integer id) {
		return banco.get(id);
	}

	public void update(Comic comic) {
		banco.put(comic.getId(), comic);
	}

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
