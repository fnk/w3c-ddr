package org.w3c.ddr.simple;

/**
 * An interface representing evidence that is to be supplied to getPropertyValue 
 * or getPropertyValues methods of {@link Service}.
 * The purpose of Evidence is to represent available information with which to identify the delivery context.
 * In accordance with the minimum requirements of the DDR Simple API, this interface can support the
 * representation of evidence as HTTP headers.
 * Consumers of HTTP evidence must support case-insensitive field names as per RFC 2616 section 4.2.
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
 * @see Service#newHTTPEvidence()
 */

public interface Evidence {
	/**
	 * Add a key / value pair to the collection of evidence.
   * Any value put into evidence via this method can be retrieved via a corresponding call to get(key).
   * 
	 * @param key The key that identifies an element of the evidence.
	 * @param value The value of the identified element.
	 */
	public void put(String key, String value);
	
	/**
	 * True if a value for the specified key exists.
   * 
	 * @param key The unique key that identifies an element of the evidence.
	 * @return The value 'true' if the identified element has a value that can be retrieved, and 'false' otherwise.
	 */
	public boolean exists(String key);
	
	/**
	 * Get the value corresponding to the key.
   * For a particular key K, if there was a previous call to put(K,value) then
   * the value returned by get(K) will be the most recent value used in put(K,value).
   * 
	 * @param key The key that identifies an element of the evidence.
	 * @return The value of the element identified by the key.
	 */
	public String get(String key);
}
