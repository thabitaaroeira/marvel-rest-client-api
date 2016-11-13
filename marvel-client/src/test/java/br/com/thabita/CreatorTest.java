package br.com.thabita;

import java.util.Arrays;
import java.util.List;

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

import br.com.thabita.model.Creator;
import br.com.thabita.model.constants.Ordenacao;
import br.com.thabita.model.constants.Parametro;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreatorTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(CreatorTest.class);

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String URI = URI_ROOT + "/creators";

	@Test
	public void getAll() {
		// orderBy id por padrao
		Creator[] result = restTemplate.getForObject(URI, Creator[].class);
		logger.debug(result.toString());
		List<Creator> creators = Arrays.asList(result);
		Assert.assertFalse(creators.isEmpty());
		Creator creator = null;
		for (Creator c : creators) {
			if (c.getId().equals(7968)) {
				creator = c;
				break;
			}
		}
		// Base de dados Marvel
		Assert.assertEquals("", creator.getFullName());
		Assert.assertEquals("http://gateway.marvel.com/v1/public/creators/7968", creator.getResourceURI());
	}

	@Test
	public void getById() {
		// Base de dados Local
		Creator entidade = createCreator();
		ResponseEntity<Creator> entity = restTemplate.getForEntity(getURIWithId(entidade, URI), Creator.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		Assert.assertEquals(entity.getBody().getFullName(), entidade.getFullName());

		// Base de dados Marvel
		entity = restTemplate.getForEntity(URI + "/" + 6606, Creator.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		entidade = entity.getBody();
		Assert.assertTrue(entidade.getId() == 6606);
		Assert.assertEquals(entidade.getFullName(), "A.R.K.");
	}

	@Test
	public void getByName() {
		// Retorno unico
		String firstName = "Stan";
		String lastName = "Lee";

		StringBuilder uri = new StringBuilder();
		uri.append(URI);
		uri.append("?");
		uri.append(Parametro.FIRST_NAME.getName());
		uri.append("=");
		uri.append(firstName);
		uri.append("&");
		uri.append(Parametro.LAST_NAME.getName());
		uri.append("=");
		uri.append(lastName);
		uri.append("&");
		uri.append(Parametro.ORDER_BY.getName());
		uri.append("=");
		uri.append(Ordenacao.FIRST_NAME.getValue());

		Creator[] result = restTemplate.getForObject(uri.toString(), Creator[].class);
		List<Creator> creators = Arrays.asList(result);
		logger.debug(creators.toString());
		Assert.assertFalse(creators.isEmpty());

		boolean contains = false;
		for (Creator creator : creators) {
			if (creator.getId().equals(30)) {
				contains = true;
				break;
			}
		}
		Assert.assertTrue(contains);
	}

	@Test
	public void add() {
		Creator entidade = buildCreator();
		ResponseEntity<Creator> entity = restTemplate.postForEntity(URI, entidade, Creator.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());

		Creator created = entity.getBody();
		Assert.assertNotNull(created.getId());
		Assert.assertEquals(created.getFullName(), entidade.getFullName());
	}

	@Test
	public void remove() {
		Creator entidade = createCreator();

		String uri = getURIWithId(entidade, URI);
		logger.debug(uri);

		restTemplate.delete(uri);

		ResponseEntity<Creator> entity = restTemplate.getForEntity(uri, Creator.class);
		logger.debug(entity.toString());
		Creator creator = entity.getBody();
		Assert.assertFalse(entidade.getId() != creator.getId());
	}

	@Test
	public void update() {
		Creator entidade = createCreator();

		String uri = getURIWithId(entidade, URI);
		entidade.setLastName("Novossobrenome");
		restTemplate.put(uri, entidade);

		ResponseEntity<Creator> entity = restTemplate.getForEntity(uri, Creator.class);
		logger.debug(entity.toString());
		Assert.assertNotNull(entity.getBody());
		Assert.assertEquals(entidade.getFullName(), entity.getBody().getFullName());
	}

	public Creator createCreator() {
		Creator entidade = buildCreator();
		ResponseEntity<Creator> entity = restTemplate.postForEntity(URI, entidade, Creator.class);
		logger.debug(entity.toString());
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertNotNull(entity.getBody().getId());
		entidade = entity.getBody();
		return entidade;
	}

}
