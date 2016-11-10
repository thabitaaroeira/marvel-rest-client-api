package br.com.thabita.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.thabita.model.Creator;
import br.com.thabita.util.ConjuntoDados;
import br.com.thabita.util.Resultado;

@Component
public class CreatorDAO extends BaseDAO {

	@Value("${key.public}")
	private String publicKey;

	@Value("${key.private}")
	private String privateKey;

	private static Map<Integer, Creator> banco = new HashMap<Integer, Creator>();
	private static AtomicInteger contador = new AtomicInteger(1);

	public void create(Creator comic) {
		int id = contador.incrementAndGet();
		comic.setId(id);
		banco.put(id, comic);
	}

	public Creator read(Integer id) {
		return banco.get(id);
	}

	public void update(Creator creator) {
		banco.put(creator.getId(), creator);
	}

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
