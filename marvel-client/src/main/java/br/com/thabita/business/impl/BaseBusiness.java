package br.com.thabita.business.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import br.com.thabita.consumer.MarvelAPICliente;
import br.com.thabita.consumer.MarvelAPIClienteImpl;

/**
 * Abstrai a comunicaçao com o cliente da API Marvel construída. Todos os
 * Business tem acesso a esta.
 * 
 * @author thabita
 */
public abstract class BaseBusiness {

	/**
	 * Presente em application.properties
	 */
	@Value("${key.public}")
	private String publicKey;

	/**
	 * Presente em application.properties
	 */
	@Value("${key.private}")
	private String privateKey;

	private MarvelAPICliente api;

	public MarvelAPICliente getApi() {
		return api;
	}

	/**
	 * Instancia o Cliente da API Marvel com as duas chaves do usuário.
	 */
	@PostConstruct
	public void init() {
		this.api = MarvelAPIClienteImpl.newInstance(publicKey, privateKey);
	}

}
