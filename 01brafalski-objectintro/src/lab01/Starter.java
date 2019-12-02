package lab01;

import java.util.ArrayList;
/**
 * 
 * This class is the starter class intended to run the other objects
 * when the program is run.
 *
 */


public class Starter {

	public static void main(String[] args) {

	Interrogator i = new Interrogator();
	
	i.Start();
	i.Grab_Nums_From_User();
	
	Stats s = new Stats(i.GetNumList());
	
	Results r = new Results(s.AllStatsGet());
	
	r.PrintAll();

		
		
	}
	
}
