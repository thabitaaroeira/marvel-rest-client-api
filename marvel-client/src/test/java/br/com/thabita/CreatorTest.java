package br.com.thabita;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.thabita.model.Creator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreatorTest extends BaseTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String URI = "/api/creators";

	@Test
	public void getAll() {
		Creator[] object = restTemplate.getForObject(URI, Creator[].class);
		List<Creator> characters = Arrays.asList(object);
		Assert.assertFalse(characters.isEmpty());
	}

	@Test
	public void getById() {
		Creator entidade = createCreator();

		ResponseEntity<Creator> entity = restTemplate.getForEntity(getURIWithId(entidade), Creator.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		Assert.assertEquals(entity.getBody().getFullName(), entidade.getFullName());
	}

	public String getURIWithId(Creator entidade) {
		return URI + "/" + entidade.getId();
	}

	@Test
	public void add() {
		Creator entidade = buildCreator();
		ResponseEntity<Creator> entity = restTemplate.postForEntity(URI, entidade, Creator.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());

		Creator created = entity.getBody();
		Assert.assertNotNull(created.getId());
		Assert.assertEquals(created.getFullName(), entidade.getFullName());
	}

	@Test
	public void remove() {
		Creator entidade = createCreator();

		restTemplate.delete(getURIWithId(entidade), entidade);

		ResponseEntity<Creator> entity = restTemplate.getForEntity(getURIWithId(entidade), Creator.class);
		Assert.assertNull(entity.getBody());
	}

	@Test
	public void update() {
		Creator entidade = createCreator();

		entidade.setLastName("Novossobrenome");
		restTemplate.put(getURIWithId(entidade), entidade);

		ResponseEntity<Creator> entity = restTemplate.getForEntity(getURIWithId(entidade), Creator.class);
		Assert.assertNotNull(entity.getBody());
		Assert.assertEquals(entidade.getFullName(), entity.getBody().getFullName());
	}

	public Creator createCreator() {
		Creator entidade = buildCreator();
		ResponseEntity<Creator> entity = restTemplate.postForEntity(URI, entidade, Creator.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		entidade = entity.getBody();
		return entidade;
	}

}
