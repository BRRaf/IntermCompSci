package lab01;
import java.util.ArrayList;

/**
 * 
 * This object will contain all of the methods that are used to 
 * calculate the statistics methods in a list including the 
 * minimum, the maximum, the mean, the median, 
 * the standard deviation, the first interquartile, the third
 * interquartile the range and the interquartile range.
 *
 * The methods themselves are largely borrowed from 00brafalski18-intro
 * with small changes to compensate a object and JUnit Test oriented program
 * 
 */

public class Stats {
	
	
	ArrayList<Double> numList;
	
	public Stats(ArrayList<Double> numList) {
		
		this.numList = numList;
		
	}
	
	
	
	
	
	
	public ArrayList<Double> OrderList() {
		/** 
		 * Reorders the list from smallest to largest 
		 * to be used in the First Quartile and the 
		 * Third Quartile
		 */
		
		System.out.println("The start of the Order List Method");
		
		double temp1 = 0; // Variable to hold the first value to compare to the list
		double temp2 = 0; // Variable to hold the compared value in the list
		
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
		
		System.out.println("End of OrderList");
		return numList;
	}
	
	
		
//====================================================	
	
public double MinGet() {
		
		/** 
		 * Sorts out the smallest number
		 */
		
		System.out.println("The start of the MinGet Method "); 
		
		
		double min = numList.get(0); // The variable that holds the smallest value of the list.
		
		for (int i = 0; i < numList.size(); i++ ) {
			
			if (numList.get(i) <= min) {
				
				min = numList.get(i);
				
			}
		}
		
		System.out.println("The end of the MinGet Method");
		return min;
		
	}

//=================================================================================
	
	

public double MaxGet() {
		
		/** 
		 * Sorts out the largest number 
		 */
		
		System.out.println("The start of MaxGet"); 
		
		double max = numList.get(0); // The variable that holds the largest value of the list.
		
		for (int i = 0; i < numList.size(); i++ ) {
			
			if (numList.get(i) >= max) {
				max = numList.get(i);
			}
			
		}
		
		System.out.println("The end of MaxGet");
		return max;
		
	}


//=====================================================================


public double MeanGet() {
	
	/** 
	 * Sorts out the average number and prints it
	 */
	
	System.out.println("The start of MeanGet"); 
	
	double sum = 0; // The variable that holds the sum value of the list. Which will be added first then divided later.
	
	for (int i = 0; i < numList.size(); i++ ) {
		
		sum += numList.get(i);
		
	}
	
	double mean = sum/numList.size(); // in case the final answer is a double instead of an int
	
	System.out.println("The end of MeanGet");
	return mean;
	
}



//============================================================

public double MedianGet() {
	
	/** 
	 * Orders the list from smallest to largest, then
	 * sorts out the median number and prints it, if the list size is odd then it just 
	 * takes the value at the halfway point. If the list size is even then it adds the
	 * two center values together and then takes its average
	 */
	
	System.out.println("Starting Median");
	
	double median = 0; // creating the median value here because you can't create variables in if/else statements
	
	ArrayList<Double> orderedNumList = OrderList(); //orders the list from smallest to largest
	
	if (numList.size()%2 == 0) {
		
		median = ((numList.get(numList.size()/2)) + (numList.get((numList.size()/2) - 1))) / 2.0; // in case the size of the list is odd and the median is in between values
		
		System.out.println("Median with an odd list size has been calculated");
		
	} else {
		
		median = numList.get(numList.size()/2); // the median value from the list.
		
		System.out.println("Median with an even list size has been calculated");
		
	}
	
	return median;
		
}
//============================================================================

public double DeviationGet() {
	
	/**
	 * "The Standard Deviation collects the square root of the
	 * variance which is the average of the squared differences from the mean"
	 * https://www.mathsisfun.com/data/standard-deviation.html
	 * 
	 * This method goes through that process one step at a time to find the Deviation
	 */
	
	System.out.println("The start of the DeviationGet method"); 
	
	double deviation;
		
	double mean = MeanGet();
	
	ArrayList<Double> variance = new ArrayList<Double>(); // A list to collect the variance of the numList
		
	for (int i = 0; i < numList.size(); i++) {
			
	variance.add((numList.get(i) - mean) * (numList.get(i) - mean) );
			
		}
		
	double varianceMean = 0; // creating a separate mean variable to calculate the variance mean;

	for (int i = 0; i < variance.size(); i++ ) {
			
		varianceMean += variance.get(i);
			
		}
		
	deviation = Math.sqrt(varianceMean/variance.size()); // the final equation to get the deviation
		
	System.out.println("The end of the Standard Deviation Method");
	return deviation;
		
		
	
}
	
//================================================================

public double FirstQuartileGet() {
	
	/**
	 * 
	 * First reorders the list from smallest to largest,
	 * Then calculates the median of the lower half of the list.
	 * 
	 */
	
	System.out.println("The start of FirstQuartileRangeGet");

	
	numList = OrderList();
	
	double q1 = 0; // The variable to hold the mean of the First Quartile
	

if (numList.size() >= 4) { 
	
	for (int i = 0; i < ((numList.size()/2)); i++ ) {
		
		q1 += numList.get(i);
		
	}
	
	q1 = q1/((numList.size()/2));

	System.out.println("The end of FirstQuartileRangeGet");

	return q1;
	
	}else {
		q1 = (Double) null;
		return q1;
	}

}


//=====================================================================

public double ThirdQuartileGet() {
	
	/**
	 * First reorders the list from smallest to largest
	 * Then calculates the median of the upper half of the list.
	 */
	
	System.out.println("The start of ThirdQuartileGet");
	
	numList = OrderList();
	
	double q3 = 0; // The variable to hold the mean of the Third Quartile
	
if (numList.size() >= 4) {
	
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
	
		System.out.println("The end of ThirdQuartileGet");
		
		return q3;
	
	} else {
		
		q3 = (Double) null;
		return q3;
	}
		
}


//======================================================================

	public double RangeGet() {
		
		/**
		 * The method to get the Range.
		 */
		
		System.out.println("The start of RangeGet");
		
		double max = MaxGet();
		
		double min = MinGet();
		
		double range = max - min; // the calculation to get the range
		
		System.out.println("The end of RangeGet");
		return range;
	}
	
//=============================================================================

	public double InterquartileRangeGet() {
		
		/**
		 * The method to calculate the Interquartile Range
		 * 
		 */
		
		System.out.println("The start of InterquartileRangeGet");
		
		double q1 = FirstQuartileGet(); // the variable to hold the first quartile
		
		double q3 = ThirdQuartileGet(); // the variable to hold the third quartile
		
		double iqr = q3 - q1; // the variable to hold the Interquartile Range
		
		System.out.println("The end of InterquartileRangeGet");
		return iqr;
	}
	

//========================================================================
	
	public ArrayList<Double> AllStatsGet() {
		
		/**
		 * This method grabs all the values in this object within a list to be sent
		 * to the results object.
		 * 
		 * The list will contain all numbers
		 * that are calculated from this object, 
		 * ordered by when they appear in the program (Min, Max, Mean, etc)
		 * 
		 * The list itself is an Array, rather than a integrated list in case there's any more 
		 * stat terms to add.
		 * 
		 * 
		 */
		
		ArrayList<Double> statlist = new ArrayList<Double>(); //
		
		statlist.add(MinGet());
		
		statlist.add(MaxGet());
		
		statlist.add(MeanGet());
		
		statlist.add(MedianGet());
		
		if (numList.size() > 1) {
		statlist.add(DeviationGet());
		}else {
			statlist.add((Double) null);
		}
		
		if (numList.size() > 3  ) {
		statlist.add(FirstQuartileGet());
		statlist.add(ThirdQuartileGet());
		}else {
			statlist.add((Double) null);
			statlist.add((Double) null);
		}
		
		
		statlist.add(RangeGet());
		
		
		if (numList.size() > 3) {
		statlist.add(InterquartileRangeGet());
		} else {
			statlist.add((Double) null);
		}
		
		
		return statlist;
	}
	
	
	
	
	
}
