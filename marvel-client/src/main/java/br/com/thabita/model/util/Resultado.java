package br.com.thabita.model.util;

/**
 * Resultado da requisicao da API. <br/>
 * Os resultados retornados pelos endpoints da API tem o mesmo formato em geral,
 * nao importa o tipo de entidade que o endpoint retorna. <br/>
 * Toda chamada de sucesso vai retornar um objeto encapsulador que contem
 * metadados sobre a chamada um ConjuntoDados que exibe a informacao de
 * paginacao e um array dos resultados retornados por esta chamada. <br/>
 * Este padrao eh consistente mesmo que seja requisitado um unico objeto. <br/>
 */
public class Resultado<T> {

	/**
	 * The HTTP status code of the returned result
	 */
	private Integer code;

	/**
	 * A string description of the call status
	 */
	private String status;

	/**
	 * The copyright notice for the returned result
	 */
	private String copyright;

	/**
	 * The attribution notice for this result
	 */
	private String attributionText;

	/**
	 * An HTML representation of the attribution notice for this result
	 */
	private String attributionHTML;

	/**
	 * A digest value of the content
	 */
	private String etag;

	/**
	 * The results returned by the call
	 */
	private ConjuntoDados<T> dados;

	public ConjuntoDados<T> getDados() {
		return this.dados;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public void setDados(ConjuntoDados<T> dados) {
		this.dados = dados;
	}

}
