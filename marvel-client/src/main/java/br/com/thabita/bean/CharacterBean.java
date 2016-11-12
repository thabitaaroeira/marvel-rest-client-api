package br.com.thabita.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.constants.Parametro;
import lombok.Getter;
import lombok.Setter;;

@Controller
@ManagedBean(name = "characterBean", eager = true)
@ViewScoped
@Component
public class CharacterBean {

	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public ModelAndView character() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("character");
		return mav;
	}

	static Logger log = Logger.getLogger(CharacterBean.class);

	@Autowired
	private CharacterBusiness business;

	@Getter
	@Setter
	private Character filtro;

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
		this.characters = new ArrayList<Character>();
		// this.characters.addAll(business.getAll());
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
		log.info("Buscando Personagem por id");
		this.character = business.read(this.characterId);
	}

	public void pesquisar() {
		log.info("Pesquisando por nome");
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(Parametro.NAME.name(), filtro.getName());
		this.characters = business.getAll(parametros);
	}

}
