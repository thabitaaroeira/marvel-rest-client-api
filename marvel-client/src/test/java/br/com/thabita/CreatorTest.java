package br.com.thabita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.thabita.business.CreatorBusiness;
import br.com.thabita.model.Comic;
import br.com.thabita.model.Creator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestConfig.class)
public class CreatorTest extends BaseTest {

	@Autowired
	private CreatorBusiness business;

	@Test
	public void testaAdiciona() {
		Creator entidade = buildCreator();
		Comic comic = buildComic();
		comic.setCreators(Arrays.asList(entidade));
		entidade.setComics(Arrays.asList(comic));
		business.create(entidade);

		Creator busca = business.read(entidade.getId());
		assertEquals(entidade.getFullName(), busca.getFullName());
	}

	@Test
	public void testaRemove() {
		Creator entidade = buildCreator();
		business.create(entidade);

		business.delete(entidade.getId());

		Creator busca = business.read(entidade.getId());
		assertNull(busca);
	}

	@Test
	public void testaAltera() {
		Creator entidade = buildCreator();
		Comic comic = buildComic();
		comic.setCreators(Arrays.asList(entidade));
		entidade.setComics(Arrays.asList(comic));
		business.create(entidade);

		entidade.setFullName("Nova Descricao");
		business.update(entidade);

		Creator busca = business.read(entidade.getId());
		assertEquals("Nova Descricao", busca.getFullName());
	}

}
