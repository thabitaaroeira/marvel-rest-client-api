package br.com.thabita.consumer;

import java.util.Map;

import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;
import br.com.thabita.util.Resultado;

/**
 * Interface que expõe os métodos possíveis.
 */
public interface IMarvelAPI {

	/**
	 * Busca uma lista de Characters.
	 * 
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Character> getCharacters(Map<String, Object> queryParams);

	/**
	 * Busca um Character por id.
	 *
	 * @param characterId
	 *            A single character id.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Character> getCharacter(Integer characterId);

	/**
	 * Busca uma lista de Comics filtradas por um Character id.
	 * 
	 * @param characterId
	 *            The character id.
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Comic> getCharacterComics(Integer characterId, Map<String, Object> queryParams);

	/**
	 * Busca uma lista de Comics com filtros opcionais.
	 * 
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Comic> getComics(Map<String, Object> queryParams);

	/**
	 * Busca uma Coomic por id.
	 *
	 * @param comicId
	 *            A single comic.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Comic> getComic(Integer comicId);

	/**
	 * Busca uma lista de Characters filtrados por uma Comic id.
	 * 
	 * @param comicId
	 *            A single comic.
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Character> getComicCharacters(Integer comicId, Map<String, Object> queryParams);

	/**
	 * Busca uma lista de Creators filtrada por uma Comic id.
	 * 
	 * @param comicId
	 *            A single comic.
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Creator> getComicCreators(Integer comicId, Map<String, Object> queryParams);

	/**
	 * Busca todos os Creators de Comics com filtros opcionais.
	 * 
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Creator> getCreators(Map<String, Object> queryParams);

	/**
	 * Busca um unico Creator por id.
	 *
	 * @param creatorId
	 *            A single creator id.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Creator> getCreator(Integer creatorId);

	/**
	 * Busca uma lista de Comics filtradas por Creator id.
	 * 
	 * @param creatorId
	 *            A single creator id.
	 * @param queryParams
	 *            Map containing the query parameters.
	 * @return The {@link br.com.thabita.util.Resultado} of the request.
	 */
	Resultado<Comic> getCreatorComics(Integer creatorId, Map<String, Object> queryParams);

}
