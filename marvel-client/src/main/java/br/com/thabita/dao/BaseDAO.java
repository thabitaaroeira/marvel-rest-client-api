package br.com.thabita.dao;

import org.springframework.beans.factory.annotation.Value;

import br.com.thabita.consumer.IMarvelAPI;
import br.com.thabita.consumer.MarvelAPICliente;

public abstract class BaseDAO {

	@Value("${key.public}")
	protected String publicKey;

	@Value("${key.private}")
	protected String privateKey;

	private IMarvelAPI api;

	public BaseDAO() {
		this.api = MarvelAPICliente.newInstance(publicKey, privateKey);
	}

	public IMarvelAPI getApi() {
		return api;
	}

	public void setApi(IMarvelAPI api) {
		this.api = api;
	}

}
