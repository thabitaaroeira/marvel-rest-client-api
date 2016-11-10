package br.com.thabita.business;

import br.com.thabita.model.Comic;

public interface IComicBusiness {

	public void create(Comic comic);

	public Comic read(Integer id);

	public void update(Comic comic);

	public void delete(int id);
	
}
