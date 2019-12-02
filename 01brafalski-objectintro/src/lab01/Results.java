package lab01;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.PrintStream;

public class Results {

	/**
	 * An instance of this class will use the list 
	 * gathered by the Stats object to print out
	 * the results of all the statistical numbers
	 * onto the console
	 */
	
	
	private ArrayList<Double> numList;
	private String statStr;
	private double statNum;
	private String ALL_STR;
	
	private String ERROR;
	
	public Results(ArrayList<Double> numList) {
		
		this.numList = numList; //Setting the list to equal the list taken from the Stats object
	}
	
	public String getALLSTR() {
		ALL_STR = "The " + statStr + " from the list is: "; // putting the string in a method instead of the constructor so that it can be constantly updated with the new statsStr
		return ALL_STR;
	}
	
	public String getERROR() {
		ERROR = "The " + statStr + " could not be calculated due to the list containing three or less elements"; // a string used if the user inputs a list with three or less elements
		return ERROR;
	}
	
	public String getStatStr() {
		return statStr;
	}
	
	
	protected PrintStream out() {
		return System.out;
	}
	
	
	public void Min() {
		
		statStr = "Minimum number"; 
		double statNum = numList.get(0);
		out().println(getALLSTR() + statNum);
		
	}
	

	
	public void Max() {
		
		statStr = "Maximum number"; 
		double statNum = numList.get(1);
		out().println(getALLSTR() + statNum);
	}
	
	public void Mean() {
		
		statStr = "Mean"; 
		double statNum = numList.get(2);

		out().println(getALLSTR() + statNum);
	}
	
	public void Median() {
		
		statStr = "Median"; 
		double statNum = numList.get(3);
		out().println(getALLSTR() + statNum);
	}
	
	public void Deviation() {
		
		statStr = "Standard Deviation"; 
		
		try {
			double statNum = numList.get(4);
			out().println(getALLSTR() + statNum);
		}catch (Exception e) {
			out().println(getERROR());
		}
		
	}
	
	public void FirstQuartile() {
		
		statStr = "First Quartile";
		
		try {
			double statNum = numList.get(5);
			out().println(getALLSTR() + statNum);
		}catch (Exception e) {
				out().println(getERROR());
			}
		
		
	}
	
	public void ThirdQuartile() {
		
		statStr = "Third Quartile"; 
		
		try {
			double statNum = numList.get(6);
			out().println(getALLSTR() + statNum);
		}catch (Exception e) {
				out().println(getERROR());
			}
		
	}
	
	public void Range() {
		
		statStr = "Range"; 
		double statNum = numList.get(7);
		out().println(getALLSTR() + statNum);
	}
	
	public void InterQuartileRange() {
		
		statStr = "InterQuartile Range"; 
		
		try {
			double statNum = numList.get(8);
			out().println(getALLSTR() + statNum);
		}catch (Exception e) {
				out().println(getERROR());
			}
	}
	
	public void PrintAll() {
		/**
		 * A method that goes through the object and activates all the other methods
		 */
		out().println(" ");
		Min();
		out().println(" ");
		Max();
		out().println(" ");
		Mean();
		out().println(" ");
		Median();
		out().println(" ");
		Deviation();
		out().println(" ");
		FirstQuartile();
		out().println(" ");
		ThirdQuartile();
		out().println(" ");
		Range();
		out().println(" ");
		InterQuartileRange();
		
	}
	
}
