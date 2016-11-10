package br.com.thabita.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.thabita.util.BaseEntidade;

/**
 * Representacao de entidade Comic
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Comic extends BaseEntidade {

	/**
	 * The ID of the digital comic representation of this comic. Will be 0 if
	 * the comic is not available digitally.
	 */
	private Integer digitalId;

	/**
	 * The canonical title of the comic.
	 */
	private String title;

	/**
	 * The number of the issue in the series (will generally be 0 for collection
	 * formats).
	 */
	private Double issueNumber;

	/**
	 * If the issue is a variant (e.g. an alternate cover, second printing, or
	 * director's cut), a text description of the variant.
	 */
	private String variantDescription;

	/**
	 * The preferred description of the comic.
	 */
	private String description;

	/**
	 * The ISBN for the comic (generally only populated for collection formats).
	 */
	private String isbn;

	/**
	 * The UPC barcode number for the comic (generally only populated for
	 * periodical formats).
	 */
	private String upc;

	/**
	 * The Diamond code for the comic.
	 */
	private String diamondCode;

	/**
	 * The EAN barcode for the comic.
	 */
	private String ean;

	/**
	 * The ISSN barcode for the comic.
	 */
	private String issn;

	/**
	 * The publication format of the comic e.g. comic, hardcover, trade
	 * paperback.
	 */
	private String format;

	/**
	 * The number of story pages in the comic.
	 */
	private Integer pageCount;

	/**
	 * A resource list containing the creators associated with this comic.
	 */
	private List<Creator> creators;

	/**
	 * A resource list containing the characters which appear in this comic.
	 */
	private List<Character> characters;

	public Integer getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Double issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getVariantDescription() {
		return variantDescription;
	}

	public void setVariantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getDiamondCode() {
		return diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<Creator> getCreators() {
		return creators;
	}

	public void setCreators(List<Creator> creators) {
		this.creators = creators;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

}
