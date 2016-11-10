package br.com.thabita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.thabita.business.impl.CharacterBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;

public class CharacterTest extends BaseTest {

	@Autowired
	private CharacterBusiness business;

	@Test
	public void testaAdiciona() {
		Comic comic = buildComic();
		Character entidade = buildCharacter();
		entidade.setComics(Arrays.asList(comic));
		comic.setCharacters(Arrays.asList(entidade));
		business.create(entidade);

		Character busca = business.read(entidade.getId());
		assertEquals(entidade.getName(), busca.getName());
	}

	@Test
	public void testaRemove() {
		Character entidade = buildCharacter();
		business.create(entidade);

		business.delete(entidade.getId());

		Character busca = business.read(entidade.getId());
		assertNull(busca);
	}

	@Test
	public void testaAltera() {
		Comic comic = buildComic();
		Character entidade = buildCharacter();
		entidade.setComics(Arrays.asList(comic));
		comic.setCharacters(Arrays.asList(entidade));
		business.create(entidade);

		entidade.setDescription("Nova Descricao");
		business.update(entidade);

		Character busca = business.read(entidade.getId());
		assertEquals(entidade.getDescription(), busca.getDescription());
	}

}
