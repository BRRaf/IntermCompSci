
import java.util.ArrayList;
import java.util.Scanner;


public class Numberlist {
	
	/** 
	 * 	
	 *  An instance of this class allows the user to input any number of positive integers into a list
	 *  which then calculates several statistic terms from the list and outputs them to the user.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
	
	/**
	 * Variable creation
	 * 
	 */
		
		ArrayList<Integer> numList = new ArrayList<Integer>(); // An ArrayList is created so that the list can accommodate for any number of inputs
		
		int input = 0; // The variable that the user inputs into.
		
		Scanner scan = new Scanner(System.in); // Setting up the Scanner for input.
		
	//------------------------------
	
	/** 
	 * The start of the program which asks the user to input positive integers which gets put into the numList until they put
	 * in negative integers; which afterwards then goes through different methods to print the statistical terms. 
	 */
		
		System.out.println("Please enter a positive number to be added to a list.");
		System.out.println("To exit inputing integers, enter a negative integer.");
		
		
		do {
			
			input = scan.nextInt();
			
			if (input >= 0) {
				
				numList.add(input);
				
			}
			
			
		}while (input >= 0);
		
	//------------------------------
		
		System.out.println("The inputed list is: ");
		ListGet(numList);
		
		int min = MinGet(numList); // setting the minimum value for the Range
		
		int max = MaxGet(numList); // setting the maximum value for the Range
		
		double mean = MeanGet(numList); // setting the mean for the standard deviation
		
		MedianGet(numList);
		
		DeviationGet(numList, mean);
		
		double q1 = FirstQuartile(numList); // setting the Q1 for the Interquartile Range
		
		double q3 = ThirdQuartile(numList); // setting the Q3 for the Interquartile Range
		
		RangeGet(max,min);
		
		InterquartileRangeGet(q1,q3);
		
		
	}
	
	//--------------------------------------
	
	public static ArrayList<Integer> OrderList(ArrayList<Integer> numList) {
		/** 
		 * Reorders the list from smallest to largest 
		 * to be used in the First Quartile and the 
		 * Third Quartile
		 */
		
		int temp1 = 0; // Variable to hold the first value to compare to the list
		int temp2 = 0; // Variable to hold the compared value in the list
		
		for (int i = 0; i < numList.size(); i++) {
			
			for (int j = i; j < numList.size(); j++) {
				
				temp1 = numList.get(i);
				
				temp2 = numList.get(j);
				
				if (temp2 <= temp1) {
					
					numList.set(i, temp2);
					
					numList.set(j, temp1);
					
				}
			}
		}
		
		return numList;
	}
	
	
	
	
	
	public static ArrayList<Integer> ListGet(ArrayList<Integer> numList) {
		/**
		 *  Prints out the order of the inputed list in the order that the 
		 *  user inputed them in.
		 */
		
		for (int i = 0; i < numList.size(); i++ ) {
			
			System.out.print(numList.get(i) + " ");
			
		}
		
		return numList;
	}
	
	
	
	
	public static int MinGet(ArrayList<Integer> numList) {
		
		/** 
		 * Sorts out the smallest number and prints it
		 */
		
		System.out.println(" "); 
		System.out.println(" ");
		
		int min = numList.get(0); // The variable that holds the smallest value of the list.
		
		for (int i = 0; i < numList.size(); i++ ) {
			
			if (numList.get(i) <= min) {
				
				min = numList.get(i);
				
			}
		}
		
		System.out.println("The smallest number in the list is " + min);
		return min;
		
	}
	
	
	
	
	
public static int MaxGet(ArrayList<Integer> numList) {
		
		/** 
		 * Sorts out the largest number and prints it
		 */
		
		System.out.println(" "); 
		
		int max = numList.get(0); // The variable that holds the largest value of the list.
		
		for (int i = 0; i < numList.size(); i++ ) {
			
			if (numList.get(i) >= max) {
				max = numList.get(i);
			}
			
		}
		
		System.out.println("The largest number in the list is " + max);
		return max;
		
	}





public static double MeanGet(ArrayList<Integer> numList) {
	
	/** 
	 * Sorts out the average number and prints it
	 */
	
	System.out.println(" "); 
	
	int mean = 0; // The variable that holds the mean value of the list. Which will be added first then divided.
	
	for (int i = 0; i < numList.size(); i++ ) {
		
		mean += numList.get(i);
		
	}
	
	double doubleMean = (double)mean/(double)numList.size(); // in case the final answer is a double instead of an int
	
	System.out.println("The mean number from the list is " + doubleMean);
	return doubleMean;
	
}





public static void MedianGet(ArrayList<Integer> numList) {
	
	/** 
	 * Sorts out the median number and prints it, if the list size is odd then it just 
	 * takes the value at the halfway point. If the list size is even then it adds the
	 * two center values together and then takes its average
	 */
	
	System.out.println(" "); 
	
	
	
	if (numList.size()%2 == 0) {
		
		double doubleMedian = ((numList.get(numList.size()/2)) + (numList.get((numList.size()/2) - 1))) / 2.0; // in case the size of the list is odd and the median is in between values
		
		System.out.println("The median number from the list is " + doubleMedian);
		
	} else {
		
		int median = numList.get(numList.size()/2); // the median value from the list.
		
		System.out.println("The median number from the list is " + median);
		
	}
	
	
	
	
}

public static void DeviationGet(ArrayList<Integer> numList, double mean) {
	
	/**
	 * "The Standard Deviation collects the square root of the
	 * variance which is the average of the squared differences from the mean"
	 * https://www.mathsisfun.com/data/standard-deviation.html
	 * 
	 * This method goes through that process one step at a time to find the Deviation
	 */
	
	System.out.println(" "); 
	
	ArrayList<Double> variance = new ArrayList<Double>(); // A list to collect the variance of the numList
	
	for (int i = 0; i < numList.size(); i++) {
		
		variance.add((numList.get(i) - mean) * (numList.get(i) - mean) );
		
	}
	
	double varianceMean = 0; // creating a separate mean variable to calculate the variance mean;

	for (int i = 0; i < variance.size(); i++ ) {
		
		varianceMean += variance.get(i);
		
	}
	
	double deviation = Math.sqrt(varianceMean/variance.size()); // the final equation to get the deviation
	
	System.out.println("The Standard Deviation of the list is " + deviation);
	
}
	

public static double FirstQuartile(ArrayList<Integer> numList) {
	
	/**
	 * 
	 * First reorders the list from smallest to largest,
	 * Then calculates the median of the lower half of the list.
	 * 
	 */
	
	numList = OrderList(numList);
	
	double q1 = 0; // The variable to hold the mean of the First Quartile
	
	System.out.println(" ");
		
		for (int i = 0; i < ((numList.size()/2)); i++ ) {
			
			q1 += numList.get(i);
			
		}
		
		q1 = q1/((numList.size()/2));
	
		System.out.println("The First Quartile value is " + q1);

		return q1;
	
}

public static double ThirdQuartile(ArrayList<Integer> numList) {
	
	/**
	 * First reorders the list from smalles to largest
	 * Then calculates the median of the upper half of the list.
	 */
	
	numList = OrderList(numList);
	
	double q3 = 0; // The variable to hold the mean of the Third Quartile
	
	System.out.println(" ");
	
	if (numList.size()%2 == 0) {
		
		for (int i = numList.size()/2; i < numList.size(); i++ ) {
			
			q3 += numList.get(i);
			
		}
		
		q3 = q3/((numList.size()/2));
		
	} else {
		
		for (int i = numList.size()/2 + 1; i < numList.size(); i++ ) {
			
			q3 += numList.get(i);
			
		}
		
		q3 = q3/((numList.size()/2));
		
	}
	
		System.out.println("The Third Quartile value is " + q3);
		
		return q3;
		
}




	public static void RangeGet(int max, int min) {
		
		/**
		 * The method to get the Range.
		 */
		
		System.out.println(" ");
		
		int range = max - min; // the calculation to get the range
		
		System.out.println("The Range of the list is " + range);
		
	}
	

	public static void InterquartileRangeGet(double q1, double q3) {
		
		/**
		 * The method to calculate the Interquartile Range
		 */
		
		System.out.println(" ");
		
		double iqr = q3 - q1; // the variable to hold the Interquartile Range
		
		System.out.println("The Interquartile Range is " + iqr);
		
	}


}
