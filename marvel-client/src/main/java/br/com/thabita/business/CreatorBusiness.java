package br.com.thabita.business;

import java.util.List;

import br.com.thabita.model.Creator;

public interface CreatorBusiness {

	public void create(Creator creator);

	public Creator read(Integer id);

	public void update(Creator creator);

	public void delete(int id);

	public List<Creator> getAll();

}
