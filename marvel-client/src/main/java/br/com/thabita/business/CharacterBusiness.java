package br.com.thabita.business;

import java.util.List;
import java.util.Map;

import br.com.thabita.model.Character;

/**
 * Interface de métodos CRUD de Personagens, com o banco em memória.
 */
public interface CharacterBusiness {

	/**
	 * Cria um novo Personagem no banco em memória local.
	 * 
	 * @param character
	 * @return Character
	 */
	public Character create(Character character);

	/**
	 * Lê (busca por id) um Personagem do banco em memória local. Caso este não
	 * seja encontrado, a chamada é repassada à API Marvel.
	 * 
	 * @param id
	 * @return Character
	 */
	public Character read(Integer id);

	/**
	 * Atualiza um Personagem no banco em memória.
	 * 
	 * @param character
	 * @return Character
	 */
	public Character update(Character character);

	/**
	 * Remove um Personagem por id do banco em memória.
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * Busca Personagens por parametros, podendo o mapa estar null ou vazio. Os
	 * parametros a utilizar podem ser encontrados em
	 * {@link br.com.thabita.model.constants.Parametro}. Também podem ser
	 * enviadas opções de ordenação, que existem em
	 * {@link br.com.thabita.model.constants.Ordenacao}. Esta chamada será
	 * repassada à API Marvel.
	 * 
	 * @param parametros
	 * @return List<Character>
	 */
	public List<Character> getAll(Map<String, Object> parametros);

}
