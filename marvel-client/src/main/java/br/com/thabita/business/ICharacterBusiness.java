package br.com.thabita.business;

import br.com.thabita.model.Character;

public interface ICharacterBusiness {

	public void create(Character character);

	public Character read(Integer id);

	public void update(Character character);

	public void delete(int id);

}
