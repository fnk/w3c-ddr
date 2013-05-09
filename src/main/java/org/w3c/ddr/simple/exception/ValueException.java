package org.w3c.ddr.simple.exception;

/**
 * This exception represents an error with a value associated with a Property and
 * would most likely be thrown when an error is detected during an attempt to retrieve the
 * value of a Property.
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
 */
public class ValueException extends DDRException {

	/**
	 * Code for 'Incompatible type'.
   * This code indicates that an attempt was made to represent the value in
   * a type that was incompatible with the semantics of the property.
   * For example, an attempt to use an enumeration value as an integer.
	 */
	public static int INCOMPATIBLE_TYPES = 600;

	/**
	 * Code for 'Not known'.
   * This code indicates that a value for a legitimate property could not be
   * retrieved from the repository because a value for the property is
   * not known to the repository.
   * For a PropertyValue instance, this exception can be anticipated via the exists() method
   * which would return False to indicate that the value is not known.
	 */
	public static int NOT_KNOWN = 900;
	
	/**
	 * Code for 'Multiple values'.
	 * This code indicates that there are more than one possible value for the Property instance.
   * Such a situation may arise when a value is being obtained from the repository
   * but multiple values are available in the repository and more than one of these values
   * are applicable in the identified delivery context.
	 */
	public static int MULTIPLE_VALUES = 10000;

	/**
	 * Constructs a ValueException instance with a default exception code.
	 */
	public ValueException() {
		super();
	}

	/**
   * Constructs a ValueException instance with a code and human-readable diagnostic message.
   * 
	 * @param code This should be a constant from this exception class.
	 * @param message Diagnostic message intended for human reading.
	 */
	public ValueException(int code, String message) {
		super(code, message);
	}

	/**
   * Constructs a ValueException instance with a code and Throwable object that
   * may indicate further details of the cause of the exception.
   * 
	 * @param code This should be a constant from this exception class.
	 * @param thr A Throwable object that may contain further details on the exception.
	 */
	public ValueException(int code, Throwable thr) {
		super(code, thr);
	}
}
