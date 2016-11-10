package br.com.thabita.business;

import br.com.thabita.model.Creator;

public interface ICreatorBusiness {

	public void create(Creator creator);

	public Creator read(Integer id);

	public void update(Creator creator);

	public void delete(int id);
	
}
