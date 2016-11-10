package br.com.thabita.business;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import br.com.thabita.model.util.BaseEntidade;

public class BancoBusiness {

	private List<BaseEntidade> entidades;

	public BancoBusiness(List<BaseEntidade> entidades) {
		this.entidades = entidades;
	}

	public Boolean create(BaseEntidade entidade) {
		boolean result = false;
		if (!this.entidades.contains(entidade)) {
			result = this.entidades.add(entidade);
		}
		return result;
	}

	public BaseEntidade read(Integer id) {
		return getById(id);
	}

	public BaseEntidade update(BaseEntidade entidade) {
		Integer index = this.entidades.indexOf(entidade);
		this.entidades.set(index, entidade);
		return entidade;
	}

	public Boolean delete(BaseEntidade entidade) {
		return this.entidades.remove(entidade);
	}

	public BaseEntidade getById(Integer id) {
		return (BaseEntidade) CollectionUtils.find(this.entidades, new Predicate() {

			@Override
			public boolean evaluate(Object arg0) {
				return id.intValue() == ((BaseEntidade) arg0).getId().intValue();
			}
		});
	}

	public List<BaseEntidade> getEntidades() {
		return entidades;
	}

}
