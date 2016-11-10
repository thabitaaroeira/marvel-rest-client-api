package br.com.thabita.business.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import br.com.thabita.consumer.IMarvelAPI;
import br.com.thabita.consumer.MarvelAPICliente;

public abstract class BaseBusiness {

	@Value("${key.public}")
	protected String publicKey;

	@Value("${key.private}")
	protected String privateKey;

	private IMarvelAPI api;

	public BaseBusiness() {
	}

	public IMarvelAPI getApi() {
		return api;
	}

	public void setApi(IMarvelAPI api) {
		this.api = api;
	}

	@PostConstruct
	public void init() {
		this.api = MarvelAPICliente.newInstance(publicKey, privateKey);
	}

}
