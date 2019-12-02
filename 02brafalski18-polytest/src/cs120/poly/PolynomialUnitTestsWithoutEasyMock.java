package cs120.poly;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;





class PolynomialUnitTestsWithoutEasyMock {
	
	
	
	/**
	 * 
	 * the definition for TestPolynomial extends our subject
	 * to use Polynomial Array with added methods 
	 * 
	 * These tests will use the same methods in PolynomialUnitTests
	 * except without EasyMock and the use of PolyTermBasic
	 * 
	 * 
	 * 
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
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		
		pol.setTerms(p2,p1);
		
		double result = pol.value(2.0);
		
		assertEquals(44.0, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * Testing value with zero terms.
	 * this test should result with zero
	 */
	
	@Test
	public void testValueWithZeroTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
	
		
		double result = pol.value(2.0);
		
		assertEquals(0.0, result, WITHIN_FUDGE_FACTOR);
		
	}
	
	/*
	 * testing value with one term which should result in
	 * 12.0
	 * 
	 * 
	 */
	
	
	@Test
	public void testValueWithOneTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		
		
		pol.setTerms(p1);
		
		double result = pol.value(2.0);
		
		assertEquals(12.0, result, WITHIN_FUDGE_FACTOR);
		
	}
	
	/*
	 * Testing value with full 'random' terms
	 * with the final result of all the terms calculated to 4405.2
	 */
	@Test
	public void testValueWhenFullTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(-5.0, 1);
		PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p5 = new PolyTermBasic(8.0, 5);
		PolyTerm p6 = new PolyTermBasic(-2.0, 7);
		PolyTerm p7 = new PolyTermBasic(6.0, 9);
		PolyTerm p8 = new PolyTermBasic(3.6, 8);
		PolyTerm p9 = new PolyTermBasic(0.4, 10);
		PolyTerm p10 = new PolyTermBasic(-8.0, 4);
		
		
		
		
		pol.setTerms(p9,p7,p8,p6,p4,p5,p10,p2,p1,p3);
		
		double result = pol.value(2.0);
		
		assertEquals(4405.2, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * Testing size with two basic terms
	 * with the result equaling two
	 * 
	 */
	@Test
	public void testSizeWhenTwoTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		
		pol.setTerms(p2,p1);
		
		double result = pol.size();
		
		assertEquals(2, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * testing edge case size with zero terms
	 * should result in 0
	 */
	@Test
	public void testSizeWhenZeroTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		double result = pol.size();
		
		assertEquals(0, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * testing size with one term
	 */
	
	@Test
	public void testSizeWhenOneTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
			
		pol.setTerms(p1);
		
		double result = pol.size();
		
		assertEquals(1, result, WITHIN_FUDGE_FACTOR);
		
	}
	
	/*
	 * Testing edge case size with full terms
	 */
	@Test
	public void testSizeWhenFullTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(-5.0, 1);
		PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p5 = new PolyTermBasic(8.0, 5);
		PolyTerm p6 = new PolyTermBasic(-2.0, 7);
		PolyTerm p7 = new PolyTermBasic(6.0, 9);
		PolyTerm p8 = new PolyTermBasic(3.6, 8);
		PolyTerm p9 = new PolyTermBasic(0.4, 10);
		PolyTerm p10 = new PolyTermBasic(-8.0, 4);
		
		
		
		
		pol.setTerms(p9,p7,p8,p6,p4,p5,p10,p2,p1,p3);
		
		double result = pol.size();
		
		assertEquals(10, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * testing degree with two basic terms with the
	 * largest exponent in the list list being 3
	 */
	
	@Test
	public void testDegreeWhenTwoTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		
		pol.setTerms(p2,p1);
		
		double result = pol.degree();
		
		assertEquals(3, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * Testing degree with zero terms in the list
	 * The method should return -1 
	 */
	
	@Test
	public void testDegreeWhenZeroTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		
		double result = pol.degree();
		
		assertEquals(-1, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * Testing degree with one term, should return
	 * the only exponent in the list 
	 */
	
	@Test
	public void testDegreeWhenOneTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		
		
		pol.setTerms(p1);
		
		double result = pol.degree();
		
		assertEquals(2, result, WITHIN_FUDGE_FACTOR);
		
		
	}
	
	/*
	 * Testing degree with full terms
	 * should go through the entire list to find the
	 * obvious largest channel
	 */
	@Test
	public void testDegreeWhenFullTerms() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(-5.0, 1);
		PolyTerm p4 = new PolyTermBasic(1.5, 6);
		PolyTerm p5 = new PolyTermBasic(8.0, 5);
		PolyTerm p6 = new PolyTermBasic(-2.0, 7);
		PolyTerm p7 = new PolyTermBasic(6.0, 9);
		PolyTerm p8 = new PolyTermBasic(3.6, 8);
		PolyTerm p9 = new PolyTermBasic(0.4, 15);
		PolyTerm p10 = new PolyTermBasic(-8.0, 4);
		
		
		
		
		pol.setTerms(p9,p7,p8,p6,p4,p5,p10,p2,p1,p3);
		
		double result = pol.degree();
		
		assertEquals(15, result, WITHIN_FUDGE_FACTOR);
		
		
		
	}
	
	/*
	 * testing add term with an obvious large exponent out of three terms
	 * should appear at the front of list with the other terms shifted up a space
	 */
	@Test
	public void testAddTermWithObviousLargeDifferentExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,10);
		
		pol.addTerm(addp);
		
		assertEquals(addp, pol.myTerms[0]);
		
		assertEquals(p3, pol.myTerms[1]);
		
		assertEquals(p2, pol.myTerms[2]);
		
		assertEquals(p1, pol.myTerms[3]);
		
	}
	
	/*
	 * testing addTerm with an obvious small exponent so it should appear at the end of the
	 * list with no other changes in the list
	 */
	@Test
	public void testAddTermWithObviousSmallDifferentExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 8);
		PolyTerm p2 = new PolyTermBasic(4.0, 9);
		PolyTerm p3 = new PolyTermBasic(6.0,10);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,2);
		
		pol.addTerm(addp);
		
		assertEquals(addp, pol.myTerms[3]);
		
		assertEquals(p1, pol.myTerms[2]);
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertEquals(p3, pol.myTerms[0]);
		
	}

	/*
	 * Testing addTerm with an obvious middle exponent, inserting the term into the 
	 * middle of the list with all terms ahead shifting up a space while 
	 * all the terms behind stay the same
	 */
	@Test
	public void testAddTermWithObviousMiddleDifferentExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 8);
		PolyTerm p3 = new PolyTermBasic(6.0,9);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,4);
		
		pol.addTerm(addp);
		
		assertEquals(addp, pol.myTerms[2]);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertEquals(p1, pol.myTerms[3]);
		
	}
	/*
	 * Testing addTerm with a matching large Exponent, adding the 
	 * combing the first term and keeping the other terms the same
	 */
	@Test
	public void testAddTermWithSameLargestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,5);
		PolyTerm finalterm = new PolyTermBasic(11.0,5);
		
		pol.addTerm(addp);
		
		assertEquals(finalterm.getExponent(), pol.myTerms[0].getExponent());
		assertEquals(finalterm.getCoefficient(), pol.myTerms[0].getCoefficient());
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertEquals(p1, pol.myTerms[2]);
		
		assertNull(pol.myTerms[3]);
		
	}
	
	/*
	 * Testing addTerm with a matching smallest exponent. combining the back of the
	 * list and changing none of the other terms
	 */
	
	@Test
	public void testAddTermWithSameSmallestExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,2);
		PolyTerm finalterm = new PolyTermBasic(8.0,2);
		
		pol.addTerm(addp);
		
		assertEquals(finalterm.getExponent(), pol.myTerms[2].getExponent());
		assertEquals(finalterm.getCoefficient(), pol.myTerms[2].getCoefficient());
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertNull(pol.myTerms[3]);
		
	}
	
	/*
	 * Testing addTerm with a matching middle exponent. combining the center of the
	 * list and changing none of the other terms
	 */
	
	@Test
	public void testAddTermWithSameMiddleExponent() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(5.0,3);
		PolyTerm finalterm = new PolyTermBasic(9.0,3);
		
		pol.addTerm(addp);
		
		assertEquals(finalterm.getExponent(), pol.myTerms[1].getExponent());
		assertEquals(finalterm.getCoefficient(), pol.myTerms[1].getCoefficient());
		
		assertEquals(p1, pol.myTerms[2]);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertNull(pol.myTerms[3]);
		
	}
	
	/*
	 * Testing addTerm with that causes the largest exponent's coefficient to equal
	 * zero, moving all the lower terms up a spot
	 */
	
	@Test
	public void testAddTermCancelLargestExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(-6.0,5);
		
		
		pol.addTerm(addp);
		
		assertEquals(p2, pol.myTerms[0]);
		
		assertEquals(p1, pol.myTerms[1]);
		
		assertNull(pol.myTerms[2]);
		
		assertNull(pol.myTerms[3]);
		
	}
	

	/*
	 * Testing addTerm with that causes the smallest exponent's coefficient to equal
	 * zero, with the other terms not moving an inch
	 */
	
	@Test
	public void testAddTermCancelSmallestExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(-3.0,2);
		
		
		pol.addTerm(addp);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertNull(pol.myTerms[2]);
		
		assertNull(pol.myTerms[3]);
		
	}
	

	/*
	 * Testing addTerm with that causes the middle exponent's coefficient to equal
	 * zero, moving the lower terms up a slot while the higher terms don't move
	 */
	@Test
	public void testAddTermCancelMiddleExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm addp = new PolyTermBasic(-4.0,3);
		
		
		pol.addTerm(addp);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertEquals(p1, pol.myTerms[1]);
		
		assertNull(pol.myTerms[2]);
		
		assertNull(pol.myTerms[3]);
		
	}
	
	/*
	 * testing removeTerm with the smallest exponent,
	 * getting rid of the last term and having no
	 * other change in the list
	 */
	
	@Test
	public void testRemoveTermSmallestExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		pol.removeTerm(2);
		
		//checking the other two terms to see if anything changed
		assertEquals(p3, pol.myTerms[0]);
		
		assertEquals(p2, pol.myTerms[1]);
		
		//making sure the last term in the list was removed
		assertNull(pol.myTerms[2]);
		
	
		
	}
	
	/*
	 * testing removeTerm with the largest exponent
	 * making sure all terms above shift down
	 */
	
	@Test
	public void testRemoveTermLargestExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		pol.removeTerm(5);
		
		//p2 should now be where p3 is
		assertEquals(p2, pol.myTerms[0]);
		//p1 should no be where p2 is 
		assertEquals(p1, pol.myTerms[1]);
		//making sure terms were removed and shifted correctly
		assertNull(pol.myTerms[2]);
		
	
		
	}
	
	/*
	 * testing removeTerm on the middle exponent
	 * checking to see if the term above shifts down while the 
	 * first term stays the same
	 */
	
	@Test
	public void testRemoveTermMiddleExponenet() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		pol.removeTerm(3);
		
		assertEquals(p3, pol.myTerms[0]);
		
		//checking placement of p2 which should now be p1
		assertEquals(p1, pol.myTerms[1]);
		
		//checking to make sure the terms shifted and were removed correctly
		assertNull(pol.myTerms[2]);
		
		
		
	}
	
	/*
	 * Testing removeTerm with an non-findable exponent
	 * which should result with zero changes in the list
	 */
	
	@Test
	public void testRemoveTermExponenetNotFound() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		pol.removeTerm(20);
		
		assertEquals(p3, pol.myTerms[0]);
		
		assertEquals(p2, pol.myTerms[1]);
		
		assertEquals(p1, pol.myTerms[2]);
		
		
		
	}
	
	/*
	 * testing termAt with a regular list and selecting
	 * a term to choose between them 
	 */
	@Test
	public void testTermAtRegularTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		
		
		assertEquals(p2, pol.termAt(1));
		
		
		
		
	}
	
	/*
	 * testing TermAt with a null list which 
	 * should just return null
	 */
	
	@Test
	public void testTermAtNullResult() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		
		assertNull(pol.termAt(1));
		
		
	}
	
	/*
	 * testing indexOf with regular terms and selecting a term 
	 * to check with
	 */
	
	@Test
	public void testIndexOfRegularTerm() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(3.0, 2);
		PolyTerm p2 = new PolyTermBasic(4.0, 3);
		PolyTerm p3 = new PolyTermBasic(6.0,5);
		
		
		
		pol.setTerms(p3,p2,p1);
		
		
		
		assertEquals(1, pol.indexOf(3));
		
		
	}
	
	/*
	 * Testing indexOf with a null list which should
	 * just return a -1
	 */
	@Test
	public void testIndexOfNullResult() throws Exception{
		
		TestPolynomial pol = new TestPolynomial();	
		
		assertEquals(-1,pol.indexOf(5));
		
	}
	
	/*
	 * Testing addPolynomial with terms that have no exponents in common,
	 * this should just result in all the terms being inserted into the first polynomial
	 * 
	 * 
	 */
	
	@Test 
	public void testAddPolynomialBasic() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0,4);
		
		pol.setTerms(p3,p2,p1);
		
		PolyTerm p4 = new PolyTermBasic(5.0, 5);
		PolyTerm p5 = new PolyTermBasic(6.0, 6);
		PolyTerm p6 = new PolyTermBasic(7.0, 7);
		
		poladd.setTerms(p6,p5,p4);
		
		pol.addPolynomial(poladd);
		
		assertEquals(p6,pol.myTerms[0]);
		assertEquals(p5,pol.myTerms[1]);
		assertEquals(p4,pol.myTerms[2]);
		assertEquals(p3,pol.myTerms[3]);
		assertEquals(p2,pol.myTerms[4]);
		assertEquals(p1,pol.myTerms[5]);
		
		
	}
	
	/*
	 * Testing an edge case in addPolynomial where nothing is in the polynomial that is 
	 * being added. resulting in a list that doesn't change
	 */
	
	@Test 
	public void testAddPolynomialNothingInOtherList() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0,4);
		
		pol.setTerms(p3,p2,p1);
		
	
		
		pol.addPolynomial(poladd);
		
		assertEquals(p3,pol.myTerms[0]);
		assertEquals(p2,pol.myTerms[1]);
		assertEquals(p1,pol.myTerms[2]);
		
		//making sure nothing was added
		assertNull(pol.myTerms[3]);
		assertNull(pol.myTerms[4]);
		assertNull(pol.myTerms[5]);
		
		
	}
	
	/*
	 * testing addPolynomial with only a single similar exponent between the two lists
	 * p3 should have changed, p5 should not appear in the list and the rest of the terms
	 * should remain as they would have if they were just added
	 * 
	 * The extra polyterm 'changp' checks the exponent and the coefficent due to 
	 * the system crashing if it checks the polys straight up
	 */
	@Test 
	public void testAddPolynomialOneSimilarTerm() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0,4);
		
		pol.setTerms(p3,p2,p1);
		
		//terms that will be added to pol
		PolyTerm p4 = new PolyTermBasic(5.0, 5);
		PolyTerm p5 = new PolyTermBasic(6.0, 3);
		PolyTerm p6 = new PolyTermBasic(7.0, 7);
		
		poladd.setTerms(p6,p5,p4);
		// setting up a polyterm that will be compared to the list
		PolyTerm changep = new PolyTermBasic(9.0,3);
		
		pol.addPolynomial(poladd);
		
		assertEquals(p6,pol.myTerms[0]);
		assertEquals(p4,pol.myTerms[1]);
		assertEquals(p3,pol.myTerms[2]);
		
		assertEquals(changep.getExponent(),pol.myTerms[3].getExponent());
		assertEquals(changep.getCoefficient(),pol.myTerms[3].getCoefficient());
		
		assertEquals(p1,pol.myTerms[4]);
		assertNull(pol.myTerms[5]);
		
		
	}
	
	/*
	 * Testing addPolynomial with where all terms are added together
	 * resulting with a polynomial with three terms
	 */
	
	@Test 
	public void testAddPolynomialAllSimilarTerms() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial poladd = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0, 4);
		
		pol.setTerms(p3,p2,p1);
		
		//terms that will be added to pol
		PolyTerm p4 = new PolyTermBasic(5.0, 2);
		PolyTerm p5 = new PolyTermBasic(6.0, 3);
		PolyTerm p6 = new PolyTermBasic(7.0, 4);
		
		poladd.setTerms(p6,p5,p4);
		
		//setting up terms to compare to pol
		PolyTerm changep1 = new PolyTermBasic(7.0,2);
		PolyTerm changep2 = new PolyTermBasic(9.0,3);
		PolyTerm changep3 = new PolyTermBasic(11.0,4);
		
		pol.addPolynomial(poladd);
		
		
		//checking the added terms in order
		assertEquals(changep3.getExponent(),pol.myTerms[0].getExponent());
		assertEquals(changep3.getCoefficient(),pol.myTerms[0].getCoefficient());
		
		assertEquals(changep2.getExponent(),pol.myTerms[1].getExponent());
		assertEquals(changep2.getCoefficient(),pol.myTerms[1].getCoefficient());
		
		assertEquals(changep1.getExponent(),pol.myTerms[2].getExponent());
		assertEquals(changep1.getCoefficient(),pol.myTerms[2].getCoefficient());
		
		//making sure nothing was added to the other three spots where non added terms would go
		assertNull(pol.myTerms[3]);
		assertNull(pol.myTerms[4]);
		assertNull(pol.myTerms[5]);
		
		
	}
	
	/*
	 * Testing multpolynomial with basic terms in each polynomial
	 * 
	 * The final result calculated to be 28x^11 + 45x^10 + 52x^9 + 27x^8 + 10^7
	 */
	@Test
	public void testmultPolynomialBasic() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial polmult = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0, 4);
		
		pol.setTerms(p3,p2,p1);
		
		//terms that will be multiplied to pol
		PolyTerm p4 = new PolyTermBasic(5.0, 5);
		PolyTerm p5 = new PolyTermBasic(6.0, 6);
		PolyTerm p6 = new PolyTermBasic(7.0, 7);
		
		polmult.setTerms(p6,p5,p4);
		
		//setting up terms to compare to pol
		PolyTerm changep1 = new PolyTermBasic(10.0,7);
		PolyTerm changep2 = new PolyTermBasic(27.0,8);
		PolyTerm changep3 = new PolyTermBasic(52.0,9);
		PolyTerm changep4 = new PolyTermBasic(45.0,10);
		PolyTerm changep5 = new PolyTermBasic(28.0,11);
				
		pol.multPolynomial(polmult);
				
		
				
		//checking the multiplied then added terms in order
		assertEquals(changep5.getExponent(),pol.myTerms[0].getExponent());
		assertEquals(changep5.getCoefficient(),pol.myTerms[0].getCoefficient());
				
		assertEquals(changep4.getExponent(),pol.myTerms[1].getExponent());
		assertEquals(changep4.getCoefficient(),pol.myTerms[1].getCoefficient());
				
		assertEquals(changep3.getExponent(),pol.myTerms[2].getExponent());
		assertEquals(changep3.getCoefficient(),pol.myTerms[2].getCoefficient());
		
		assertEquals(changep2.getExponent(),pol.myTerms[3].getExponent());
		assertEquals(changep2.getCoefficient(),pol.myTerms[3].getCoefficient());
				
		assertEquals(changep1.getExponent(),pol.myTerms[4].getExponent());
		assertEquals(changep1.getCoefficient(),pol.myTerms[4].getCoefficient());
				
		
	}
	
	/*
	 * Testing multPolynomial where the list being multiplied is empty
	 * the final list should not have changed from the origional pol
	 */
	
	@Test
	public void testMultPolynomialNullList() throws Exception{
		TestPolynomial pol = new TestPolynomial();
		TestPolynomial polmult = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0, 4);
		
		pol.setTerms(p3,p2,p1);
		
		pol.multPolynomial(polmult);
		
		//checking the multiplied then added terms in order
		assertEquals(p3,pol.myTerms[0]);
		
		assertEquals(p2,pol.myTerms[1]);
						
		assertEquals(p1,pol.myTerms[2]);
		
	}
	
	/*
	 * testing toString() with basic terms
	 * should equal the string below
	 */
	
	@Test
	public void  testToStringNoParameters() {
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0, 4);
		
		pol.setTerms(p3,p2,p1);
		
		String result = "4.0x^4+3.0x^3+2.0x^2";
		
		assertEquals(result,pol.toString());
		
	}
	
	/*
	 * testing toString() with a full null list
	 * leaving absolutley nothing to compare 
	 * 
	 */
	@Test
	public void testToStringNoParametersNullArray() {
		
		TestPolynomial pol = new TestPolynomial();
		
		String result = "";
		
		assertEquals(result,pol.toString());
		
	}
	
	/*
	 * Testing toString(double x) with basic terms
	 * should have the matching string below
	 */
	@Test
	public void testToStringWithParameterBasic() {
		
		TestPolynomial pol = new TestPolynomial();
		
		PolyTerm p1 = new PolyTermBasic(2.0, 2);
		PolyTerm p2 = new PolyTermBasic(3.0, 3);
		PolyTerm p3 = new PolyTermBasic(4.0, 4);
		
		pol.setTerms(p3,p2,p1);
		
		String result = "f(2.0) = 64.0+24.0+8.0 = 96.0";
		
		assertEquals(result,pol.toString(2.0));
		
		
	}
	
	/*
	 * Testing toString(double x) with a full null list
	 * should just include the x and the result which should be 0
	 */
	
	@Test
	public void testToStringWithParametersNullArray() {
		
		TestPolynomial pol = new TestPolynomial();
		
		String result = "f(2.0) =  = 0.0";
		
		assertEquals(result,pol.toString(2.0));
		
	}
	
	
	
	
}
