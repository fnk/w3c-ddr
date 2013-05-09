package org.w3c.ddr.simple.exception;

/**
 * This exception represents a failure of the DDR system.
 * 
 * @author Jo Rabin (dotMobi)
 * @author <br/>Jose Manuel Cantera Fonseca (Telefonica I+D)
 * @author <br/>Rotan Hanrahan (MobileAware)
 * @author <br/>Ignacio Marin (Fundacion CTIC) <br/> <a
 *         href="http://www.w3.org/Consortium/Legal/ipr-notice#Copyright">Copyright</a>
 *         &copy; 2008 <a href="http://www.w3.org/"><acronym title="World Wide
 *         Web Consortium">W3C</acronym></a><sup>&reg;</sup> (<a
 *         href="http://www.csail.mit.edu/"><acronym title="Massachusetts
 *         Institute of Technology">MIT</acronym></a>, <a
 *         href="http://www.ercim.org/"><acronym title="European Research
 *         Consortium for Informatics and Mathematics">ERCIM</acronym></a>, <a
 *         href="http://www.keio.ac.jp/">Keio</a>), All Rights Reserved.<br/>
 *         W3C <a
 *         href="http://www.w3.org/Consortium/Legal/ipr-notice#Legal_Disclaimer">liability</a>,
 *         <a
 *         href="http://www.w3.org/Consortium/Legal/ipr-notice#W3C_Trademarks">trademark</a>
 *         and <a
 *         href="http://www.w3.org/Consortium/Legal/copyright-documents">document
 *         use</a> rules apply.
 */
public class InitializationException extends DDRException {

	/**
	 * Code for 'General Initialization Error'. This exception code indicates
	 * that there was a problem during initialization.
	 */
	public static int INITIALIZATION_ERROR = 300;

	/**
	 * Constructs an InitializationException instance with a default exception
	 * code.
	 */
	public InitializationException() {
		super();
	}

	/**
	 * Constructs an InitializationException instance with a code and
	 * human-readable diagnostic message.
	 * 
	 * @param code
	 *            This should be an implementation-specific code identifying the
	 *            cause of the exception.
	 * @param message
	 *            Diagnostic message intended for human reading.
	 */
	public InitializationException(int code, String message) {
		super(code, message);
	}

	/**
	 * Constructs an InitializationException instance with a code and Throwable
	 * object that may indicate further details of the cause of the exception.
	 * 
	 * @param code
	 *            This should be an implementation-specific code identifying the
	 *            cause of the exception.
	 * @param thr
	 *            A Throwable object that may contain further details on the
	 *            exception.
	 */
	public InitializationException(int code, Throwable thr) {
		super(code, thr);
	}

}
