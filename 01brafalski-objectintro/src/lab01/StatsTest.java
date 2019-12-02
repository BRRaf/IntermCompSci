package lab01;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * 
 * all correct numbers that the tests use to compare with in this Junit have been
 * checked out using calculators
 * 
 * 
 *  
 */




public class StatsTest {

	double x; 
	
	private ArrayList<Double> testlist;
	
	private Stats testStatZero;
	
	private Stats testStatOne;
	
	private Stats testStatBasic;
	
	private Stats testStatEven;
	
	private Stats testStatComplex;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		x = 0.0; // The number that will be compared to the correct answer to test 
		
		ArrayList<Double> testlist; // The blank list that will be used in tests 
		
		ArrayList<Double> zeroList = new ArrayList<Double>(); // A list with zero elements to test to make sure nothing unexpected happens
		
		ArrayList<Double> oneList= new ArrayList<Double>(); // A list with one element with the element being the double 5.0
		
		oneList.add(5.0);
		
		ArrayList<Double> basicList = new ArrayList<Double>(); // A list with three elements with doubles 1.0, 2.0 and 3.0 with 2.0 in front, 3.0 in the middle and 1.0 at the end
		
		basicList.add(2.0);
		
		basicList.add(3.0);
		
		basicList.add(1.0);
		
		ArrayList<Double> basicListEven = new ArrayList<Double>(); // A list with four elements due to some methods behaving differently if their are odd elements
		
		basicListEven.add(4.0);
		
		basicListEven.add(2.0);
		
		basicListEven.add(1.0);
		
		basicListEven.add(3.0);
		
		ArrayList<Double> complexList = new ArrayList<Double>(); // A list with ten elements, some have decimals and are in a 'random' order
		
		complexList.add(6.0);
		
		complexList.add(9.9);
		
		complexList.add(10.0);
		
		complexList.add(5.2);
		
		complexList.add(7.33);
		
		complexList.add(2.0);
		
		complexList.add(4.1);
		
		complexList.add(5.2);
		
		complexList.add(9.1);
		
		complexList.add(3.5);
		
		testStatZero = new Stats(zeroList); // Object to use in the tests where zero elements is required
		
		testStatOne = new Stats(oneList); // Object to use in the tests where one element is required
		
		testStatBasic = new Stats(basicList); // Object to use in the tests where the basicList is required
		
		testStatEven = new Stats(basicListEven); // Object to use in the tests where the even list is required
		
		testStatComplex = new Stats(complexList); // Object to use in the tests where the complexList is required
		
		
		
	}

	
	@Test
	public void TestOrderListZero() throws Exception {
		
		/**This series of tests will go through all the 
		 * Stat objects with different element sizes
		 * to make sure the Method OrderList is 
		 * functional.
		 */	
	try {
		testStatZero.OrderList();
		System.out.println("Zero list test succeeded");
	} catch (Exception e) {
		fail("Test shouldn't crash due to nothing being done or changed");
	}
	
	}
	
	
	@Test
	public void TestOrderListOne() throws Exception {
	
		
		testlist = testStatOne.OrderList();
		if (testlist.get(0) == 5.0) {
		System.out.println("One list test succeeded");
		} else {
			fail("The list has changed somehow.");
		}
		
	
	}
	

	@Test
	public void TestOrderListBasic() throws Exception {
	
		testlist = testStatBasic.OrderList();
		if (testlist.get(0) == 1.0 && testlist.get(1) == 2.0 && testlist.get(2) == 3.0) {
		System.out.println("Basic list is in order");
		} else 
			fail("The list is wrong somwhere.");
		}
	

	@Test
	public void TestOrderListComplex() throws Exception {
	
		testlist = testStatComplex.OrderList();
		if (testlist.get(0) == 2.0 && testlist.get(1) == 3.5 && testlist.get(2) == 4.1 && testlist.get(3) == 5.2 && testlist.get(4) == 5.2 && testlist.get(5) == 6.0 && testlist.get(6) == 7.33 && testlist.get(7) == 9.1 && testlist.get(8) == 9.9 && testlist.get(9) == 10.0) {
		System.out.println("Even list test is in order");
		} else {
			fail("The list has changed somehow.");
		}
	
	}
	
	//===================================================================================
	
	/**
	 *  This series of tests check the MinGet Method
	 *  using all the stat objects
	 * 
	 */
	
	
	@Test
	public void TestMinGetZero() throws Exception {
		
		try {
			testStatZero.MinGet();
			fail("There should be no min ");
		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	public void TestMinGetOne() throws Exception {
	
		x = testStatOne.MinGet();
		
		assertEquals(5,x,1e-5);
		
	}
	
	@Test
	public void TestMinGetBasic() throws Exception {
		
		x = testStatBasic.MinGet();
		
		assertEquals(1,x,1e-5);
	}
	

	@Test
	public void TestMinGetComplex() throws Exception {
		
		x = testStatComplex.MinGet();
		
		assertEquals(2,x,1e-5);
		
	}
	
	//===================================================================================
	
		/**
		 *  This series of tests check the MaxGet Method
		 *  using all the stat objects
		 * 
		 */
		
		
		@Test
		public void TestMaxGetZero() throws Exception {
			
			try {
				testStatZero.MaxGet();
				fail("There should be no max ");
			} catch (Exception e) {
				
			}
			
		}
		
		@Test
		public void TestMaxGetOne() throws Exception {
			
			x = testStatOne.MaxGet();
			
			assertEquals(5,x,1e-5);
			
		}
		
		@Test
		public void TestMaxtBasic() throws Exception {
			
			x = testStatBasic.MaxGet();
			
			assertEquals(3,x,1e-5);
			
		}
		

		@Test
		public void TestMaxGetComplex() throws Exception {
			
			x = testStatComplex.MaxGet();
			
			assertEquals(10,x,1e-5);
			
		
			
			
		}
	
	//===========================================================
		/**
		 *  This series of tests check the MeanGet Method
		 *  using all but the even stat object
		 * 
		 */
		
			
		@Test
		public void TestMeanGetZero() throws Exception {
				
			if (testStatZero.MeanGet() >= 0 ) {
				fail("The mean shouldn't be anything");
			} else {
				System.out.println("The Zero test succeeded");
			}
			
		}
		
		
		@Test
		public void TestMeanGetOne() throws Exception {
			
			x = testStatOne.MeanGet();
			
			assertEquals(5,x,1e-5);
			
		
			
			
		}
		
		@Test
		public void TestMeanGetBasic() throws Exception {
			
			x = testStatBasic.MeanGet();
			
			assertEquals(2,x,1e-5);
			
		
			
			
		}
		
		@Test
		public void TestMeanGetComplex() throws Exception {
			
			x = testStatComplex.MeanGet();
			
			assertEquals(6.233,x,1e-5);
			
		
			
		}
		
	//======================================================================
		
		/**
		 *  This series of tests check the MeanGet Method
		 *  using all the stat objects
		 * 
		 */
		
		
		@Test
		public void TestMedianGetZero() throws Exception {
			
			try{
				testStatZero.MedianGet();
				fail("No elements to get a median from");
			} catch(Exception e) {
				System.out.println("Zero test list succeeded");
			}
		}
		
		@Test
		public void TestMedianGetOne() throws Exception {
			
			x = testStatOne.MedianGet();
			
			assertEquals(5.0,x,1e-5);
			
		}
		
		@Test
		public void TestMedianGetBasic() throws Exception {
			
			x = testStatBasic.MedianGet();
			
			assertEquals(2.0,x,1e-5);
			
		}
		
		
		@Test
		public void TestMedianGetEven() throws Exception {
			
			x = testStatEven.MedianGet();
			
			assertEquals(2.5,x,1e-5);
			
		}
		
		@Test
		public void TestMedianGetComplex() throws Exception {
			
			x = testStatComplex.MedianGet();
			
			assertEquals(5.6,x,1e-5);
			
		}
		
//======================================================================
		
		/** 
		 *  This series of tests checks the StandardDeviationGet method
		 *  using all but the even stat object
		 */
		
		
		@Test
		public void TestDeviationZero() throws Exception {
			
		if (testStatZero.DeviationGet() >= 0 && testStatZero.DeviationGet() <= 0) {
			fail("The Standard Deviation shouldn't be an integer unless it's a negative");
		} else {
			System.out.println("The test has succeeded since the Deviation with nothing can't be anything but zero/null");
		}
		
	}
		
		
		@Test
		public void TestDeviationOne() throws Exception {
			
			x = testStatOne.DeviationGet();
			
			assertEquals(0,x,1e-5);
		
	}
		
		@Test
		public void TestDeviationBasic() throws Exception {
		
			x = testStatBasic.DeviationGet();
			
			assertEquals(0.816496580927726,x,1e-5);
		}
			
		@Test
		public void TestDeviationComplex() throws Exception {
			
			x = testStatComplex.DeviationGet();
			
			assertEquals(2.6303233641512596,x,1e-5);
		
		}
//=========================================================
		
		/**
		 *  This series of tests check the FirstQuartileGet Method
		 *  using all but the even list stat objects
		 *  
		 */
		
		@Test
		public void TestFirstQuartileZero() {
			
			try {
				testStatZero.FirstQuartileGet();
				fail("Should have gotten a null pointer exception");
			} catch (Exception e) {
				System.out.println(" TestThirdQuartileZero succeeded");
			}
		}
		
		
		@Test
		public void TestFirstQuartileOne() throws Exception {
			
		try {
			testStatOne.FirstQuartileGet();
			fail("Should have gotten a null pointer exception");
		} catch (Exception e) {
			System.out.println(" TestFirstQuartileOne succeeded");
		}
		
	}
		
		@Test
		public void TestFirstQuartileEven() throws Exception {
			
			x = testStatEven.FirstQuartileGet();
			
			assertEquals(1.5,x,1e-5);
		
	}
		
		@Test
		public void TestFirstQuartileComplex() throws Exception {
			
			x = testStatComplex.FirstQuartileGet();
			
			assertEquals(4.0,x,1e-5);
		
	}
	
//===============================================================================		
		
		/**
		 *  This series of tests check the ThirdQuartileGet Method
		 *  using all but the even list stat objects
		 *  
		 */
		
		
		
		@Test
		public void TestThirdQuartileZero() {
			
			try {
				testStatZero.ThirdQuartileGet();
				fail("Should have gotten a null pointer exception");
			} catch (Exception e) {
				System.out.println(" TestThirdQuartileZero succeeded");
			}
		}
		
		
		@Test
		public void TestThirdQuartileOne() throws Exception {
			
		try {
			testStatOne.ThirdQuartileGet();
			fail("Should have gotten a null pointer exception");
		} catch (Exception e) {
			System.out.println(" TestThirdQuartileOne succeeded");
		}
		
	}
		
		@Test
		public void TestThirdQuartileEven() throws Exception {
			
		x = testStatEven.ThirdQuartileGet();
			
		assertEquals(3.5,x,1e-5);
		
	}
		
		@Test
		public void TestThirdQuartileComplex() throws Exception {
			
			x = testStatComplex.ThirdQuartileGet();
			
			assertEquals(8.466,x,1e-5);
		
		
		
	}
		
//=============================================================================
		/**
		 * The series of tests that makes sure
		 * the RangeGet Method checks with the
		 * stats objects
		 */
		
		
		@Test
		void TestRangeZero() throws Exception {
			
			try {
				testStatZero.RangeGet();
				fail("Should have crashed");
			} catch (Exception e) {
				
			}
			
		}
		
		@Test
		void TestRangeOne() throws Exception {
			x = testStatOne.RangeGet();
		
			assertEquals(0,x,1e-5);
		}
		
		@Test
		void TestRangeBasic() throws Exception {
			x = testStatBasic.RangeGet();
		
			assertEquals(2,x,1e-5);
		}
		
		@Test
		void TestRangeComplex() throws Exception {
			x = testStatComplex.RangeGet();
		
			assertEquals(8,x,1e-5);
		}
		
//========================================================
		/**
		 * The series of tests that makes sure
		 * the InterquartileRangeGet Method checks with the
		 * stats objects
		 */
		
		
		@Test
		void TestInterQuartileZero() throws Exception {
			
			try {
				testStatZero.InterquartileRangeGet();
				fail("Should have crashed");
			} catch (Exception e) {
				
			}
			
		}
		
		@Test
		void TestInterQuartileOne() throws Exception {
			try {
				testStatOne.InterquartileRangeGet();
				fail("Should have crashed");
			} catch (Exception e) {
				
			}
		
		}
		@Test
		void TestInterQuartileEven() throws Exception {
			x = testStatEven.InterquartileRangeGet();
		
			assertEquals(2,x,1e-5);
		}
		
		@Test
		void TestInterQuartileComplex() throws Exception {
			x = testStatComplex.InterquartileRangeGet();
		
			assertEquals(4.466,x,1e-5);
		}

//======================================================
		
		/**
		 * This test will check the AllStatsGet method
		 * 
		 * using the object results pulled from the other tests
		 */
		
		
		@Test
		void TestAllStatsGetOne(){
			
			testlist = testStatOne.AllStatsGet();
			
			if (testlist.get(0) == 5.0 && testlist.get(1) == 5.0 && testlist.get(2) == 5.0 && testlist.get(3) == 5.0 && testlist.get(4) ==  null && testlist.get(5) ==  null && testlist.get(6) == null && testlist.get(7) == 0 && testlist.get(8) ==  null) {
			System.out.println("The stat list with one element from the object is in order");
			} else {
				fail("The list has changed somehow.");
			}
			
			
		}
		
		
		@Test
		void TestAllStatsGetEven(){
			
			testlist = testStatEven.AllStatsGet();
			
			if (testlist.get(0) == 1.0 && testlist.get(1) == 4.0 && testlist.get(2) == 2.5 && testlist.get(3) == 2.5 && testlist.get(4) == 1.118033988749895 && testlist.get(5) ==  1.5 && testlist.get(6) == 3.5 && testlist.get(7) == 3 && testlist.get(8) == 2) {
			System.out.println("The stat list with a basic even element list from the object is in order");
			} else {
				fail("The list has changed somehow.");
			}
			
			
		}
		
		
		void TestAllStatsGetComplex(){
			
			testlist = testStatComplex.AllStatsGet();
			
			if (testlist.get(0) == 2.0 && testlist.get(1) == 10.0 && testlist.get(2) == 6.113 && testlist.get(3) == 5.6 && testlist.get(4) == 2.701133280680537  && testlist.get(5) ==  3.7600000000000002 && testlist.get(6) == 8.466 && testlist.get(7) == 8.0 && testlist.get(8) ==  4.7059999999999995) {
			System.out.println("The stat list with one element from the object is in order");
			} else {
				fail("The list has changed somehow.");
			}
			
			
		}
		
		
		
		
		
		
		
}
