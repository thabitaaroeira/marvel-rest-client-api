package br.com.thabita.business.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import br.com.thabita.consumer.MarvelAPICliente;
import br.com.thabita.consumer.MarvelAPIClienteImpl;

public abstract class BaseBusiness {

	@Value("${key.public}")
	protected String publicKey;

	@Value("${key.private}")
	protected String privateKey;

	private MarvelAPICliente api;

	public BaseBusiness() {
	}

	public MarvelAPICliente getApi() {
		return api;
	}

	public void setApi(MarvelAPICliente api) {
		this.api = api;
	}

	@PostConstruct
	public void init() {
		this.api = MarvelAPIClienteImpl.newInstance(publicKey, privateKey);
	}

}
