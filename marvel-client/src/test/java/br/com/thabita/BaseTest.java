package br.com.thabita;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.thabita.model.BaseEntity;
import br.com.thabita.model.Character;
import br.com.thabita.model.Creator;
import br.com.thabita.model.constants.Parametro;

/**
 * Classe-base para os Teste Unitarios Rest. Contém métodos utilitários.
 */
public class BaseTest {

	protected final static String URI_ROOT = "/api";

	protected Character buildCharacter() {
		String random = RandomStringUtils.random(10);
		Character entidade = new Character();
		entidade.setName(random);
		entidade.setDescription(random);
		entidade.setModified(new Date());
		entidade.setResourceURI(random);
		return entidade;
	}

	protected Creator buildCreator() {
		String random = RandomStringUtils.random(10);
		Creator creator = new Creator();
		creator.setFirstName(random);
		creator.setFullName(random);
		creator.setLastName(random);
		creator.setMiddleName(random);
		creator.setModified(new Date());
		creator.setResourceURI(random);
		creator.setSuffix(random);
		return creator;
	}

	protected Map<String, Object> createParameters(String nome, String orderBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (nome != null) {
			params.put(Parametro.NAME.getName(), nome);
		}
		if (nome != null) {
			params.put(Parametro.ORDER_BY.getName(), orderBy);
		}
		return params;
	}

	protected String getURIWithId(BaseEntity entidade, String uri) {
		return uri + "/" + entidade.getId();
	}

}
