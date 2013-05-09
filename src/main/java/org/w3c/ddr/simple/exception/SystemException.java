package org.w3c.ddr.simple.exception;

/**
 * This exception represents a failure of the DDR system.
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
public class SystemException extends java.lang.RuntimeException {

	/**
	 * Code for 'illegal argument'.
   * This exception code indicates that a method has been passed an illegal or inappropriate argument (for example a null Evidence).
	 */
	public static int ILLEGAL_ARGUMENT = 400;

	/**
	 * Code for 'Cannot proceed'.
   * This exception code indicates that the implementation cannot continue with the processing of the current request due to an unexpected failure.
	 */
	public static int CANNOT_PROCEED = 500;

	/**
	 * Constructs a SystemException instance with a default exception code.
	 */
	public SystemException() {
		super();
	}

	/**
   * Constructs a SystemException instance with a code and human-readable diagnostic message.
   * 
	 * @param code This should be a constant from this exception class.
	 * @param message Diagnostic message intended for human reading.
	 */
	public SystemException(int code, String message) {
		super(message);
    this.code = code;
	}

	/**
   * Constructs a SystemException instance with a code and Throwable object that
   * may indicate further details of the cause of the exception.
   * 
	 * @param code This should be a constant from this exception class.
	 * @param thr A Throwable object that may contain further details on the exception.
	 */
	public SystemException(int code, Throwable thr) {
		super(thr);
    this.code = code;
	}

  /**
   * Represents a machine-understandable code to refine/identify the cause of the exception.
   */
 	protected int code;
}
