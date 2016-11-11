package br.com.thabita.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.thabita.business.impl.CharacterBusiness;
import br.com.thabita.model.Character;
import lombok.Getter;
import lombok.Setter;;

@RequestMapping("/")
@Component
@Scope("session")
public class CharacterBean {

	static Logger log = Logger.getLogger(CharacterBean.class);

	@Autowired
	private CharacterBusiness business;

	@Getter
	@Setter
	private Character character;

	@Getter
	@Setter
	private List<Character> characters;

	@Getter
	@Setter
	private Integer characterId;

	@PostConstruct
	public void init() {
		this.character = new Character();
		this.characters = business.getAll();
	}

	public void gravar() {
		log.info("Gravando Personagem " + this.character.getName());

		if (this.character.getId() == null) {
			this.character = business.create(character);
		} else {
			this.character = business.update(character);
		}

		this.character = new Character();
	}

	public void carregar(Character character) {
		log.info("Carregando Personagem");
		this.character = character;
	}

	public void remover(Character character) {
		log.info("Removendo Personagem");
		business.delete(character.getId());
	}

	public void carregarCharacterPorId() {
		this.character = business.read(this.characterId);
	}

}
