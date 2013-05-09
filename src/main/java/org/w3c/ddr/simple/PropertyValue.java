package org.w3c.ddr.simple;

import org.w3c.ddr.simple.exception.ValueException;

/**
 * Represents the value of a property.<br/><br/>
 * 
 * <b>NOTE</b>:
 * The underlying data type of a property is determined by its vocabulary.
 * The programmatic determination of a property type from a vocabulary is out of scope for this API.
 * Therefore, the only practical way to determine the appropriate getX() method for an arbitrary instance supporting this interface
 * is to obtain the name details via the getPropertyRef() method and compare the property information against
 * externally available vocabulary information.
 * Under the normal use cases for this API, the usage of an instance supporting this interface will be such that
 * the data type is already known, and the developer will take steps to use the appropriate getX() method.
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
public interface PropertyValue {

	/**
	 * 
	 * Returns the double value of the property, in the default units specified in its vocabulary.
   * 
   * @return the double value of the property
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not a double according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public double getDouble() throws ValueException; // double-precision 64-bit IEEE 754 floating point

	/**
	 * 
	 * Returns the long value of the property, in the default units specified in its vocabulary.
	 * 
   * @return the long value of the property
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not a long according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public long getLong() throws ValueException; // 64-bit signed two's complement integer

	/**
	 * Returns the Boolean value of the property.
	 * 
   * @return the Boolean value of the property
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not a Boolean according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public boolean getBoolean() throws ValueException;

	/**
	 * 
	 * Returns the integer value of the property, in the default units specified in its vocabulary.
	 * 
   * @return the integer value of the property
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not an integer according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public int getInteger() throws ValueException; // 32-bit signed two's complement integer

	/**
	 * 
	 * Returns the value of the property as a list of strings.
	 * 
   * @return the value of the property as a list of strings
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not an enumeration according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public String[] getEnumeration() throws ValueException;

	/**
	 * 
	 * Returns the float value of the property, in the default units specified in its vocabulary.
	 * 
   * @return the float value of the property
   * @throws ValueException MUST be thrown (with code ValueException.INCOMPATIBLE_TYPES) if the property is not a float according to its vocabulary definition, or (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public float getFloat() throws ValueException; // single-precision 32-bit IEEE 754 floating point

	/**
   * Returns the PropertyRef that identifies the property to which this PropertyValue instance applies.
   * 
	 * @return The corresponding PropertyRef instance.
	 */
	public PropertyRef getPropertyRef();

	/**
	 * 
	 * Returns the string value of the property, or a string <i>version</i> of the property.
   * 
   * @return The string value of the property or an implementation-specific string version of the property if the underlying data type is not a string.
   * @throws ValueException MUST be thrown (with code ValueException.NOT_KNOWN) if the the value is not known to the implementation.
	 */
	public String getString() throws ValueException; // UTF-16 format, Basic Multilingual Plane code points, including surrogates

	/**
   * Returns 'true' only if a value is available from the repository.<br/>
   * Returns 'false' if a value is not available from the repository.<br/><br/>
   * If this method returns 'true', then the getX() methods will return valid
   * data if type X is appropriate to the data stored in the repository.
   * If this method returns 'false', an attempt to retrieve a value via a getX()
   * method (other than getString) will cause a ValueException
   * (with code ValueException.NOT_KNOWN) to be thrown.
   * 
	 * @return The value 'true' if a value for the property is known in the repository, or 'false' otherwise.
	 */
	public boolean exists();
}