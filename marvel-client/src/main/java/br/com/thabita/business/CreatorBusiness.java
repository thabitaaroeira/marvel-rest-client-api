package br.com.thabita.business;

import java.util.List;
import java.util.Map;

import br.com.thabita.model.Creator;

public interface CreatorBusiness {

	public Creator create(Creator creator);

	public Creator read(Integer id);

	public Creator update(Creator creator);

	public void delete(int id);

	public List<Creator> getAll(Map<String, Object> parametros);

}
