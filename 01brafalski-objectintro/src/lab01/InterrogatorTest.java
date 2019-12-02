package lab01;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class InterrogatorTest {

	
	
	@Test
	void Test_Grab_Nums_From_User_Fail() {
		
		ArrayList<Double> test = new ArrayList<Double>();
		
		test.add(5.0);
		test.add(5.0);
		test.add(5.0);
		
		String fakeUserResponseNum = "-9.3";
		
		Interrogator i = new Interrogator() {
			
			
			
			protected InputStream in() {
				return new ByteArrayInputStream( fakeUserResponseNum.getBytes());
			}
			
		};
		
		i.Add_to_List(5.0);
		
		double x = i.Grab_Nums_From_User();
		
		
		
		Assertions.assertEquals(-1.0 , x );
		
		
	}
				
	

}
