package cs120.poly;
/**
 * An instance of this class represents a polynomial, a collection of polyterms as
 * a top-half contiguous array of handles on PolyTerm instances.  Thus,  our implementation
 * is Array-based.
 * <p>
 * Polynomials may be constructed by repeatedly adding another polyTerm instance.  Polynomials
 * can be added (adding like-terms,  terms with similar exponents);  and can be multiplied.
 * </p>
 * <p>
 * We maintain the terms in descending exponent order in the front contiguous portion of the array.
 * All exponents in the terms must be distinct (not terms with identical exponent).  When two 
 * terms exist with same exponent we merge them.    Also, we remove all zero valued terms. 
 * </p>
 * @author jsmith
 */
public class PolynomialArray implements Polynomial {

	
	public static final int POLY_MAX_TERMS = 10;
	
	/**
	 * Array to hold all the PolyTerms We use protected
	 * visibility to enable our tests to access via inheritance.
	 */
	protected PolyTerm[] myTerms;
	
	/**
	 * current number of terms in array.  starts empty.   We use protected
	 * visibility to enable our tests to access via inheritance.
	 */
	protected int n = 0;   
	
	/**
	 * Configures the current polynomial as empty of terms.
	 * 
	 */
	public PolynomialArray() {
		myTerms = new PolyTerm[POLY_MAX_TERMS];
		n  = 0;
	}

	
	
	/**
	 * returns the number of terms in the polynomial
	 * @return int that represent length of myTerms array
	 */
	@Override
	public int size() {
		
		//holds amount of non-null terms located in myTerms
		int size = 0;
	
	// In case the Array isn't full and it won't fire an out of bounds exception
	if (myTerms[9] == null) {	
		for (int i = 0; myTerms[i] != null; i++) {
			size += 1;
		}
		return size;
		
	} else {
		
		return 10;
	}
	
	
		
	}

	
	
	/**
	 * returns the degree of the polynomial; returns -1 if polynomial is empty
	 * @return the highest value exponent in the polynomial
	 */
	
	@Override
	public int degree() {
//		System.out.println(myTerms[0].getExp());
		int highestVal = 0;
		boolean empty = true;
		
//		Adding an if clause in case the list is empty. 
//		Only checking the first term due to no other method adding in polynomials in the middle of list		
		
		if (myTerms[0] == null) {
			return -1;
		}
		
		
		for (PolyTerm term : this.myTerms) {
			if (term != null) {
				empty = false;
			}
			if (!empty && term.getExponent() > highestVal) {
				highestVal = term.getExponent();
			}
			empty = true;
		}
//		System.out.println(highestVal);
		return highestVal;

	}

	
	/**
	 * adds a term to the polynomial; combines terms with duplicate exponent; 
	 * removes any resulting term with zero coefficient; keeps the terms in decreasing exponent order.
	 * 
	 * @param aTerm the PolyTerm that is to be added
	 */
	
	@Override
	public void addTerm(PolyTerm aTerm) {
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			/*
			 * If there is no term at the index, then just add it there
			 * (as long as we maintain top half contiguous nature, adding it
			 * in the index that is null will comply with said nature)
			 * However if there are terms at the index, we must compare
			 */
			
			if (myTerms[i] == null) {
				myTerms[i] = aTerm;
				break;
			} else if (myTerms[i] != null) {
				PolyTerm a = myTerms[i];
				
				/*
				 * If the exp are the same, we try to add
				 */
				if (aTerm.getExponent() == a.getExponent()) {
					try {
						myTerms[i] = aTerm.add(a);
						
						
					} catch (InvalidExponentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					/*
					 * If the resulting coefficient is zero, remove the term and shift all the 
					 * terms down 1 in index (towards the top)
					 */
					if (myTerms[i].getCoefficient() == 0) {
						myTerms[i] = null;
						for (int n = i; n < myTerms.length - 1; n++) {
							if (myTerms[i + 1] != null) {   
								myTerms[n] = myTerms[n + 1];
							}
						}
					}
					break;				
					
					/*
					 * If the aTerm is larger than the current PolyTerm
					 * We need to insert it at that index and then
					 * shift the rest of the array
					 * up 1 in index (towards the bottom)
					 */
				} else if (aTerm.getExponent() > myTerms[i].getExponent()) {
					// keep track of where I inserted the aTerm
					int whereInserted = i;
					// now we need to shift all of the terms down
					// do this by going from top of array and shifting up one, making space for
					// inserted term
					for (int n = myTerms.length - 1; n > whereInserted; n--) {
						myTerms[n] = myTerms[n - 1];

					}
					myTerms[i] = aTerm;
					break;

				}

			}
		}

	}
	
	/**
	 * creates a term and adds
	 * @param coef of PolyTerm
	 * @param exp of PolyTerm
	 */
	@Override
	public void addTerm(double coef, int exp) {
		PolyTerm pTerm1 = new PolyTermBasic(coef, exp);
		this.addTerm(pTerm1);
	}
	
	
	
	/**
	 * removes the term whose exponent matches that provided; 
	 * returns the removed term if found; returns null if not found;
	 * @param anExp the exponent of the term that is being removed
	 * @return the PolyTerm that was removed
	 */

	@Override
	public PolyTerm removeTerm(int anExp) {
		PolyTerm found;
		for ( PolyTerm num : myTerms) {
			if (num != null && num.getExponent() == anExp) {
				found = num;
				PolyTerm counter = new PolyTermBasic (-(num.getCoefficient()), num.getExponent());
				this.addTerm(counter);
				return found;
			}
		}
		return null;
	}
	
	
	/**
	 * returns a handle on the polyterm at the specified rank or null if the specified rank is not appropriate.
	 * @param pos the index
	 * @return the PolyTerm at the index
	 */

	@Override
	public PolyTerm termAt (int pos) {
		return myTerms[pos];
	}
	
	
	/**
	 * answers the rank of the PolyTerm with matching exponent or –1 if matching exponent not found
	 * @param anExp the exponent of the PolyTerm being looked for
	 * @return the index where the PolyTerm was found
	 */

	@Override
	public int indexOf (int anExp) {
		int index = -1;
		for (int i = 0; i < POLY_MAX_TERMS-1; i++) {
			if (myTerms[i] != null && myTerms[i].getExponent() == anExp) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * answers the value of the entire polynomial given the value of x by evaluating and summing each term.
	 * @param x the value at which each PolyTerm is evaluated
	 * @return the total sum of all of the values of each PolyTerm in the polynomial at the given x
	 */
	@Override
	public double value (double x) {
		
		double sum = 0;
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			if (myTerms[i] != null) {
				sum+= myTerms[i].value(x);
			}
		}
		return sum;
		
	}
	
	/**
	 * modifies the current polynomial by retrieving and adding the terms in the other polynomial provided.
	 * calls addTerm.   Depends on <code>termAt</code> and <code>addTerm</code>.
	 * 
	 * @param other the PolyTerm to be added to the Polynomial
	 */

	@Override
	public void addPolynomial (Polynomial other) {
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			if(other.termAt(i) != null) {
				this.addTerm(other.termAt(i));
			}
		}
	}
	
	/**
	 * modifies the current polynomial by multiplying itself with the other polynomial provided.
	 * Uses the foil method
	 * calls addTerm
	 * @param other the PolyTerm to be multiplied by
	 */

	@Override
	public void multPolynomial (Polynomial other) {
		PolynomialArray sumPolynomial = new PolynomialArray();
		int lengthCounter = 0;
		
		/*
		 * Use a nested for loop to perform the FOIL method
		 */
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			for (int n = 0; n < POLY_MAX_TERMS; n++) {
				if (myTerms[i] != null && other.termAt(n) != null) {
					PolyTerm a = myTerms[i].multiply(other.termAt(n));
					sumPolynomial.addTerm(a);
//					System.out.println(a.toString());
					lengthCounter++; //need a counter to know how much of a polynomial needs to be copied over
				}
			}
		}
		//transplant the sumPolynomial into this (the original) Polynomial
		System.arraycopy(sumPolynomial.myTerms, 0, this.myTerms, 0, lengthCounter);
	}
	
	/** 
	 * returns the string representation of the polynomial in terms of x presented equation form...
	 * ‘f(x) = 2.0x^3 - 3.0x + 7.0’
	 * Uses a string buffer
	 */

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();	 
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			String sign = "+";
			if (myTerms[i] != null) {
				if (myTerms[i].isNegative() || i == 0) {
					sign = "";
				}
				buf.append(sign + myTerms[i].getString());
			}
		}
		String str = buf.toString();
		return str;
	}
	
	/**
	 * returns the string representation of the polynomial showing the value of each term evaluated at the specified x
	 * ‘f(2) = 16.0 - 6.0 + 7.0 = 17.0’
	 * <p>
	 * The terms must be presented in decreasing order of exponent.
	 * </p>
	 * @param x the double at which the Polynomial 
	 * @return a string with the value of each PolyTerm at the given x and the sum of all values
	 */

	@Override
	public String toString(double x) {
		StringBuffer buf = new StringBuffer( java.lang.String.format("f(%s) = ",x) );
		double sum = 0; // keep a total
		for (int i = 0; i < POLY_MAX_TERMS; i++) {
			String sign = "+"; // sign representing positive or negative character of polyterm
			if (myTerms[i] != null) {
				if (myTerms[i].isNegative() || i == 0) {
					sign = "";
				}
				sum += myTerms[i].value(x); //add to sum
				buf.append(sign + myTerms[i].value(x));
			}
		}
		buf.append(" = " + sum);
		String str = buf.toString();
		return str;
	}
}

