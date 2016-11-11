package br.com.thabita.business;

import java.util.List;

import br.com.thabita.model.Character;

public interface CharacterBusiness {

	public Character create(Character character);

	public Character read(Integer id);

	public Character update(Character character);

	public void delete(int id);
	
	public List<Character> getAll();

}
