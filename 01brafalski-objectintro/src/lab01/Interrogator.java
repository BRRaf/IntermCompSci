package lab01;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  An instance of this class will be used to read the users inputs
 *  and store them within an ArrayList variable
 *  
 *  That variable, completed when the user types a negative number, will be sent to the Stats object
 *  in order for the calculations to be made from the list.
 *  
 * 
 * 
 *
 */


public class Interrogator {
	
	protected ArrayList<Double> numList = new ArrayList<Double>();
	
	public final static String INTERROGATOR_STR = "Please enter a positive number to be added to the list, When you are finished, enter a negative number!";
	
	public final static String WRONG_STR = "You can't have a list with zero elements, Please try again. ";
	
	double input;
	
	public Interrogator() {
		//No config required
	}
	
	public void Start() {
		/**\
		 *Outputs the prompt so that it doesn't repeat whenever the user puts in a number
		 * Then continues with 
		 */
		
		out().println(INTERROGATOR_STR);
	}
	
	protected PrintStream out() {
		/**
		 * Borrowed from Prompt.java
		 * 
		 * Designed to return a handle on PrintStream for test use
		 */
		return System.out;
	}
	
	protected InputStream in() {
		/**
		 * Borrowed from Prompt.java
		 * 
		 * Designed to return a handle on InputStream for test use
		 */
		return System.in;
	}
	
	public Double Grab_Nums_From_User() {
		/**
		 * The main method to grab the number from the user
		 * and checks to make sure it is negative
		 * 
		 */
		
		while (input != -1.0) {
		
		Scanner s = new Scanner(in());
		
		input = s.nextDouble();
		
		if (input >= 0) {
			Add_to_List(input);
		} else {
			if (CheckList() == false) {
				out().println(WRONG_STR);
				Grab_Nums_From_User();
			}else {
			return -1.0;
			}
		}
		
		}
		
		return -1.0;
		
	}
	
	public Boolean CheckList() {
		/**
		 * Makes sure that the list doesn't have zero elements
		 */
		
		if (numList.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void Add_to_List(Double num) {
		/**
		 * Adds a double to the ArrayList after it has been read
		 */
		numList.add(num);
	}
	
	
	
	public ArrayList<Double> GetNumList(){
		
	/**
	 * To be used at end of Interrogator so the list can be sent to the Stats object.
	 */
		return numList;
	}
	
	
	
	
	
	
	
	
}
