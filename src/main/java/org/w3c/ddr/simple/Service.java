package org.w3c.ddr.simple;

import java.util.Map;
import java.util.Properties;

import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;

/**
 * This is the 'simple' interface to a DDR service, via which you retrieve properties of the delivery context based on available (HTTP) evidence.
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
 */
public interface Service {
	/**
	 * Called to initialize the API following construction.
	 * 
	 * @param defaultVocabularyIRI The IRI of the default vocabulary namespace
	 * @param props Implementation dependent properties
	 * @throws NameException MUST be thrown if the implementation cannot apply the parameter data.
   * @throws InitializationException MUST be thrown in any situation that implies a failure while initializing the DDR (including the case of not being able to instantiate the class).
	 */
	public void initialize(String defaultVocabularyIRI, Properties props)
			throws NameException,InitializationException;

	/**
	 * A informative implementation-specific method to determine the version of the implementation of the API.
   * This is for use in cases where the service has been constructed via a factory,
   * or similarly determined at run-time, and supports diagnostic use-cases.
   * 
	 * @return A human-readable string containing information about the implementation of the API including the current version
	 */
	public String getImplementationVersion();

	/**
	 * An informative implementation-specific method to indicate the revision level of the underlying data, if known.
   * The information provided by this method, where information is returned, shall not be required
   * to reveal any details of the nature of the underlying data, including any source(s).
   * Whether or not the underlying implementation combines more than one source of data is opaque to 
   * the user of the API which makes no assumptions about the number of sources of data
   * 
	 * @return A String indicating the revision level of the data,
   * which will be different to any previously returned value if the
   * underlying implementation cannot guarantee that the data has not
   * changed since the last time this method was called.
   * <br/>Note: the NOT_SUPPORTED constant is returned if the implementation does not support data versioning.
	 */
	public String getDataVersion();

	/**
	 * List all the PropertyRefs the implementation knows about.
	 * 
   * @return A list of all the PropertyRefs that are known to the implementation.
	 */
	public PropertyRef[] listPropertyRefs();

	/**
   * Use the evidence provided to get the PropertyValue of the property
   * named by the propertyRef,
   * in the property vocabulary given by the propertyRef and
   * in the aspect also given by the propertyRef.
   * The aspect IRI is determined by the propertyRef
   * (which means it is the same as the property vocabulary IRI).
   * If no aspect term is defined by the propertyRef,
   * use the default aspect term for the property as defined in the property vocabulary.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param propertyRef Identification of the property whose value is being queried.
   * @return the PropertyValue of the identified property.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED) if the name data in the propertyRef parameter is invalid.
   */
  public PropertyValue getPropertyValue(Evidence evidence, PropertyRef propertyRef)
      throws NameException;

  /**
   * Use the evidence provided to get the PropertyValue of the property
   * named by the propertyName
   * in the vocabulary given by the propertyName and
   * in the default aspect of the property according to the property's vocabulary.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param propertyName Identification of the property whose value is being queried.
   * @return the PropertyValue of the identified property.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED) if the name data in the propertyName parameter is invalid.
   */
  public PropertyValue getPropertyValue(Evidence evidence, PropertyName propertyName)
      throws NameException;

	/**
   * Use the evidence provided to get the value of the property
   * named by the localPropertyName, which is a term
   * in the default property vocabulary defined during initialization and
   * in the default aspect for the property as defined in the default property vocabulary.
   * The namespace IRI of the aspect is the same as the IRI for the default vocabulary og properties.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param localPropertyName The local name (identifier) of the property as per the default vocabulary of properties.
   * @return the PropertyValue of the identified property.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with code NameException.PROPERTY_NOT_RECOGNIZED) if the localPropertyName parameter is invalid.
   */
	public PropertyValue getPropertyValue(Evidence evidence, String localPropertyName)
      throws NameException;

	/**
   * Use the evidence provided to get the value of the property
   * named by the localPropertyName, which is a term
   * in the given vocabulary of properties identified by a namespace IRI and
   * in the given aspect for the property.
   * The namespace IRI of the aspect is the same as the namespace for the given vocabulary of properties.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param localPropertyName The local name (identifier) of the property as per the vocabulary of properties whose namespace is given.
   * @param localAspectName The local name (identifier) of the aspect, whose namespace is the same as that of the vocabulary of properties.
   * @param vocabularyIRI The namesapce IRI for the vocabulary of properties.
   * @return the PropertyValue of the identified property.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED or NameException.ASPECT_NOT_RECOGNIZED) if any of the name data in the String parameters is invalid.
   */
	public PropertyValue getPropertyValue(Evidence evidence, String localPropertyName, String localAspectName, String vocabularyIRI)
      throws NameException;

	/**
   * Use the evidence provided to get all of the available values
   * of properties in the default property vocabulary.
   * This includes all property terms from all supported vocabularies,
   * and in each of the aspects supported by the property vocabularies,
   * and for every aspect IRI that is supported.
   * Combinations of property/aspect that are not supported are not returned in the PropertyValues collections.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @return an instance of PropertyValues containing PropertyValue objects representing all available values for the evidence supplied.
   * @throws org.w3c.ddr.simple.exception.NameException for consistency with other versions of this method, but if this method does throw a NameException then it should be treated as an implementation error because there are no circumstances when this method could actually throw a NameException
   */
  public PropertyValues getPropertyValues(Evidence evidence)
      throws NameException;

	/**
   * Use the evidence provided to get the value of each property in the array of PropertyRef instances.
   * The aspect term is determined by the individual PropertyRef instances.
   * Where the aspect term is undefined, use the default aspect term in the property's vocabulary.
   * As the order of elements obtained via {@link PropertyValues#getAll()} is implementation-specific
   * it is not correct to assume that the order of elements in propertyRefs will influence the order of
   * the array returned by {@link PropertyValues#getAll()}.
   * The {@link PropertyValues#getValue(PropertyRef)} method provides a more direct and interoperable 
   * means of inspecting the return value.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param propertyRefs Identification of the properties whose values are being queried.
   * @return an instance of PropertyValues containing PropertyValue objects identified by the supplied evidence.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED or NameException.ASPECT_NOT_RECOGNIZED) if any name data in the propertyRefs parameter is invalid.
   */
  public PropertyValues getPropertyValues(Evidence evidence, PropertyRef[] propertyRefs)
      throws NameException;

	/**
   * Use the evidence provided to get all of the available values for all properties
   * in the default vocabulary whose aspect is the localAspectName.
   * The namespace of the aspect is the same as the default vocabulary IRI.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param localAspectName The name of the aspect, whose namespace is the same as the default vocabulary of properties.
   * @return an instance of PropertyValues containing PropertyValue objects identified by the supplied evidence in the given aspect.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with code NameException.ASPECT_NOT_RECOGNIZED) if the localAspectName parameter is invalid.
   */
  public PropertyValues getPropertyValues(Evidence evidence, String localAspectName)
      throws NameException;

  /**
   * Use the evidence provided to get all of the available values for all properties
   * in the given vocabulary whose aspect is the localAspectName.
   * The namespace of the aspect is the same as the given vocabulary IRI.
   * 
   * @param evidence Evidence with which to identify the delivery context.
   * @param localAspectName The name of the aspect, whose namespace is the same as the vocabulary of properties.
   * @param vocabularyIRI The namespace of the vocabulary of properties.
   * @return an instance of PropertyValues containing PropertyValue objects in the given vocabulary and aspect, identified by the supplied evidence.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.ASPECT_NOT_RECOGNIZED) if any name data in the String parameters is invalid.
   */
	public PropertyValues getPropertyValues(Evidence evidence, String localAspectName, String vocabularyIRI)
      throws NameException;

	/**
   * Factory method to create a new PropertyName instance in the default property vocabulary.
   * 
   * @param localPropertyName The local name (identifier) of the property as given in the default vocabulary.
   * @return a new PropertyName instance.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with code NameException.PROPERTY_NOT_RECOGNIZED ) if the localPropertyName parameter is invalid.
   */
  public PropertyName newPropertyName(String localPropertyName)
			throws NameException;

	/**
   * Factory method to create a new PropertyName instance in the given property vocabulary.
   * 
   * @param localPropertyName The local name (identifier) of the property as given in its vocabulary.
   * @param vocabularyIRI The namespace of the property.
   * @return a new PropertyName instance.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED) if any of the parameters is invalid.
   */
  public PropertyName newPropertyName(String localPropertyName, String vocabularyIRI)
			throws NameException;

	/**
   * Factory method to create a PropertyRef instance in the default vocabulary.
   * The aspect is determined by the default aspect according to the vocabulary of the property.
   * If the property has no default aspect defined in the vocabulary, the PropertyRef.NULL_ASPECT is used.
   * @param localPropertyName The name of the property as given in the default vocabulary.
   * @return a new PropertyRef instance.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with code NameException.PROPERTY_NOT_RECOGNIZED) if the localPropertyName parameter is invalid.
   */
  public PropertyRef newPropertyRef(String localPropertyName)
			throws NameException;

	/**
   * Factory method to create a PropertyRef instance using the name and vocabulary of the PropertyName parameter.
   * The aspect is determined by the default aspect according to the vocabulary of the property.
   * If the property has no default aspect defined in the vocabulary, the PropertyRef.NULL_ASPECT is used.
   * 
   * @param propertyName A property belonging to a specific vocabulary.
   * @return a new PropertyRef instance.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED) if the name data in the propertyName parameter is invalid.
   */
  public PropertyRef newPropertyRef(PropertyName propertyName)
			throws NameException;

	/**
   * Factory method to create a PropertyRef instance using the name and vocabulary of the PropertyName parameter.
   * The aspect name is given, and the namespace IRI of the aspect is the same as the IRI of the vocabulary of the PropertyName parameter.
   * 
   * @param propertyName A property belonging to a specific vocabulary.
   * @param localAspectName The name of the aspect as given in the default vocabulary.
   * @return a new PropertyRef instance.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown (with codes NameException.VOCABULARY_NOT_RECOGNIZED or NameException.PROPERTY_NOT_RECOGNIZED or NameException.ASPECT_NOT_RECOGNIZED) if any name data in the parameters is invalid.
   */
  public PropertyRef newPropertyRef(PropertyName propertyName, String localAspectName)
      throws NameException;

	/**
	 * Factory method to create an object supporting the Evidence interface, intended to represent HTTP headers.
   * The object constructed by this factory is assumed to be aware of the case-insensitivity of HTTP headers.
   * 
   * @return an empty Evidence instance, suitable for population with HTTP headers.
   */
	public Evidence newHTTPEvidence();

	/**
   * Factory method to create an object supporting the Evidence interface, using name/value pairs from the Map parameter, representing evidence from HTTP headers.
   * The object constructed by this factory is assumed to be aware of the case-insensitivity of HTTP headers.
   * <br/><br/>
   * 
   * <b>NOTE</b>:
   * Versions of this interface pre-Java1.5 replace <i>java.util.Map&lt;String,String&gt;</i> with <i>java.util.Map</i>
   * <br/><br/>
   * 
   * @param map Mapping of names to values, assumed to represent HTTP headers.
   * @return an Evidence instance populated with HTTP headers.
   */
  public Evidence newHTTPEvidence(Map<String,String> map);
  
    /**
   * This constant value is used to indicate that a feature is not supported, when returned by a String method.
   * 
   * <br/><br/>The value of this constant shall be "__NOT_SUPPORTED".
   */
	public static final String NOT_SUPPORTED = "__NOT_SUPPORTED";

}