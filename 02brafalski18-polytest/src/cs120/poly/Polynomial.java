package cs120.poly;

public interface Polynomial {

	/**
	 * returns the number of terms in the polynomial
	 * @return int that represent length of myTerms array
	 */
	int size();

	/**
	 * returns the degree of the polynomial; returns -1 if polynomial is empty
	 * @return the highest value exponent in the polynomial
	 */

	int degree();

	/**
	 * adds a term to the polynomial; combines terms with duplicate exponent; 
	 * removes any resulting term with zero coefficient; keeps the terms in decreasing exponent order.
	 * @param aTerm the PolyTerm that is to be added
	 */

	void addTerm(PolyTerm aTerm);

	/**
	 * creates a term and adds
	 * @param coef of PolyTerm
	 * @param exp of PolyTerm
	 */

	void addTerm(double coef, int exp);

	/**
	 * removes the term whose exponent matches that provided; 
	 * returns the removed term if found; returns null if not found;
	 * @param anExp the exponent of the term that is being removed
	 * @return the PolyTerm that was removed
	 */

	PolyTerm removeTerm(int anExp);

	/**
	 * returns a handle on the polyterm at the specified rank or null if the specified rank is not appropriate.
	 * @param pos the index
	 * @return the PolyTerm at the index
	 */

	PolyTerm termAt(int pos);

	/**
	 * answers the rank of the PolyTerm with matching exponent or –1 if matching exponent not found
	 * @param anExp the exponent of the PolyTerm being looked for
	 * @return the index where the PolyTerm was found
	 */

	int indexOf(int anExp);

	/**
	 * answers the value of the entire polynomial given the value of x by evaluating and summing each term.
	 * @param x the value at which each PolyTerm is evaluated
	 * @return the total sum of all of the values of each PolyTerm in the polynomial at the given x
	 */

	double value(double x);

	/**
	 * modifies the current polynomial by retrieving and adding the terms in the other polynomial provided.
	 * calls addTerm.   Depends on <code>termAt</code> and <code>addTerm</code>.
	 * 
	 * @param other the PolyTerm to be added to the Polynomial
	 */

	void addPolynomial(Polynomial other);

	/**
	 * modifies the current polynomial by multiplying itself with the other polynomial provided.
	 * Uses the foil method
	 * calls addTerm
	 * @param other the PolyTerm to be multiplied by
	 */

	void multPolynomial(Polynomial other);

	/** 
	 * returns the string representation of the polynomial in terms of x presented equation form...
	 * ‘f(x) = 2.0x^3 - 3.0x + 7.0’
	 * Uses a string buffer
	 */

	String toString();

	/**
	 * returns the string representation of the polynomial showing the value of each term evaluated at the specified x
	 * ‘f(2) = 16.0 - 6.0 + 7.0 = 17.0’
	 * <p>
	 * The terms must be presented in decreasing order of exponent.
	 * </p>
	 * @param x the double at which the Polynomial 
	 * @return a string with the value of each PolyTerm at the given x and the sum of all values
	 */

	String toString(double x);

}