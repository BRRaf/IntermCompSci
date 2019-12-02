package cs120.poly;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * PolyTermTest tests each of the public methods.  Note we attempt to test all scenarios defined 
 * by the method parameters.   If we cannot enumerate each,  we provide a representative from each
 * kind of parameters.  For example,  we cannot test each exponent.  But we can test for a representative
 * positive, zero, and negative exponent.
 * 
 * @author mhiggs
 *
 */

public class PolyTermUnitTests {

	
	private static final double WITHIN_FUDGE_FACTOR = 1.0E-10;    // very small fudge factor.  Computations should be very accurate.

	
	/*
	 * Make sure we are creating/configuring properly with
	 * constructor.
	 */
	@Test
	public void testCreation() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 2);
		
		assertEquals(3.0, poly.getCoefficient(), 0.0);
		assertEquals(2,poly.getExponent());
	}
	
	/*
	 * testValue will check the value method to make sure the expected outcome
	 * occurs.
	 */
	@Test
	public void testValue() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 2);

		assertEquals(12.0, poly.value(2.0), WITHIN_FUDGE_FACTOR);
	}

	@Test
	public void testValueForZeroExponent() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 0);

		// should 3.0
		assertEquals(3.0, poly.value(2.0), WITHIN_FUDGE_FACTOR);
	}

	@Test
	public void testValueForZeroCoefficient() throws Exception {
		PolyTerm poly = new PolyTermBasic(0.0, 3);

		assertEquals(0.0, poly.value(2.0), WITHIN_FUDGE_FACTOR);
	}

	@Test
	public void testValueForNegativeCoefficient() throws Exception {
		PolyTerm poly = new PolyTermBasic(-3.0, 2);

		assertEquals(-12.0, poly.value(2.0), WITHIN_FUDGE_FACTOR);
	}


	@Test
	public void testValueForNegativeExponent() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, -2);

		assertEquals(0.75, poly.value(2.0), WITHIN_FUDGE_FACTOR);
	}

	
	
	
	/*
	 * testAdd will check to see if two coefficients add correctly
	 */
	@Test
	public void testAddWhenExponentsSame() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 2);
		PolyTerm other = new PolyTermBasic(4.0, 2);  // same exponent as poly
		PolyTerm newPoly = poly.add(other);

		assertEquals(7, newPoly.getCoefficient(), WITHIN_FUDGE_FACTOR);
		assertEquals(2, newPoly.getExponent());

	}

	/*
	 * When exponents do not match, a polyterm instance should respond with
	 * a thrown exception.
	 *  
	 * @throws Exception
	 */
	@Test(expected = InvalidExponentException.class)
	public void testAddWHenExponentsNotSame() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 2);
		PolyTerm other = new PolyTermBasic(4.0, 5);   // not same exaponent as poly

		PolyTerm polyNew = poly.add(other);
		
		fail("should have thrown exception when exponents do not match");   // skipped if working properly

	}

	/*
	 * testMultiply will give a scenario with an expected outcome when two
	 * polyterms are multiplied.
	 */
	@Test
	public void testMultiply() throws Exception {
		PolyTerm poly = new PolyTermBasic(3.0, 2);
		PolyTerm other = new PolyTermBasic(3.0, 5);

		PolyTerm together = poly.multiply(other);

		assertEquals(9.0, together.getCoefficient(), WITHIN_FUDGE_FACTOR);
		assertEquals(7, together.getExponent());

	}

	/*
	 * testNegative is going to test two PolyTerms, one negative and one
	 * positive and check to see if our isNegative method is working correctly
	 */
	@Test
	public void testIsNegativeWhenPositive() throws Exception {
		PolyTerm other = new PolyTermBasic(3.0, 6);
		assertFalse(other.isNegative());
	}

	
	@Test
	public void testIsNegativeWhenNegative() throws Exception {
		PolyTerm poly = new PolyTermBasic(-2.6, 1);
		assertTrue(poly.isNegative());
	}

	

	/*
	 * testZero will create a few PolyTerms and check to see if isZero will
	 * gives us the correct boolean.
	 */
	@Test
	public void testIsZeroWhenTermIsZero() throws Exception {
		PolyTerm polyA = new PolyTermBasic(0, 2);
		assertTrue(polyA.isZero());
	}

	

	/*
	 * testZero will create a few PolyTerms and check to see if isZero will
	 * gives us the correct boolean.   
	 */
	@Test
	public void testIsZeroWhenTermIsPositive() throws Exception {
		PolyTerm polyB = new PolyTermBasic(4, 6);
		assertFalse(polyB.isZero());  // should be false
	}

	

	/*
	 * testZero will create a few PolyTerms and check to see if isZero will
	 * gives us the correct boolean.
	 */
	@Test
	public void testIsZeroWhenTermIsNegative() throws Exception {
		PolyTerm polyC = new PolyTermBasic(-5, 9);
		assertFalse(polyC.isZero());	 // should be false
	}

	
	
	@Test
	public void testGetStringWhenExponentIsZero() {
		PolyTerm poly = new PolyTermBasic(2.0, 0);
		assertEquals("2.0",poly.getString());
	}

	@Test	
	public void testGetStringWhenExponentIsOne() {
		PolyTerm poly = new PolyTermBasic(-2.0, 1);
		assertEquals("-2.0x",poly.getString());
	}

	@Test	
	public void testGetStringWhenExponentIsLarge() {
		PolyTerm poly = new PolyTermBasic(3.0, 2);
		assertEquals("3.0x^2",poly.getString());
	}

	
	@Test	
	public void testGetStringWhenExponentIsLargeNegative() {
		PolyTerm poly = new PolyTermBasic(3.0, -2);
		assertEquals("3.0x^-2",poly.getString());
	}

}
