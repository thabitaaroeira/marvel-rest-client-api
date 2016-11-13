package br.com.thabita;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import br.com.thabita.model.constants.Parametro;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharacterTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(CharacterTest.class);

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
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		Assert.assertEquals(entity.getBody().getName(), entidade.getName());
	}

//	@Test
	public void getByName() {
		Character[] object = restTemplate.getForObject(URI, Character[].class, createParameters("Rogue", "name"));
		List<Character> characters = Arrays.asList(object);
		logger.debug(characters.toString());
		Assert.assertFalse(characters.isEmpty());

		boolean contains = false;
		for (Character character : characters) {
			if (character.getId().equals(1009546)) {
				contains = true;
			}
		}
		Assert.assertTrue(contains);
	}

	public Map<String, Object> createParameters(String nome, String orderBy) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (nome != null) {
			params.put(Parametro.NAME.getName(), nome);
		}
		if (nome != null) {
			params.put(Parametro.ORDER_BY.getName(), orderBy);
		}
		return params;
	}

	public String getURIWithId(Character entidade) {
		return URI + "/" + entidade.getId();
	}

	@Test
	public void add() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());

		Character created = entity.getBody();
		Assert.assertNotNull(created.getId());
		Assert.assertEquals(created.getName(), entidade.getName());
	}

	@Test
	public void remove() {
		Character entidade = createCharacter();

		String uri = getURIWithId(entidade);
		logger.debug(uri);
		
		restTemplate.delete(uri);

		ResponseEntity<Character> entity = restTemplate.getForEntity(uri, Character.class);
		logger.debug(entity.toString());
		Assert.assertNull(entity.getBody());
	}

	@Test
	public void update() {
		Character entidade = createCharacter();

		entidade.setDescription("Nova Descricao");
		restTemplate.put(getURIWithId(entidade), entidade);

		ResponseEntity<Character> entity = restTemplate.getForEntity(getURIWithId(entidade), Character.class);
		logger.debug(entity.toString());
		Assert.assertNotNull(entity.getBody());
		Assert.assertEquals(entidade.getDescription(), entity.getBody().getDescription());
	}

	public Character createCharacter() {
		Character entidade = buildCharacter();
		ResponseEntity<Character> entity = restTemplate.postForEntity(URI, entidade, Character.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		entidade = entity.getBody();
		return entidade;
	}

}
