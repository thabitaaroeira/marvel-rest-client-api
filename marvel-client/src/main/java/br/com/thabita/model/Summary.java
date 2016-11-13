package br.com.thabita.model;

/**
 * Sumário de entidades. Segundo documentação oficial: <br/>
 * Summary views will always contain a resourceURI, which points to the full
 * representation of the referenced entity, and a name, for convenience.
 */
public class Summary {

	/**
	 * O caminho (uri) para o resource específico.
	 */
	private String resourceURI;

	/**
	 * O nome associado ao caminho/uri.
	 */
	private String name;

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
