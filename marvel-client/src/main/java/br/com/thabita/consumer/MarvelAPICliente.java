package br.com.thabita.consumer;

import java.util.Map;

import br.com.thabita.model.Character;
import br.com.thabita.model.Creator;
import br.com.thabita.model.Result;

/**
 * Interface que expõe os métodos possíveis.
 */
public interface MarvelAPICliente {

	/**
	 * Busca uma lista de Characters.
	 * 
	 * @param queryParams
	 * @return
	 */
	Result<Character> getCharacters(Map<String, Object> queryParams);

	/**
	 * Busca um Character por id.
	 * 
	 * @param characterId
	 * @return
	 */
	Result<Character> getCharacter(Integer characterId);

	/**
	 * Busca todos os Creators de Comics com filtros opcionais.
	 * 
	 * @param queryParams
	 * @return
	 */
	Result<Creator> getCreators(Map<String, Object> queryParams);

	/**
	 * Busca um unico Creator por id.
	 *
	 * @param creatorId
	 * @return
	 */
	Result<Creator> getCreator(Integer creatorId);

}
