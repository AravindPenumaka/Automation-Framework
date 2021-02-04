package automation.exceptions.generic;


public class TestExecException extends Exception {
	
	private static final long serialVersionUID = 7305543399233668043L;

	
	/**
	 * Printing custom messages in stacktrace
	 * @param String message,
     * @param Throwable cause
	 */
	public TestExecException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Printing custom messages in stacktrace
	 * @param String message
	 */
	public TestExecException(String arg0) {
		super(arg0);
		
	}
	
	
}
