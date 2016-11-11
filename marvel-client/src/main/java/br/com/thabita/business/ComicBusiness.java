package br.com.thabita.business;

import java.util.List;

import br.com.thabita.model.Comic;

public interface ComicBusiness {

	public void create(Comic comic);

	public Comic read(Integer id);

	public void update(Comic comic);

	public void delete(int id);

	public List<Comic> getAll();

}
