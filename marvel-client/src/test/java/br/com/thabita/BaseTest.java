package br.com.thabita;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import br.com.thabita.model.Character;
import br.com.thabita.model.Comic;
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

	protected Comic buildComic() {
		String random = RandomStringUtils.random(10);
		Comic comic = new Comic();
		comic.setDescription(random);
		comic.setDiamondCode(random);
		comic.setDigitalId(RandomUtils.nextInt(0, 9));
		comic.setEan(random);
		comic.setFormat(random);
		comic.setIsbn(random);
		comic.setIssn(random);
		comic.setIssueNumber(RandomUtils.nextDouble(0, 9));
		comic.setModified(new Date());
		comic.setPageCount(RandomUtils.nextInt(0, 9));
		comic.setResourceURI(random);
		comic.setTitle(random);
		comic.setUpc(random);
		comic.setVariantDescription(random);
		return comic;
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
