package cs120.poly;

/**
 * A basic PolyTerm class.  An instance of this class holds a coefficient and exponent
 * for a single polyterm.
 * 
 * Its key methods are add, multiply, and toString
 * All of which are essential to the Polynomial class
 * 
 * @author  <student name here>
 *
 */

public class PolyTermBasic implements PolyTerm 
{
	private int ex;
	private double co;

	// finish definition of PolyTermBasic 
	public PolyTermBasic(double co, int ex) {
		this.co = co;
		this.ex = ex;
	}

	
	
	
	@Override
	public double getCoefficient() {
		
		return co;
	}

	
	
	@Override
	public int getExponent() {
		
		return ex;
	}


	@Override
	public double value(double x) {
		
		//final value of the term
		double total;
		//full changeable value of x with exponent
		double totalx = x;
		
		if(ex == 0) {
			totalx = 1;
		} else if (ex < 0) { 	
			int posex = -ex;
			for (int i = 1; i < posex; i++) {
				totalx *= x;
			}	
			totalx = 1/totalx;	
		}
		else {
		for (int i = 1; i < ex; i++) {
			totalx *= x;
		}
		
		}
		
		total = co * totalx;
		
		return total;
	}

	@Override
	public PolyTerm add(PolyTerm other) throws InvalidExponentException {
		
		// the final term to return the polynomial
		PolyTerm addedterm;
		
		if (this.ex != other.getExponent()) {
			throw new InvalidExponentException();
		} 
		// the added coefficient if the terms are the same
		double addedco = this.co + other.getCoefficient();
	
		addedterm = new PolyTermBasic(addedco,this.ex);
	
		return addedterm;
	}

	@Override
	public PolyTerm multiply(PolyTerm other) {
		
		// the final term to return to the polynomial
		PolyTerm multerm;
		
		// the added exponents
		int addexp = this.ex + other.getExponent();
		
		// the multiplied coefficient
		double multco = this.co * other.getCoefficient(); 
		
		multerm = new PolyTermBasic(multco,addexp);
		
		return multerm;
	}

	@Override
	public boolean isNegative() {
		
		if (this.co > 0) {
			return false;
		}
		
		if (this.co < 0) {
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean isZero() {
		
		if (this.co == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String getString() {
		
		// the returned string which changes depending on certain factors
		String str;
		
		
		if (this.ex == 0) {
			
			str = this.co+"";
			 
		} else if (this.ex == 1) {
			
			str = this.co+"x";
			
		} else {
			
			str = this.co+"x^"+this.ex;
			
		}
		
		return str;
	}
	
}
	

