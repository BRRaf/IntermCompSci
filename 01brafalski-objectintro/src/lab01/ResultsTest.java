package lab01;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class ResultsTest {
	
	public static ArrayList<Double> testlist;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		testlist = new ArrayList<Double>();
		
		testlist.add(5.0);
		
	}	

	@Test
	void TestAllSTR() {
	
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Results r = new Results(testlist) {
			protected PrintStream out() {
				return new PrintStream(baos);
			}
		};
		
		String expectedOutput = "The " + r.getStatStr() +" from the list is: ";
		
		r.getALLSTR();
		
		
		
		Assertions.assertEquals(expectedOutput, r.getALLSTR() );
		
	}

	@Test
	void TestMin() {
		
		/**
		 * Because Results.Min() uses the same
		 * set of code the other methods use, then by
		 * testing this method all the other methods
		 * are tested through redundancy
		 */
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Results r = new Results(testlist) {
			protected PrintStream out() {
				return new PrintStream(baos);
			}
		};
		
		r.Min();
		
		String expectedOutput = "The " + r.getStatStr() +" from the list is: 5.0";
		
		Assertions.assertEquals(expectedOutput, baos.toString());
	}
	
	@Test
	void TestDeviationERROR() {
		
		/**
		 * Because Results.Deviation() uses the same
		 * set of code the other methods use, then by
		 * testing this method all the other methods that contain the ERROR message
		 * are tested through redundancy
		 */
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Results r = new Results(testlist) {
			protected PrintStream out() {
				return new PrintStream(baos);
			}
		};
		
		r.Deviation();
		
		String expectedOutput = "The Standard Deviation could not be calculated due to the list containing three or less elements"; 
		System.out.println(" ");
		
		Assertions.assertEquals(expectedOutput, baos.toString());
	}
	
}
