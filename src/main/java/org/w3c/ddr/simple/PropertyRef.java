package org.w3c.ddr.simple;

/**
 * Represents a Property / Aspect combination.
 * The Property is as defined by the PropertyName class, comprising a term from a vocabulary and a namespace for that vocabulary.
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
 * @see Service#newPropertyRef(org.w3c.ddr.simple.PropertyName)
 * @see Service#newPropertyRef(org.w3c.ddr.simple.PropertyName, String localAspectName)
 * @see PropertyName
 */
public interface PropertyRef {
	
  /**
   * This constant value is used to support Vocabularies that do not distinguish Aspects.
   * 
   * <br/><br/>The value of this constant shall be "__NULL".
   */
	public static final String NULL_ASPECT = "__NULL";

	/**
	 * The name of the property, according to a vocabulary of property terms.
	 * 
	 * @return A term from a vocabulary (for use as a property identifier).
	 */
	public String getLocalPropertyName();

	/**
	 * The name of the aspect, according to a vocabulary of aspect terms.
	 * 
	 * @return A term from a vocabulary (for use as an Aspect identifier).
	 */
	public String getAspectName();

	/**
	 * The namespace of the property and aspect terms.
   * In the Simple API, the namespace of the Aspect is determined by the namespace of the Property.
   * Future APIs are expected to relax this relationship to permit Aspects from other namespaces.
	 * 
	 * @return An IRI.
	 */
	public String getNamespace();
	
}
