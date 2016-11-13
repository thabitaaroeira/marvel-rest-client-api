package br.com.thabita.business;

import java.util.List;
import java.util.Map;

import br.com.thabita.model.Creator;

/**
 * Interface de métodos CRUD de Criadores, com o banco em memória.
 */
public interface CreatorBusiness {

	/**
	 * Cria um novo Criador no banco em memória local.
	 * 
	 * @param creator
	 * @return Creator
	 */
	public Creator create(Creator creator);

	/**
	 * Lê (busca por id) um Criador do banco em memória local. Caso este não
	 * seja encontrado, a chamada é repassada à API Marvel.
	 * 
	 * @param id
	 * @return Creator
	 */
	public Creator read(Integer id);

	/**
	 * Atualiza um Criador no banco em memória.
	 * 
	 * @param creator
	 * @return Creator
	 */
	public Creator update(Creator creator);

	/**
	 * Remove um Criador por id do banco em memória.
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * Busca Criadores por parametros, podendo o mapa estar null ou vazio. Os
	 * parametros a utilizar podem ser encontrados em
	 * {@link br.com.thabita.model.constants.Parametro}. Também podem ser
	 * enviadas opções de ordenação, que existem em
	 * {@link br.com.thabita.model.constants.Ordenacao}. Esta chamada será
	 * repassada à API Marvel.
	 * 
	 * @param parametros
	 * @return List<Creator>
	 */
	public List<Creator> getAll(Map<String, Object> parametros);

}
