package org.w3c.ddr.simple;

import org.w3c.ddr.simple.exception.NameException;

/**
 * Represents a collection of PropertyValue instances.
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
public interface PropertyValues  {
	
  /**
   * Obtain all of the PropertyValue instances as an array.
   * The order of the array is implementation-specific.
   * 
   * @return An array of PropertyValue instances, some of which may not have values.
   */
	public PropertyValue[] getAll();
	
  /**
   * Obtain an identified PropertyValue instance from the collection, using a PropertyRef as the identifier.
   * It is not guaranteed that the returned PropertyValue will have a usable value associated with it.
   * To test if a usable value is available, use the exists() method of {@link PropertyValue}.
   * 
   * @param prop A non-null identifier of the PropertyValue to be returned.
   * @return The identified PropertyValue.
   * @throws org.w3c.ddr.simple.exception.NameException MUST be thrown if the prop parameter is null, or if the name data in the prop instance is invalid.
   */
	public PropertyValue getValue(PropertyRef prop) throws NameException;
}
