package br.com.thabita;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.thabita.model.Character;
import br.com.thabita.model.Creator;

public class BaseTest {

	protected Character buildCharacter() {
		String random = RandomStringUtils.random(10);
		Character entidade = new Character();
		entidade.setName(random);
		entidade.setDescription(random);
		entidade.setModified(new Date());
		entidade.setResourceURI(random);
		return entidade;
	}

	protected Creator buildCreator() {
		String random = RandomStringUtils.random(10);
		Creator creator = new Creator();
		creator.setFirstName(random);
		creator.setFullName(random);
		creator.setLastName(random);
		creator.setMiddleName(random);
		creator.setModified(new Date());
		creator.setResourceURI(random);
		creator.setSuffix(random);
		return creator;
	}

}
