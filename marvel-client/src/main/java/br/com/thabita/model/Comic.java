package br.com.thabita.model;

import java.util.List;

import br.com.thabita.model.util.BaseResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Comic resource representation.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class Comic extends BaseResource {

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

}
