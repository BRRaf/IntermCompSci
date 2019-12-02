package cs120.poly;

public interface PolyTerm {

	/**
	 * Answers the receiver’s coefficient, a double.
	 * 
	 * @return
	 */

	public double getCoefficient();

	/**
	 * Answers the receiver’s exponent.   Exponents are always integer.
	 * 
	 * @return
	 */

	public int getExponent();

	/**
	 * answers the value of the term evaluated at the specified number (x). 
	 * For example, 3x^2 produces 3*4 = 12 when x is given to be 2.
	 * 
	 * @param x a double, the base that is raised to the power of exp
	 * and subsequently multiplied by the coeff
	 * 
	 * @return a double representing the value of the PolyTerm evaluated at the 
	 * specified x
	 */

	public double value(double x);

	 
	 
	/**
	 * creates (and returns) a new term configured to be the sum of the current term and the one specified 
	 * (if matching exponent). Throws InvalidExponentException if the exponents do not match.
	 * This method does not modify the current term.  
	 * 
	 * @param other -- a handle on another PolyTerm 
	 * 
	 * @return a handle on a new PolyTerm that is the sum of other and the current receiver.
	 * 
	 * @throws InvalidExponentException when the two exponents are not the same value
	 */
	
	public PolyTerm add(PolyTerm other) throws InvalidExponentException;

	
	
	/** 
	 * creates and returns a new term configured to be the product of the current term and the other term specified. 
	 * This method does not modify the current term.
	 * 
	 * @param other -- the PolyTerm by which we multiply
	 * 
	 * @return a new PolyTerm that is the product of other and this
	 */
	
	public PolyTerm multiply(PolyTerm other);

	
	/**
	 * returns true if the coefficient in the current term is negative. returns false otherwise
	 * 
	 * @return true if coeff is neg, false is coeff is pos
	 */
	
	public boolean isNegative();

	
	
	/**
	 * returns true if the coefficient in the current term is exactly zero, false otherwise.
	 * @return true if coeff is 0, false if coeff is not 0
	 */
	
	public boolean isZero();


	/**
	 * returns the string representation of the term.
	 * 	If the exponent is zero, we produce only the coefficient as a string ..... ‘7.0’.
	 * 	If the exponent is 1, we produce only the coefficient followed by the letter x .... ‘-2.0x’.
	 * 	Otherwise, we produce the coefficient followed by x followed by a carrot followed by the exponent .... ‘-2.0x^3’.
	 */
	
	public String getString();

}