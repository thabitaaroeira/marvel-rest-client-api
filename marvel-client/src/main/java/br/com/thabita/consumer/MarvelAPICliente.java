package br.com.thabita.consumer;

import java.util.List;
import java.util.Map;

import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;

/**
 * Interface que expõe os métodos possíveis.
 */
public interface MarvelAPICliente {

	/**
	 * Busca uma lista de Characters.
	 * 
	 * @param queryParams
	 * @return List<Character>
	 */
	List<Character> getCharacters(Map<String, Object> queryParams);

	/**
	 * Busca um Character por id.
	 * 
	 * @param characterId
	 * @return List<Character>
	 */
	List<Character> getCharacter(Integer characterId);

	/**
	 * Busca uma lista de Comics filtradas por um Character id.
	 * 
	 * @param characterId
	 * @param queryParams
	 * @return List<Comic>
	 */
	List<Comic> getCharacterComics(Integer characterId, Map<String, Object> queryParams);

	/**
	 * Busca uma lista de Comics com filtros opcionais.
	 * 
	 * @param queryParams
	 * @return List<Comic>
	 */
	List<Comic> getComics(Map<String, Object> queryParams);

	/**
	 * Busca uma Coomic por id.
	 *
	 * @param comicId
	 * @return List<Comic>
	 */
	List<Comic> getComic(Integer comicId);

	/**
	 * Busca uma lista de Characters filtrados por uma Comic id.
	 * 
	 * @param comicId
	 * @param queryParams
	 * @return List<Character>
	 */
	List<Character> getComicCharacters(Integer comicId, Map<String, Object> queryParams);

	/**
	 * Busca uma lista de Creators filtrada por uma Comic id.
	 * 
	 * @param comicId
	 * @param queryParams
	 * @return List<Creator>
	 */
	List<Creator> getComicCreators(Integer comicId, Map<String, Object> queryParams);

	/**
	 * Busca todos os Creators de Comics com filtros opcionais.
	 * 
	 * @param queryParams
	 * @return List<Creator>
	 */
	List<Creator> getCreators(Map<String, Object> queryParams);

	/**
	 * Busca um unico Creator por id.
	 *
	 * @param creatorId
	 * @return List<Creator>
	 */
	List<Creator> getCreator(Integer creatorId);

	/**
	 * Busca uma lista de Comics filtradas por Creator id.
	 * 
	 * @param creatorId
	 * @param queryParams
	 * @return List<Comic>
	 */
	List<Comic> getCreatorComics(Integer creatorId, Map<String, Object> queryParams);

}
