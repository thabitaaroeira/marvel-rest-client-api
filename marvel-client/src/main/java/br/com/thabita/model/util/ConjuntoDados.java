package br.com.thabita.model.util;

import java.util.List;

/**
 * Conjunto de dados que contem toda a info relacionada aos resultados
 * retornados pela API.
 */
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
	private List<T> valores;

	public List<T> getValores() {
		return this.valores;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setValores(List<T> valores) {
		this.valores = valores;
	}

}
