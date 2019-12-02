package cs120.poly;

import static org.junit.Assert.*;


import java.lang.reflect.Field;

import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;


public class PolynomialUnitTests {
	
	/**
	 * The definition for TestPolynomial extends our subject (an instance
	 * of a PolynomialArray by adding two additional methods useful for
	 * getting and setting the state of the polynomial with polyTerms.
	 * <p>
	 * With these useful test methods, we can configure our polynomial
	 * with a terms appropriate for each test.
	 * </p>
	 * 
	 *
	 */
	private class TestPolynomial extends PolynomialArray {
		
		/*
		 * Private helper test method to help inject terms into a polynomial
		 * test subject.  Other than this method, we are testing the super 
		 * class.
		 *   
		 */
		public void setTerms(PolyTerm ... terms) {
			
			// clear out all terms in polynomial
			for (int i=0; i < myTerms.length; i++) myTerms[i] = null;
			
			// copy handles over setting each term
			int i = 0;
			for (PolyTerm pt : terms) {
				myTerms[i++] = pt;
			}
			
			// be sure to set the size if needed.
			n = i;
		}
		
		
		public PolyTerm[] getTerms() {
			return myTerms;
		}
	}



	private static final double WITHIN_FUDGE_FACTOR = 1.0e-10;
	
	

	/*
	 * Ensure value works with a typical 2 term polynomial.  In
	 * this test, we should get 44.
	 * 
	 */
	@Test
	public void testValueWhenTwoTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
				
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.value(2.0)).andReturn(32.0).anyTimes();
		
		// configure our test subject with 2 terms
		pol.setTerms(p2,p1);

		
		EasyMock.replay(p1,p2);		// done training.
		
		double result = pol.value(2.0);
		
		// now check that evaluate is working.
		assertEquals(44.0, result, WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2);
		
	}
	
	/*
	 * Testing value with for edge case of zero values
	 * 
	 */
	
	@Test
	public void testValueWhenZeroTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
			
		double result = pol.value(2.0);
		
		assertEquals(0.0, result, WITHIN_FUDGE_FACTOR);
		
	}
	
	/*
	 * Testing value with edge case of one value
	 */
	
	@Test
	public void testValueWhenOneTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
				
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
		

		// configure our test subject with 2 terms
		pol.setTerms(p1);

		
		EasyMock.replay(p1);		// done training.
		
		double result = pol.value(2.0);
		
		// now check that evaluate is working.
		assertEquals(12.0, result, WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1);
		
	}
	
	
	/*
	 * Testing value with edge case of maximum values
	 */
	@Test
	public void testValueWhenTenTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
				
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.value(2.0)).andReturn(32.0).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(-5.0, 2);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.value(2.0)).andReturn(-20.0).anyTimes();
				
		//PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.value(2.0)).andReturn(9.0).anyTimes();
				
		//PolyTerm p5 = new PolyTermBasic(8.0, 2);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.value(2.0)).andReturn(32.0).anyTimes();
				
		//PolyTerm p6 = new PolyTermBasic(-2.0, 3);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.value(2.0)).andReturn(-8.0).anyTimes();
				
		//PolyTerm p7 = new PolyTermBasic(6.0, 4);
		PolyTerm p7 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p7.value(2.0)).andReturn(96.0).anyTimes();
				
		//PolyTerm p8 = new PolyTermBasic(3.6, 2);
		PolyTerm p8 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p8.value(2.0)).andReturn(14.4).anyTimes();
						
		//PolyTerm p9 = new PolyTermBasic(0.4, 4);
		PolyTerm p9 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p9.value(2.0)).andReturn(6.4).anyTimes();
						
		//PolyTerm p10 = new PolyTermBasic(-8.0, 2);
		PolyTerm p10 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p10.value(2.0)).andReturn(-32.0).anyTimes();
						
		
						
		
		// configure our test subject with 2 terms
		pol.setTerms(p10,p9,p8,p7,p6,p5,p4,p3,p2,p1);

		
		EasyMock.replay(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);		// done training.
		
		double result = pol.value(2.0);
		
		// now check that evaluate is working.
		assertEquals(141.8, result, WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
		
	}
	
	
	
	
	/*
	 * Testing size method when their are two terms
	 */
	
	@Test
		public void testSizeWhenTwoTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.value(2.0)).andReturn(32.0).anyTimes();
		
		
		pol.setTerms(p1,p2);
		
		EasyMock.replay(p1,p2);
		
		int result = pol.size();
		
		assertEquals(2, result, WITHIN_FUDGE_FACTOR);
		
		EasyMock.verify(p1,p2);
		
		
		
	}
	
	/*
	 * Testing size method edge case when their are zero terms
	 */
	
	@Test
		public void testSizeWhenZeroTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		int result = pol.size();
		
		assertEquals(0, result, WITHIN_FUDGE_FACTOR);	
		
		
	}
	
	/*
	 * Testing size method edge case when their is a single term
	 */
	
	@Test
		public void testSizeWhenOneTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
	
		pol.setTerms(p1);
		
		EasyMock.replay(p1);
		
		int result = pol.size();
		
		assertEquals(1, result, WITHIN_FUDGE_FACTOR);
		
		EasyMock.verify(p1);
		
	}
	
	/*
	 * Testing size with edge case of maximum values
	 */
	@Test
	public void testSizeWhenTenTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
				
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.value(2.0)).andReturn(12.0).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.value(2.0)).andReturn(32.0).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(-5.0, 2);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.value(2.0)).andReturn(-20.0).anyTimes();
				
		//PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.value(2.0)).andReturn(9.0).anyTimes();
				
		//PolyTerm p5 = new PolyTermBasic(8.0, 2);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.value(2.0)).andReturn(32.0).anyTimes();
				
		//PolyTerm p6 = new PolyTermBasic(-2.0, 3);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.value(2.0)).andReturn(-8.0).anyTimes();
				
		//PolyTerm p7 = new PolyTermBasic(6.0, 4);
		PolyTerm p7 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p7.value(2.0)).andReturn(96.0).anyTimes();
				
		//PolyTerm p8 = new PolyTermBasic(3.6, 2);
		PolyTerm p8 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p8.value(2.0)).andReturn(14.4).anyTimes();
						
		//PolyTerm p9 = new PolyTermBasic(0.4, 4);
		PolyTerm p9 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p9.value(2.0)).andReturn(6.4).anyTimes();
						
		//PolyTerm p10 = new PolyTermBasic(-8.0, 2);
		PolyTerm p10 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p10.value(2.0)).andReturn(-32.0).anyTimes();
						
		
						
		
		// configure our test subject with 2 terms
		pol.setTerms(p10,p9,p8,p7,p6,p5,p4,p3,p2,p1);

		
		EasyMock.replay(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);		// done training.
		
		double result = pol.size();
		
		// now check that evaluate is working.
		assertEquals(10, result, WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
		
	}
	
	/*
	 * Basic degree Test with only two terms
	 */
	
	@Test
	public void testDegreeWhenTwoTerms() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
		
		pol.setTerms(p1,p2);
		
		EasyMock.replay(p1,p2);
		
		int result = pol.degree();
		
		assertEquals(3,result,WITHIN_FUDGE_FACTOR);
		
		EasyMock.verify(p1,p2);
	}
	
	/*
	 *  Testing degree with edge case in zero Terms should result in -1
	 */
	
	@Test
	public void testDegreeWhenZeroTerms() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		
		int result = pol.degree();
		
		assertEquals(-1,result,WITHIN_FUDGE_FACTOR);
			
	}
	
	/*
	 * Basic degree Test edge case with only one term
	 */
	
	@Test
	public void testDegreeWhenOneTerms() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p1);
		
		EasyMock.replay(p1);
		
		int result = pol.degree();
		
		assertEquals(4,result,WITHIN_FUDGE_FACTOR);
		
		EasyMock.verify(p1);
	}

	/*
	 * Testing degree with edge case of maximum values
	 */
	@Test
	public void testDegreeWhenTenTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
				
		//PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(-5.0, 2);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.getExponent()).andReturn(6).anyTimes();
				
		//PolyTerm p5 = new PolyTermBasic(8.0, 1);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.getExponent()).andReturn(1).anyTimes();
				
		//PolyTerm p6 = new PolyTermBasic(-2.0, 3);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.getExponent()).andReturn(3).anyTimes();
				
		//PolyTerm p7 = new PolyTermBasic(6.0, 4);
		PolyTerm p7 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p7.getExponent()).andReturn(4).anyTimes();
				
		//PolyTerm p8 = new PolyTermBasic(3.6, 2);
		PolyTerm p8 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p8.getExponent()).andReturn(2).anyTimes();
						
		//PolyTerm p9 = new PolyTermBasic(0.4, 4);
		PolyTerm p9 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p9.getExponent()).andReturn(4).anyTimes();
						
		//PolyTerm p10 = new PolyTermBasic(-8.0, 2);
		PolyTerm p10 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p10.getExponent()).andReturn(2).anyTimes();
						
		
						
		
		// configure our test subject with 2 terms
		pol.setTerms(p10,p9,p8,p7,p6,p5,p4,p3,p2,p1);

		
		EasyMock.replay(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);		// done training.
		
		double result = pol.degree();
		
		// now check that evaluate is working.
		assertEquals(6, result, WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
		
	}
	
	/*
	 * Testing the addTerm methods
	 * 
	 * This test has two values already in the array with one more being added
	 * which will have a different large exponent from the other terms
	 * landing in front of the list
	 */
	
	
	@Test
	public void testAddTermWithObviousLargeDifferentExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
	
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(6.0, 5);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(5).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Added PolyTerm addp = new PolyTermBasic(5.0, 10);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(10).anyTimes();
		
		
		EasyMock.replay(p1,p2,p3,addp);
		
		pol.addTerm(addp);
		
		//creating variables to compare the front of the array to
		double frontcoe = pol.myTerms[0].getCoefficient();
		int frontexp = pol.myTerms[0].getExponent();
		
		
		//checking addp
		assertEquals(5.0,frontcoe,WITHIN_FUDGE_FACTOR);
		assertEquals(10,frontexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics to make sure they wern't combined
		//and shifted correctly
		
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(6.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(5, compareexp, WITHIN_FUDGE_FACTOR);
		//checking 3rd term
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
		
		assertEquals(3.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(4, compareexp, WITHIN_FUDGE_FACTOR);
		//checking 4th term
		comparecoe = pol.myTerms[3].getCoefficient();
		compareexp = pol.myTerms[3].getExponent();
		
		assertEquals(4.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(3, compareexp, WITHIN_FUDGE_FACTOR);

		
			EasyMock.verify(p1,p2,p3,addp);
		
	}
	
	/*
	 * Testing AddTerm with small exponent, should land at the end of 
	 * the array
	 */
	@Test
	public void testAddTermWithObviousDifferentSmallExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
	
		//PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(6.0, 5);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(5).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Added PolyTerm addp = new PolyTermBasic(5.0, 1);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(1).anyTimes();
		
		
		EasyMock.replay(p1,p2,p3,addp);
		
		pol.addTerm(addp);
		
		//creating variables to compare the end of the array to
		double endcoe = pol.myTerms[3].getCoefficient();
		int endexp = pol.myTerms[3].getExponent();
		
		
		//checking addp
		assertEquals(5.0,endcoe,WITHIN_FUDGE_FACTOR);
		assertEquals(1,endexp,WITHIN_FUDGE_FACTOR);


		
			EasyMock.verify(p1,p2,p3,addp);
		
	}
	

	/*
	 * Testing Addterm with an obvious middle exponent and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermWithObviousDifferentMiddleExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 8);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(8).anyTimes();
	
		//PolyTerm p2 = new PolyTermBasic(4.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(6.0, 9);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(9).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Added PolyTerm addp = new PolyTermBasic(3.0, 5);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(5).anyTimes();
		
		
		EasyMock.replay(p1,p2,p3,addp);
		
		pol.addTerm(addp);
		
		//creating variables to compare the term around the middle of the array to
		double midcoe = pol.myTerms[2].getCoefficient();
		int midexp = pol.myTerms[2].getExponent();
		
		
		//checking addp
		assertEquals(3.0,midcoe,WITHIN_FUDGE_FACTOR);
		assertEquals(5,midexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics in front and behind addp to make sure they didn't combined
		//and shifted correctly
		//checking term behind addp
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(3.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(8, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking term in front of addp
		
		comparecoe = pol.myTerms[3].getCoefficient();
		compareexp = pol.myTerms[3].getExponent();
		
		assertEquals(4.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(2, compareexp, WITHIN_FUDGE_FACTOR);
		
		
			EasyMock.verify(p1,p2,p3,addp);
		
	}
	
	
	
	/*
	 * Testing Addterm with the same Largest exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermWithSameLargestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 3);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(5.0, 6);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(6).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(9.0, 6);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(9.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(6).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(4.0, 6);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(6).anyTimes();
		EasyMock.expect(addp.add(p3)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
		//creating variables to compare the term around the middle of the array to
		double firstcoe = pol.myTerms[0].getCoefficient();
		int firstexp = pol.myTerms[0].getExponent();
		
		
		//checking changp
		assertEquals(9.0,firstcoe,WITHIN_FUDGE_FACTOR); //currently changep
		assertEquals(6,firstexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics in front of changep to make sure they didn't combined
		//and shifted correctly
	
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(3.0, comparecoe, WITHIN_FUDGE_FACTOR); //Currently addp NEED TO REMOVE
		assertEquals(3, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking third term
		
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
		
		assertEquals(2.0, comparecoe, WITHIN_FUDGE_FACTOR); // got shifted up, shouldn't have
		assertEquals(2, compareexp, WITHIN_FUDGE_FACTOR);
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	
	
	/*
	 * Testing Addterm with the same smallest exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermWithSameSmallestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(5.0, 5);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(5).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(6.0, 6);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(6).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(8.0, 2);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(2).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(5.0, 2);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(2).anyTimes();
		EasyMock.expect(addp.add(p2)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
		//creating variables to compare the end of the array to what the correct answer should be
		double endcoe = pol.myTerms[2].getCoefficient();
		int endexp = pol.myTerms[2].getExponent();
		
		
		//checking changp
		assertEquals(8.0,endcoe,WITHIN_FUDGE_FACTOR); //currently changep
		assertEquals(2,endexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics behind changep to make sure they didn't combined
		//and shifted correctly
	
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(5.0, comparecoe, WITHIN_FUDGE_FACTOR); //Currently addp NEED TO REMOVE
		assertEquals(5, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking first term
		
		comparecoe = pol.myTerms[0].getCoefficient();
		compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(6.0, comparecoe, WITHIN_FUDGE_FACTOR); // got shifted up, shouldn't have
		assertEquals(6, compareexp, WITHIN_FUDGE_FACTOR);
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	
	
	
	
	/*
	 * Testing Addterm with the same Middle exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermWithSameMiddleExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(-4.0, 4);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(-4.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(4).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(-7.0, 4);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(-7.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(4).anyTimes();
		EasyMock.expect(addp.add(p1)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
		//creating variables to compare the middle of the array to what the correct answer should be
		double midcoe = pol.myTerms[1].getCoefficient();
		int midexp = pol.myTerms[1].getExponent();
		
		
		//checking changp
		assertEquals(-4.0,midcoe,WITHIN_FUDGE_FACTOR); //currently changep
		assertEquals(4,midexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics behind changep to make sure they didn't combined
		//and shifted correctly
	
		double comparecoe = pol.myTerms[2].getCoefficient();
		double compareexp = pol.myTerms[2].getExponent();
		
		assertEquals(2.0, comparecoe, WITHIN_FUDGE_FACTOR); //Currently addp NEED TO REMOVE
		assertEquals(2, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking first term
		
		comparecoe = pol.myTerms[0].getCoefficient();
		compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(8.0, comparecoe, WITHIN_FUDGE_FACTOR); // got shifted up, shouldn't have
		assertEquals(8, compareexp, WITHIN_FUDGE_FACTOR);
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	
	
	/*
	 * Testing Addterm that cancels the Largest exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermCancelLargestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 3);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(6.0, 6);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(6).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(9.0, 6);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(0.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(6).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(-6.0, 6);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(-6.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(6).anyTimes();
		EasyMock.expect(addp.add(p3)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
		//creating variables to compare the term around the middle of the array to
		double firstcoe = pol.myTerms[0].getCoefficient();
		int firstexp = pol.myTerms[0].getExponent();
		
		
		//checking the first term, which should be the second term
		assertEquals(3.0,firstcoe,WITHIN_FUDGE_FACTOR); //currently changep
		assertEquals(3,firstexp,WITHIN_FUDGE_FACTOR);

		
		//checking the other polyTermBasics in front of changep to make sure they didn't combined
		//and shifted correctly
	
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(2.0, comparecoe, WITHIN_FUDGE_FACTOR); //Currently addp NEED TO REMOVE
		assertEquals(2, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking third term
		
		assertNull(pol.myTerms[2]); // since the other terms have been shifted down this term should not exist
		
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	

	/*
	 * Testing Addterm that cancels the middle exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermCancelMiddleExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(-5.0, 5);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(-5.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(5).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(0.0, 5);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(0.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(5).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(5.0, 5);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(5).anyTimes();
		EasyMock.expect(addp.add(p1)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
	
		
		//checking the middle term, should now be p2 value
		
			double midcoe = pol.myTerms[1].getCoefficient();
			double midexp = pol.myTerms[1].getExponent();
			
	
			assertEquals(2.0, midcoe, WITHIN_FUDGE_FACTOR); 
			assertEquals(2, midexp, WITHIN_FUDGE_FACTOR);
	
		

		
		//checking first term which shouldn't have changed
	
		double comparecoe = pol.myTerms[0].getCoefficient();
		double compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(8.0, comparecoe, WITHIN_FUDGE_FACTOR); 
		assertEquals(8, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking third term which should no longer exist
		
		assertNull(pol.myTerms[2]);
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	
	/*
	 * Testing Addterm that cancels the smallest exponent
	 * adding them together and comparing its
	 * placement with the other terms
	 */
	
	@Test
	public void testAddTermCancelSmallestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(7.0, 7);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(7).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		//Final combined changep = new PolyTermBasic(0.0, 2);
		PolyTerm changep = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(changep.getCoefficient()).andReturn(0.0).anyTimes();
		EasyMock.expect(changep.getExponent()).andReturn(2).anyTimes();
		
		//Added PolyTerm addp = new PolyTermBasic(-2.0, 2);
		PolyTerm addp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(addp.getCoefficient()).andReturn(-2.0).anyTimes();
		EasyMock.expect(addp.getExponent()).andReturn(2).anyTimes();
		EasyMock.expect(addp.add(p2)).andReturn(changep).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,addp,changep);
		
		pol.addTerm(addp);
		
	
		
		//checking changp, should not exist
		assertNull(pol.myTerms[2]); 
	
		

		
		//checking the other polyTermBasics to make sure they didn't change
	
		double comparecoe = pol.myTerms[1].getCoefficient();
		double compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(7.0, comparecoe, WITHIN_FUDGE_FACTOR); 
		assertEquals(7, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking first term
		
		comparecoe = pol.myTerms[0].getCoefficient();
		compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(8.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(8, compareexp, WITHIN_FUDGE_FACTOR);
		
		
			EasyMock.verify(p1,p2,p3,addp,changep);
		
	}
	
	
	
	/*
	 * Test removeTerm with smallest term
	 * leaving only a null with no shifts
	 */
	
	@Test
	public void testRemoveTermSmallestTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(7.0, 7);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(7).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		
		EasyMock.replay(p1,p2,p3);
		
		
		//checking to see if the method 'found' the correct term
		assertEquals(2, pol.removeTerm(2).getExponent());
		
		//checking the array placement for a removed term
		assertNull(pol.myTerms[2]);
		
		
		EasyMock.verify(p1,p2,p3);
	}
	
	/*
	 * Test removeTerm with largest term
	 * leaving only two terms with both shifted down
	 */
	
	@Test
	public void testRemoveTermLargestTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(3.0, 3);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(3).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		
		EasyMock.replay(p1,p2,p3);
		
		
		//checking to see if the method 'found' the correct term
		assertEquals(8, pol.removeTerm(8).getExponent());
		
		//checking the array placement for a removed term should equal p1 values
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(3.0, comparecoe, WITHIN_FUDGE_FACTOR); 
		assertEquals(3, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking the third element which now should be null due to shifts
		assertNull(pol.myTerms[2]);
		
		EasyMock.verify(p1,p2,p3);
	}
	
	/*
	 * Testing to remove the middle term in the array.
	 * the third element should have shifted down while the 
	 * first element should not have moved
	 */
	
	@Test
	public void testRemoveTermMiddleTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(-4.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(-4.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		
		EasyMock.replay(p1,p2,p3);
		
		
		//checking to see if the method 'found' the correct term 
		assertEquals(4, pol.removeTerm(4).getExponent());
		
		//checking the array placement for a removed term should equal p2 values
		double comparecoe = pol.myTerms[1].getCoefficient();
		int compareexp = pol.myTerms[1].getExponent();
		
		assertEquals(2.0, comparecoe, WITHIN_FUDGE_FACTOR); 
		assertEquals(2, compareexp, WITHIN_FUDGE_FACTOR);
		
		//checking first element which should not have changed
		comparecoe = pol.myTerms[0].getCoefficient();
		compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(8.0, comparecoe, WITHIN_FUDGE_FACTOR);
		assertEquals(8, compareexp, WITHIN_FUDGE_FACTOR);
		
		
		
		//checking the third element which now should be null due to shifts
		assertNull(pol.myTerms[2]);
		
		EasyMock.verify(p1,p2,p3);
	}
	
	
	/*
	 * Testing the case that it couldn't find exponent in the list due to 
	 * the exponent not existing in the list, should return a null
	 * 
	 */
	
	@Test
	public void testRemoveTermNoTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(-4.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(-4.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		
		EasyMock.replay(p1,p2,p3);
		
		assertNull(pol.removeTerm(20));
	
		EasyMock.verify(p1,p2,p3);
	}

	
	/*
	 * Testing termAt and making sure it returns the appropriate term
	 * 
	 */
	
	@Test
	public void testTermAtRegularTerm() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(-4.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(-4.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		EasyMock.replay(p1,p2,p3);
		
		//checking the term in the front
		assertEquals(8.0, pol.termAt(0).getCoefficient(), WITHIN_FUDGE_FACTOR);
		assertEquals(8, pol.termAt(0).getExponent());
		
		//checking the term at the end
		
		assertEquals(2.0, pol.termAt(2).getCoefficient(), WITHIN_FUDGE_FACTOR);
		assertEquals(2, pol.termAt(2).getExponent());
		
		//checking the term in the middle
		
		assertEquals(-4.0, pol.termAt(1).getCoefficient(), WITHIN_FUDGE_FACTOR);
		assertEquals(4, pol.termAt(1).getExponent());
		
		EasyMock.verify(p1,p2,p3);
	}
	
	
	/*
	 * Testing termAt for a null result
	 */
	public void testTermAtNullTerm() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		assertNull(pol.termAt(0));
		
	}
	
	
	/*
	 * Testing indexOf for the placements of regular terms based of of exponent
	 * 
	 */
	
	@Test
	public void testIndexOfRegularTerms() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		
		//PolyTerm p1 = new PolyTermBasic(-4.0, 4);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(-4.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(4).anyTimes();
		
		//PolyTerm p2 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(2).anyTimes();
		
		//PolyTerm p3 = new PolyTermBasic(8.0, 8);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(8).anyTimes();
		
		
		pol.setTerms(p3,p1,p2);
		
		EasyMock.replay(p1,p2,p3);
		
		//checking the index of the term in the front
		assertEquals(0, pol.indexOf(8), WITHIN_FUDGE_FACTOR);
		
		//checking the index of the middle term
		assertEquals(1, pol.indexOf(4), WITHIN_FUDGE_FACTOR);
		
		//checking the index of the last term
		assertEquals(2, pol.indexOf(2), WITHIN_FUDGE_FACTOR);
				
		
		
		EasyMock.verify(p1,p2,p3);
		
	}
	
	
	/*
	 * Testing indexOf with an exponent that's not in the array
	 * should return a -1
	 */
	@Test
	public void testindexOfNullTerm() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		
		assertEquals(-1,pol.indexOf(20));	
	}
	
	
	/*
	 * Basic test of addPolynomial with 'standard' polynomials
	 * with no similar terms which means all the terms should just be inserted into the 
	 * first polynomial
	 */
	@Test
	public void testAddPolynomialBasic() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
				
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		//setting up poladd terms
		
		//PolyTerm p4 = new PolyTermBasic(5.0, 5);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(p4.getExponent()).andReturn(5).anyTimes();
						
		//PolyTerm p5 = new PolyTermBasic(6.0, 6);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p5.getExponent()).andReturn(6).anyTimes();
						
		//PolyTerm p6 = new PolyTermBasic(7.0, 7);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(p6.getExponent()).andReturn(7).anyTimes();
				
		poladd.setTerms(p6,p5,p4);
		
		EasyMock.replay(p1,p2,p3,p4,p5,p6);
			
		pol.addPolynomial(poladd);
		
		//checking the first term of pol which should now be p6;
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(7.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(7,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the second term of pol which should now be p5;
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
				
		assertEquals(6.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(6,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the third term of pol which should now be p4;
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
						
		assertEquals(5.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(5,compareexp,WITHIN_FUDGE_FACTOR);
	
		//checking the fourth term of pol which should now be p3;
		comparecoe = pol.myTerms[3].getCoefficient();
		compareexp = pol.myTerms[3].getExponent();
								
		assertEquals(4.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the fourth term of pol which should now be p2;
		comparecoe = pol.myTerms[4].getCoefficient();
		compareexp = pol.myTerms[4].getExponent();
										
		assertEquals(3.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(3,compareexp,WITHIN_FUDGE_FACTOR);
		
		
		//checking the last term of pol which should now be p1;
		comparecoe = pol.myTerms[5].getCoefficient();
		compareexp = pol.myTerms[5].getExponent();
										
		assertEquals(2.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(2,compareexp,WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6);
		
	}
	
	/*
	 * Edge Case test of addPolynomial with 'standard' polynomials
	 * with no terms in the added polynomial which means all the terms should just be 
	 * the same
	 */
	@Test
	public void testAddPolynomialNothingInOtherList() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
				
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		//setting up poladd terms
		
		
		EasyMock.replay(p1,p2,p3);
			
		pol.addPolynomial(poladd);
		
		//checking the first term of pol which should now be p6;
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(4.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the second term of pol which should now be p5;
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
				
		assertEquals(3.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(3,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the third term of pol which should now be p4;
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
						
		assertEquals(2.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(2,compareexp,WITHIN_FUDGE_FACTOR);
		
		
		EasyMock.verify(p1,p2,p3);
		
	}
	
	
	/*
	 * Basic test of addPolynomial with 'standard' polynomials
	 * with one similar term which means one term should change with the rest being inserted into the 
	 * first polynomial
	 */
	@Test
	public void testAddPolynomialBasicOneSimilarTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
	
				
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		//setting up poladd terms
		
		//PolyTerm p4 = new PolyTermBasic(5.0, 5);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(p4.getExponent()).andReturn(5).anyTimes();
						
		//PolyTerm p5 = new PolyTermBasic(6.0, 3);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p5.getExponent()).andReturn(3).anyTimes();
						
		//PolyTerm p6 = new PolyTermBasic(7.0, 7);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(p6.getExponent()).andReturn(7).anyTimes();
				
		poladd.setTerms(p6,p5,p4);
		
		//setting up combined terms
		
		//PolyTerm combinedp = new PolyTermBasic(9.0,3);
		PolyTerm combinedp = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(combinedp.getCoefficient()).andReturn(9.0).anyTimes();
		EasyMock.expect(combinedp.getExponent()).andReturn(3).anyTimes();
		EasyMock.expect(p5.add(p2)).andReturn(combinedp);					
		
		EasyMock.replay(p1,p2,p3,p4,p5,p6,combinedp);
	
		//p5 should combine with p3 with the other two terms being inserted into pol
		pol.addPolynomial(poladd);
		
		//checking the first term of pol which should now be p6;
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(7.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(7,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the second term of pol which should now be p4;
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
				
		assertEquals(5.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(5,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the third term of pol which should now be the combined term;
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
						
		assertEquals(4.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
	
		//checking the fourth term of pol which should now be p2;
		comparecoe = pol.myTerms[3].getCoefficient();
		compareexp = pol.myTerms[3].getExponent();
								
		assertEquals(9.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(3,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the fourth term of pol which should now be p1;
		comparecoe = pol.myTerms[4].getCoefficient();
		compareexp = pol.myTerms[4].getExponent();
										
		assertEquals(2.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(2,compareexp,WITHIN_FUDGE_FACTOR);
		
		
		//checking the last term of pol which should now be null;
		
		assertNull(pol.myTerms[5]);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6,combinedp);
		
	}
	
	/*
	 * Basic test of addPolynomial with 'standard' polynomials
	 * with all similar terms which means all terms should change 
	 * with only three terms left in the polynomial
	 */
	@Test
	public void testAddPolynomialBasicAllSimilarTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
	
				
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		//setting up poladd terms
		
		//PolyTerm p4 = new PolyTermBasic(5.0, 2);
		PolyTerm p4 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p4.getCoefficient()).andReturn(5.0).anyTimes();
		EasyMock.expect(p4.getExponent()).andReturn(2).anyTimes();
						
		//PolyTerm p5 = new PolyTermBasic(6.0, 3);
		PolyTerm p5 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p5.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(p5.getExponent()).andReturn(3).anyTimes();
						
		//PolyTerm p6 = new PolyTermBasic(7.0, 4);
		PolyTerm p6 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p6.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(p6.getExponent()).andReturn(4).anyTimes();
				
		poladd.setTerms(p6,p5,p4);
		
		//setting up combined terms
		
		//PolyTerm combinedp1 = new PolyTermBasic(7.0,2);
		PolyTerm combinedp1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(combinedp1.getCoefficient()).andReturn(7.0).anyTimes();
		EasyMock.expect(combinedp1.getExponent()).andReturn(2).anyTimes();
		EasyMock.expect(p4.add(p1)).andReturn(combinedp1);	
		
		//PolyTerm combinedp2 = new PolyTermBasic(9.0,3);
		PolyTerm combinedp2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(combinedp2.getCoefficient()).andReturn(9.0).anyTimes();
		EasyMock.expect(combinedp2.getExponent()).andReturn(3).anyTimes();
		EasyMock.expect(p5.add(p2)).andReturn(combinedp2);	
		
		//PolyTerm combinedp3 = new PolyTermBasic(9.0,3);
		PolyTerm combinedp3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(combinedp3.getCoefficient()).andReturn(11.0).anyTimes();
		EasyMock.expect(combinedp3.getExponent()).andReturn(4).anyTimes();
		EasyMock.expect(p6.add(p3)).andReturn(combinedp3);	
		
		EasyMock.replay(p1,p2,p3,p4,p5,p6,combinedp1,combinedp2,combinedp3);
	
		//p5 should combine with p3 with the other two terms being inserted into pol
		pol.addPolynomial(poladd);
		
		//checking the first term of pol which should now be p6;
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
		
		assertEquals(11.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the second term of pol which should now be p4;
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
				
		assertEquals(9.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(3,compareexp,WITHIN_FUDGE_FACTOR);
		
		//checking the third term of pol which should now be the combined term;
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
						
		assertEquals(7.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(2,compareexp,WITHIN_FUDGE_FACTOR);
	
		//checking the fourth term of pol which should still be null since nothing was inserted
		assertNull(pol.myTerms[3]);
		
		//checking the fourth term of pol which should still be null;
		assertNull(pol.myTerms[4]);
										
		
		//checking the last term of pol which should still be null;
		
		assertNull(pol.myTerms[5]);
		
		
		EasyMock.verify(p1,p2,p3,p4,p5,p6,combinedp1,combinedp2,combinedp3);
		
	}
	
	/*
	 * testing multPolynomial with a basic list
	 * 
	 */
	
	@Test
	public void testMultPolynomialBasicList() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial polmult = new TestPolynomial();
	
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 1);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		
		
		pol.setTerms(p1);
		
		//setting up polmult terms
		
		//PolyTerm p4 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
						
		//PolyTerm p5 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
						
		
				
		polmult.setTerms(p3,p2);
		
		
		/*
		 * creating the final results that were multiplied from
		 * I tried to make the list as simple as possible but
		 * I couldn't figure out what mock expects were needed to pass all
		 * the barriers in time
		 */
		
		PolyTerm final1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(final1.getCoefficient()).andReturn(6.0).anyTimes();
		EasyMock.expect(final1.getExponent()).andReturn(4).anyTimes();
		
		PolyTerm final2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(final2.getCoefficient()).andReturn(8.0).anyTimes();
		EasyMock.expect(final2.getExponent()).andReturn(5).anyTimes();
		
		EasyMock.expect(p1.multiply(p3)).andReturn(final1).anyTimes();
		EasyMock.expect(p1.multiply(p2)).andReturn(final2).anyTimes();
		
		
		
		EasyMock.replay(p1,p2,p3,final1,final2);
		
		pol.multPolynomial(polmult);
		
		//checking the first term of pol which should now be 8x^5
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
				
		assertEquals(8.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(5,compareexp,WITHIN_FUDGE_FACTOR);
				
		//checking the second term of pol which should now be 6x^4
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
					
		assertEquals(6.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
				
		EasyMock.verify(p1,p2,p3,final1,final2);
	}
	
	
	
	/*
	 * testing multPolynomial with a null list
	 * the result should be the original list
	 */
	@Test
	public void testMultPolynomialNullList() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial polmult = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.getCoefficient()).andReturn(2.0).anyTimes();
		EasyMock.expect(p1.getExponent()).andReturn(2).anyTimes();
				
		//PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.getCoefficient()).andReturn(3.0).anyTimes();
		EasyMock.expect(p2.getExponent()).andReturn(3).anyTimes();
	
				
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.getCoefficient()).andReturn(4.0).anyTimes();
		EasyMock.expect(p3.getExponent()).andReturn(4).anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		EasyMock.replay(p1,p2,p3);
		
		pol.multPolynomial(polmult);
		
		//checking the first term of pol 
		double comparecoe = pol.myTerms[0].getCoefficient();
		int compareexp = pol.myTerms[0].getExponent();
				
		assertEquals(4.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(4,compareexp,WITHIN_FUDGE_FACTOR);
				
		//checking the second term of pol 
		comparecoe = pol.myTerms[1].getCoefficient();
		compareexp = pol.myTerms[1].getExponent();
						
		assertEquals(3.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(3,compareexp,WITHIN_FUDGE_FACTOR);
				
		//checking the third term of pol 
		comparecoe = pol.myTerms[2].getCoefficient();
		compareexp = pol.myTerms[2].getExponent();
								
		assertEquals(2.0,comparecoe,WITHIN_FUDGE_FACTOR);
		assertEquals(2,compareexp,WITHIN_FUDGE_FACTOR);
		
		
	}
	
	
	
	/*
	 * Testing toString no parameters with terms
	 * 
	 * 
	 */
	
	@Test
	public void testToStringNoParameters() {
		
		TestPolynomial pol = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.isNegative()).andReturn(false).anyTimes();
		EasyMock.expect(p1.getString()).andReturn("2.0x^2").anyTimes();
						
		//PolyTerm p2 = new PolyTermBasic(-3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.isNegative()).andReturn(true).anyTimes();
		EasyMock.expect(p2.getString()).andReturn("-3.0x^3").anyTimes();
			
						
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.isNegative()).andReturn(false).anyTimes();
		EasyMock.expect(p3.getString()).andReturn("4.0x^4").anyTimes();
				
		pol.setTerms(p3,p2,p1);
		
		EasyMock.replay(p1,p2,p3);
		
		String str = "4.0x^4-3.0x^3+2.0x^2"; 
		
		assertEquals(str, pol.toString());
		
		EasyMock.verify(p1,p2,p3);
		
	}
	
	/*
	 * Testing toString no parameters with no terms
	 */
	
	@Test
	public void testToStringNoParametersNoTerms() {
		
		TestPolynomial pol = new TestPolynomial();
		
		//setting up pol terms
		
		String str = ""; 
		
		assertEquals(str, pol.toString());
		
		
	}
	
	
	
	/*
	 * Testing toString with x parameter with terms
	 */
	
	@Test
	public void testToStringWithParameters() {
		
		TestPolynomial pol = new TestPolynomial();
		
		//setting up pol terms
		
		//PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p1 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p1.isNegative()).andReturn(false).anyTimes();
		EasyMock.expect(p1.value(2)).andReturn(8.0).anyTimes();
		EasyMock.expect(p1.getString()).andReturn(" 8.0 ").anyTimes();
						
		//PolyTerm p2 = new PolyTermBasic(-3.0, 3);
		PolyTerm p2 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p2.isNegative()).andReturn(true).anyTimes();
		EasyMock.expect(p2.value(2)).andReturn(-24.0).anyTimes();
		EasyMock.expect(p2.getString()).andReturn(" -24.0 ").anyTimes();	
						
		//PolyTerm p3 = new PolyTermBasic(4.0, 4);
		PolyTerm p3 = EasyMock.createMock(PolyTerm.class);
		EasyMock.expect(p3.isNegative()).andReturn(false).anyTimes();
		EasyMock.expect(p3.value(2)).andReturn(64.0).anyTimes();
		EasyMock.expect(p3.getString()).andReturn(" 64.0 ").anyTimes();
		
		pol.setTerms(p3,p2,p1);
		
		EasyMock.replay(p1,p2,p3);
		
		String str = "f(2.0) = 64.0-24.0+8.0 = 48.0"; 
		
		assertEquals(str, pol.toString(2.0));
		
		EasyMock.verify(p1,p2,p3);
	}
	
	/*
	 * Testing toString with parameters with no terms
	 */
	
	@Test
	public void testToStringWithParametersNoTerms() {
		
		TestPolynomial pol = new TestPolynomial();
		
		//setting up pol terms
		
		String str = "f(2.0) =  = 0.0"; 
		
		assertEquals(str, pol.toString(2.0));
		
		
	}
	
	
	
	
}
