package br.com.thabita.model;

import br.com.thabita.util.BaseEntidade;

/**
 * Representacao de entidade Character
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Character extends BaseEntidade {

    /**
     * The name of the character.
     */
    private String name;

    /**
     * A short bio or description of the character.
     */
    private String description;
	
	/**
	 * The unique ID of the character resource.
	 */
	private Integer id;

	/**
	 * Resource URIs are references to the representation of a resource within
	 * the API.
	 */
	private String resourceURI;

	/**
	 * The date the resource was most recently modified.
	 */
	private Date modified;
	
	/**
	 * A resource list containing comics which feature this character.
	 */
	private ResourceList<Summary> comics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// TODO gerar getters and setters

}
