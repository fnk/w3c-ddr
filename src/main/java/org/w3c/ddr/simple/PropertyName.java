package org.w3c.ddr.simple;

/**
 * This class represents the name of a property, drawn from a particular vocabulary (which is identified by a unique namespace).
 * Refer to the vocabulary definition for the list of terms, their formal names (IDs) and their semantics.
 * 
 * @author Jo Rabin (dotMobi) 
 * @author <br/>Jose Manuel Cantera Fonseca (Telefonica I+D) 
 * @author <br/>Rotan Hanrahan (MobileAware) 
 * @author <br/>Ignacio Marin (Fundacion CTIC) <br/>
 * <a href="http://www.w3.org/Consortium/Legal/ipr-notice#Copyright">Copyright</a>
 * &copy; 2008 <a href="http://www.w3.org/"><acronym title="World Wide Web Consortium">W3C</acronym></a><sup>&reg;</sup>
 * (<a href="http://www.csail.mit.edu/"><acronym title="Massachusetts Institute of Technology">MIT</acronym></a>,
 * <a href="http://www.ercim.org/"><acronym title="European Research Consortium for Informatics and Mathematics">ERCIM</acronym></a>,
 * <a href="http://www.keio.ac.jp/">Keio</a>), All Rights Reserved.<br/>
 * W3C <a href="http://www.w3.org/Consortium/Legal/ipr-notice#Legal_Disclaimer">liability</a>,
 * <a href="http://www.w3.org/Consortium/Legal/ipr-notice#W3C_Trademarks">trademark</a>
 * and <a href="http://www.w3.org/Consortium/Legal/copyright-documents">document use</a> rules apply.
 * 
 * @see PropertyRef
 * @see Service#newPropertyName(java.lang.String)
 */
public interface PropertyName {
	/**
	 * The formal name (ID) of the property term from a vocabulary of property terms.
   * The names are locally unique within their vocabulary.
	 * 
	 * @return The formal name of the term from its vocabulary.
	 */
	public String getLocalPropertyName();

	/**
	 * The namespace of the vocabulary containing the property term.
   * It is not a requirement that a namespace IRI can be dereferenced,
   * nor is it a requirement that any content obtained by dereferencing a namespace IRI can be machine-interpreted.
	 * 
	 * @return An IRI.
	 */
	public String getNamespace();

}
