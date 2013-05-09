package org.w3c.ddr.simple;

import java.util.Properties;

import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;
import org.w3c.ddr.simple.exception.SystemException;

/**
 * This factory creates a DDR Service instance.
 * 
 * <br/><br/> <b>NOTE</b>: This class is provided as part of the Java binding
 * of the API, and is <b>not</b> part of the API definition itself.
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
 * 
 */
public class ServiceFactory {

	/**
	 * 
	 * Factory method for creating a new Service instance.
	 * 
	 * @param clazz
	 *            Class identifier
	 * @param defaultVocabulary
	 *            Passed to the Service.initialize method.
	 * @param configuration
	 *            Passed to the Service.initialize method.
	 * @return A service instance with which to access a Device Description Repository.
	 * @throws InitializationException
	 * @throws NameException
	 */
	public static Service newService(String clazz, String defaultVocabulary,
			Properties configuration) throws InitializationException,
			NameException {

		Service theService = null;

		if (clazz == null) {
			throw new SystemException(SystemException.ILLEGAL_ARGUMENT,
					"Service class cannot be null");
		}

		if (defaultVocabulary == null) {
			throw new SystemException(SystemException.ILLEGAL_ARGUMENT,
					"Default vocabulary cannot be null");
		}

		try {
			// Instantiation
			theService = (Service) Class.forName(clazz).newInstance();
		} catch (IllegalAccessException e) {
			throw new InitializationException(InitializationException.INITIALIZATION_ERROR, e);
		} catch (ClassNotFoundException e) {
			throw new InitializationException(InitializationException.INITIALIZATION_ERROR, e);
		} catch (Throwable thr) {
			throw new SystemException(SystemException.CANNOT_PROCEED, thr);
		}

		// Initialization
		theService.initialize(defaultVocabulary, configuration);

		return theService;
	}
}