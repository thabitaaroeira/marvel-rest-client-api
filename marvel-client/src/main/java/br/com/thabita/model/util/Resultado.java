package br.com.thabita.model.util;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Result of the API request.</p>
 * <p>Results returned by the API endpoints have the same general format, no matter which entity type the endpoint returns.</p>
 * <p>Every successful call will return a wrapper object, which contains metadata about the call and a container object, which displays pagination information and an array of the results returned by this call.</p>
 * <p>This pattern is consistent even if you are requesting a single object.</p>
 */
@SuppressWarnings("unused")
@Getter
@Setter
@XmlRootElement
public class Resultado<T> {

    /**
     * The HTTP status code of the returned result
     */
    private Integer code;

    /**
     * A string description of the call status
     */
    private String status;

    /**
     * The copyright notice for the returned result
     */
    private String copyright;

    /**
     * The attribution notice for this result
     */
    private String attributionText;

    /**
     * An HTML representation of the attribution notice for this result
     */
    private String attributionHTML;

    /**
     * A digest value of the content
     */
    private String etag;

    /**
     * The results returned by the call
     */
    private ConjuntoDados<T> data;

}
