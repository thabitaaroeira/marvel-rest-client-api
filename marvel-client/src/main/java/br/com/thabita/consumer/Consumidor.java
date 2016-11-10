package br.com.thabita.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.thabita.business.BancoBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;
import br.com.thabita.model.util.BaseEntidade;
import br.com.thabita.model.util.ConjuntoDados;
import br.com.thabita.model.util.Resultado;
import br.com.thabita.service.IMarvelAPI;
import br.com.thabita.service.MarvelAPICliente;

@Component
public class Consumidor {

	@Value("${key.public}")
	private String publicKey;

	@Value("${key.private}")
	private String privateKey;

	private IMarvelAPI api;

	private BancoBusiness comicBusiness;
	private BancoBusiness charBusiness;
	private BancoBusiness creatorBusiness;

	public Consumidor() {
		this.api = MarvelAPICliente.newInstance(publicKey, privateKey);

		List<Comic> comics = initComics();
		this.comicBusiness = new BancoBusiness(comics);

		List<Character> chars = initChars();
		this.charBusiness = new BancoBusiness(chars);

		List<Creator> creators = initCreators();
		this.creatorBusiness = new BancoBusiness(creators);
	}

	public List<Comic> initComics() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Comic> resultado = api.getComics(params);
		ConjuntoDados<Comic> dados = resultado.getDados();
		return dados.getValores();
	}

	public List<Character> initChars() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Character> resultado = api.getCharacters(params);
		ConjuntoDados<Character> dados = resultado.getDados();
		return dados.getValores();
	}

	public List<Creator> initCreators() {
		Map<String, Object> params = new HashMap<String, Object>();
		Resultado<Creator> resultado = api.getCreators(params);
		ConjuntoDados<Creator> dados = resultado.getDados();
		return dados.getValores();
	}

	public List<Comic> getAllComics() {
		return comicBusiness.getEntidades();
	}

	public void createComic(Comic entidade) {
		comicBusiness.create(entidade);
	}

	public void readComic(Integer id) {
		comicBusiness.read(id);
	}

	public void updateComic(Comic entidade) {
		comicBusiness.update(entidade);
	}

	public void deleteComic(Comic entidade) {
		comicBusiness.delete(entidade);
	}

	public List<Character> getAllCharacters() {
		return charBusiness.getEntidades();
	}

	public void createCharacter(Character entidade) {
		charBusiness.create(entidade);
	}

	public void readCharacter(Integer id) {
		charBusiness.read(id);
	}

	public void updateCharacter(Character entidade) {
		charBusiness.update(entidade);
	}

	public void deleteCharacter(Character entidade) {
		charBusiness.delete(entidade);
	}

	public List<Creator> getAllCreators() {
		return creatorBusiness.getEntidades();
	}

	public void createCreator(Creator entidade) {
		creatorBusiness.create(entidade);
	}

	public void readCreator(Integer id) {
		creatorBusiness.read(id);
	}

	public void updateCreator(Creator entidade) {
		creatorBusiness.update(entidade);
	}

	public void deleteCreator(Creator entidade) {
		creatorBusiness.delete(entidade);
	}

}
