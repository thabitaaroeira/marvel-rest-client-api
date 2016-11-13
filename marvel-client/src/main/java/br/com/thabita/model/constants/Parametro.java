package br.com.thabita.model.constants;

/**
 * Parametros utilizados na Query.
 */
public enum Parametro {

	NAME("name"), NAME_STARTS_WITH("nameStartsWith"), MODIFIED_SINCE("modifiedSince"),

	FIRST_NAME("firstName"), MIDDLE_NAME("middleName"), LAST_NAME("lastName"), SUFFIX("suffix"), FIRST_NAME_STARTS_WITH(
			"firstNameStartsWith"), MIDDLE_NAME_STARTS_WITH(
					"middleNameStartsWith"), LAST_NAME_STARTS_WITH("lastNameStartsWith"),

	/**
	 * Entidades possiveis de retorno:
	 */
	COMICS("comics"), CREATORS("creators"), EVENTS("events"), SERIES("series"), STORIES("stories"),

	/**
	 * Valores podem ser preenchidos a partir de
	 * {@link br.com.thabita.model.constantes.Ordenacao}
	 */
	ORDER_BY("orderBy"), TITLE("title"), TITLE_STARTS_WITH("titleStartsWith"),

	/**
	 * Valores podem ser: comic, magazine, trade paperback, hardcover, digest,
	 * graphic novel, digital comic, infinite comic.
	 */
	FORMAT("format"),

	/**
	 * Valores podem ser: comic, collection.
	 */
	FORMAT_TYPE("formatType"),

	/**
	 * Aceitam apenas valor boolean TRUE.
	 */
	NO_VARIANTES("noVariants"), ISSUE_NUMBER("issueNumber"), DIAMOND_CODE("diamondCode"), DIGITAL_ID("digitalId"), UPC("upc"), ISBN("isbn"), EAN("ean"), ISSN("issn"),

	/**
	 * Aceitam apenas valor boolean TRUE.
	 */
	HAS_DIGITAL_ISSUE("hasDigitalIssue"), SHARED_APPEARANCES("sharedAppearances"), COLLABORATORS("collaborators"), SERIES_TYPE("seriesType"), CONTAINS("contains"),

	/**
	 * Valores podem ser: thisWeek, lastWeek, nextWeek, thisMonth.
	 */
	DATE_DESCRIPTOR("dateDescriptor"), DATE_RANGE("dateRange"), START_YEAR("startYear"), OFFSET("offset"), LIMIT("limit");

	private Parametro(String name) {
		this.name = name;
	}

	private String name;

	/**
	 * @return nome do Parametro
	 */
	public String getName() {
		return name;
	}

}
