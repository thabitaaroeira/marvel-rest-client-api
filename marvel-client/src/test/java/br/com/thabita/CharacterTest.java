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

import br.com.thabita.model.Character;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharacterTest extends BaseTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String URI = "/api/characters";

	@Test
	public void getAll() {
		Character[] object = restTemplate.getForObject(URI, Character[].class);
		List<Character> characters = Arrays.asList(object);
		Assert.assertFalse(characters.isEmpty());
	}

	@Test
	public void getById() {
		Character entidade = createCharacter();

		ResponseEntity<Character> entity = restTemplate.getForEntity(getURIWithId(entidade), Character.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		Assert.assertEquals(entity.getBody().getName(), entidade.getName());
	}

	public String getURIWithId(Character entidade) {
		return URI + "/" + entidade.getId();
	}

	@Test
	public void add() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());

		Character created = entity.getBody();
		Assert.assertNotNull(created.getId());
		Assert.assertEquals(created.getName(), entidade.getName());
	}

	@Test
	public void remove() {
		Character entidade = createCharacter();

		restTemplate.delete(getURIWithId(entidade), entidade);

		ResponseEntity<Character> entity = restTemplate.getForEntity(getURIWithId(entidade), Character.class);
		Assert.assertNull(entity.getBody().getId());
	}

	@Test
	public void update() {
		Character entidade = createCharacter();

		entidade.setDescription("Nova Descricao");
		restTemplate.put(getURIWithId(entidade), entidade);

		ResponseEntity<Character> entity = restTemplate.getForEntity(getURIWithId(entidade), Character.class);
		Assert.assertNotNull(entity.getBody());
		Assert.assertEquals(entidade.getDescription(), entity.getBody().getDescription());
	}

	public Character createCharacter() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		entidade = entity.getBody();
		return entidade;
	}

}
