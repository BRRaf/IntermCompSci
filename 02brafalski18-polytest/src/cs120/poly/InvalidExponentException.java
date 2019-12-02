package cs120.poly;
/**
 * A class that extends Exception to make a custom exception
 * @author jsmith
 *
 */
public class InvalidExponentException extends Exception{

	/*
	 * Call the dumb constructors
	 */
	
	/**
	 * Default constructor.  Nothing special here.
	 */
	public InvalidExponentException() {
		super("Unable to operator when exponent not valid.");
	}

	/**
	 * Calls super with message option
	 * @param message
	 */
	public InvalidExponentException(String message) {
		super(message);
	}
}
