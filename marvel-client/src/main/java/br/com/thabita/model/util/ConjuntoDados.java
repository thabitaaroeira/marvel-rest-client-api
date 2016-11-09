package br.com.thabita.model.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Conjunto de dados que contem toda a info relacionada aos resultados
 * retornados pela API.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ConjuntoDados<T> {

	/**
	 * The requested offset (skipped results) of the call
	 */
	private int offset;

	/**
	 * The requested result limit
	 */
	private int limit;

	/**
	 * The total number of results available
	 */
	private int total;

	/**
	 * The total number of results returned by this call
	 */
	private int count;

	/**
	 * The list of entities returned by the call
	 */
	List<T> results;

}
