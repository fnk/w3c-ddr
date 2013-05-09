package org.w3c.ddr.simple.exception;

/**
 * This exception is thrown when an attempt is made to access a Property or Aspect when the
 * name or vocabulary IRI is in error.
 * The exception code, when set, indicates the nature of the error.
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
public class NameException extends DDRException {

  /**
   * Code for 'Property not recognized'.
   * This exception code indicates that a given Property does not exist in the given vocabulary or is not syntactically correct.
   */
  public static int PROPERTY_NOT_RECOGNIZED = 100;
  
  /**
   * Code for 'Vocabulary not recognized'.
   * This exception code indicates that the vocabulary of a given Property is not known or is not syntactically correct.
   */
  public static int VOCABULARY_NOT_RECOGNIZED = 200;
  
  /**
   * Code for 'Aspect not recognized'.
   * This exception code indicates that the Aspect is not known or is not syntactically correct.
   * It is assumed in the Simple DDR API that the vocabulary of an Aspect derives
   * from the vocabulary of the Property to which it is applied. 
   */
  public static int ASPECT_NOT_RECOGNIZED = 800;

  /**
   * Constructs a NameException instance with default exception code.
   */
  public NameException() {
    super();
  }

  /**
   * Constructs a NameException instance with a code and human-readable message.
   * 
   * @param code This should be a constant from this exception class.
   * @param message Diagnostic message intended for human reading.
   */
  public NameException(int code, String message) {
    super(code, message);
  }

  /**
   * Constructs a NameException instance with a code and an instance of Throwable,
   * which may contain additional information pertaining to the cause of the exception.
   * 
   * @param code This should be a constant from this exception class.
   * @param thr A Throwable object that may contain further details on the exception.
   */
  public NameException(int code, Throwable thr) {
    super(code, thr);
  }
}
