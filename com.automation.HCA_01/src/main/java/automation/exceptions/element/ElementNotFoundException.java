package automation.exceptions.element;


public class ElementNotFoundException extends Exception {
	
	/**
	 * Printing custom messages in stacktrace
	 * @param String message,
     * @param Throwable cause
	 */
	public ElementNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Printing custom messages in stacktrace
	 * @param String message
	 */
	public ElementNotFoundException(String arg0) {
		super(arg0);
		
	}

	private static final long serialVersionUID = 5436934626189845811L;
	
}
