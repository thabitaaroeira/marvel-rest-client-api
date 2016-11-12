package br.com.thabita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.thabita.business.CharacterBusiness;
import br.com.thabita.model.Character;

@Controller
@RequestMapping(value = { "", "/character" })
public class CharacterController {

	@Autowired
	private CharacterBusiness business;

	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		model.addAttribute("characters", business.getAll(null));
		return "character/index";
	}

	@RequestMapping(value = "create")
	public String create() {
		return "character/create";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Character character) {
		business.create(character);
		return "redirect:index";
	}

	@RequestMapping(value = "edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("character", business.read(id));
		return "character/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Character character) {
		business.update(character);
		return "redirect:index";
	}

	@RequestMapping(value = "/test")
	public String test() {
		return " hello world";
	}

}
