/**
 *  <MANDATORY> Description Required
 *
 * 1, Copyright Information  
 * 2, Licensing Information
 * 3, Known Issues, Warranties and Support information
 */
package automation.exceptions.element;

/**
 * @author tcs_2232619
 * This class will be used for custom element configuration exception messages
 */
public class ElementConfigurationException extends Exception {
	private static final long serialVersionUID = 2384159187950969549L;
	
	/**
	 * Printing custom messages in stacktrace
	 * @param String message,
     * @param Throwable cause
	 */
	public ElementConfigurationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Printing custom messages in stacktrace
	 * @param String message,
	 */
	public ElementConfigurationException(String arg0) {
		super(arg0);
		
	}
	
	
}
