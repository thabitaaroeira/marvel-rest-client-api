package br.com.thabita.model;

/**
 * Tipo de Sumário utilizado por Stories e Series (Histórias e Séries). Segundo
 * documentação oficial: <br/>
 * Some summary representations will additionally have a field describing its
 * type or the relationship between the returned entity and the referenced
 * entity.
 */
public class TypeSummary extends Summary {

	/**
	 * Tipo do sumário
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
