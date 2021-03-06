package br.com.thabita.model;

import java.util.List;

/**
 * Lista de objetos retornados nas chamadas. Segundo documentação oficial: <br/>
 * Resource lists are collections of summary views within the context of another
 * entity type. <br/>
 * For example, the list of creators attached to a comic would be presented as
 * resource list inside the full representation of that comic.
 */
public class ResourceList<T> {

	/**
	 * The number of total available resources in this list
	 */
	private Integer available;

	/**
	 * The number of resources returned in this resource list (up to 20).
	 */
	private Integer returned;

	/**
	 * The path to the list of full view representations of the items in this
	 * resource list.
	 */
	private String collectionURI;

	/**
	 * A list of summary views of the items in this resource list.
	 */
	private List<T> items;

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getReturned() {
		return returned;
	}

	public void setReturned(Integer returned) {
		this.returned = returned;
	}

	public String getCollectionURI() {
		return collectionURI;
	}

	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
