package br.com.thabita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.thabita.business.ComicBusiness;
import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestConfig.class)
public class ComicTest extends BaseTest {

	@Autowired
	private ComicBusiness business;

	@Test
	public void testaAdiciona() {
		Comic entidade = buildComic();
		Character charac = buildCharacter();
		charac.setComics(Arrays.asList(entidade));
		entidade.setCharacters(Arrays.asList(charac));
		business.create(entidade);

		Comic busca = business.read(entidade.getId());
		assertEquals(entidade.getTitle(), busca.getTitle());
	}

	@Test
	public void testaRemove() {
		Comic entidade = buildComic();
		business.create(entidade);

		business.delete(entidade.getId());

		Comic busca = business.read(entidade.getId());
		assertNull(busca);
	}

	@Test
	public void testaAltera() {
		Comic entidade = buildComic();
		Character charac = buildCharacter();
		charac.setComics(Arrays.asList(entidade));
		entidade.setCharacters(Arrays.asList(charac));
		business.create(entidade);

		entidade.setTitle("Nova Descricao");
		business.update(entidade);

		Comic busca = business.read(entidade.getId());
		assertEquals("Nova Descricao", busca.getTitle());
	}

}
