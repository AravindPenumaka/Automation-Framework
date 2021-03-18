package BasePack;

public class TestExceptions extends Exception {

	private static final long serialVersionUID = 7305543399233668043L;

	/**
	 * Printing custom messages in stacktrace
	 * @param String message,
     * @param Throwable cause
	 */
	public TestExceptions(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Printing custom messages in stacktrace
	 * @param String message
	 */
	public TestExceptions(String arg0) {
		super(arg0);
		
	}

}
