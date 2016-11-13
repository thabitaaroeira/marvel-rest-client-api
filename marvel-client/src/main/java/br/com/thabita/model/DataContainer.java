package br.com.thabita.model;

import java.util.List;

/**
 * Contêiner de dados que tem toda a informação relacionada ao resultado servido
 * pela API. Segundo documentação oficial: <br/>
 * Every successful call will return a wrapper object, which contains metadata
 * about the call and a container object, which displays pagination information
 * and an array of the results returned by this call.
 */
public class DataContainer<T> {

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

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
