package br.com.thabita.model.constants;

/**
 * Parametros utilizados na Query.
 */
public enum Parametro {
	
	//@formatter:off
    NAME("name"),
    NAME_STARTS_WITH("nameStartsWith"),
    MODIFIED_SINCE("modifiedSince"),

    FIRST_NAME("firstName"),
    MIDDLE_NAME("middleName"),
    LAST_NAME("lastName"),
    SUFFIX("suffix"),
    FIRST_NAME_STARTS_WITH("firstNameStartsWith"),
    MIDDLE_NAME_STARTS_WITH("middleNameStartsWith"),
    LAST_NAME_STARTS_WITH("lastNameStartsWith"),

    COMICS("comics"),
    CREATORS("creators"),
    EVENTS("events"),
    SERIES("series"),
    STORIES("stories"),
    /**
     * Values can be assigned from {@link com.pcab.marvel.model.common.OrderBy}
     */
    ORDER_BY("orderBy"),
    TITLE("title"),
    TITLE_STARTS_WITH("titleStartsWith"),
    /**
     * Values can be assigned from {@link com.pcab.marvel.model.comic.Format}
     */
    FORMAT("format"),
    /**
     * Values can be assigned from {@link com.pcab.marvel.model.comic.FormatType}
     */
    FORMAT_TYPE("formatType"),
    /**
     * Only accepts TRUE boolean value
     */
    NO_VARIANTES("noVariants"),
    ISSUE_NUMBER("issueNumber"),
    DIAMOND_CODE("diamondCode"),
    DIGITAL_ID("digitalId"),
    UPC("upc"),
    ISBN("isbn"),
    EAN("ean"),
    ISSN("issn"),
    /**
     * Only accepts TRUE boolean value
     */
    HAS_DIGITAL_ISSUE("hasDigitalIssue"),
    SHARED_APPEARANCES("sharedAppearances"),
    COLLABORATORS("collaborators"),
    SERIES_TYPE("seriesType"),
    CONTAINS("contains"),
    /**
     * Values can be assigned from {@link com.pcab.marvel.model.common.DateDescriptor}
     */

    DATE_DESCRIPTOR("dateDescriptor"),
    DATE_RANGE("dateRange"),
    START_YEAR("startYear"),
    OFFSET("offset"),
    LIMIT("limit");
	//@formatter:on

    private Parametro(String name){
        this.name = name;
    }

    private String name;

    /**
     * Retrieves the string query parameter name.
     *
     * @return String representation of the name of the query parameter.
     */
    public String getName(){
        return name;
    }

}
