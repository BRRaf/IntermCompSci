package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpriteTest {

	
	/**
	 * testing the location of the ball when it hits the right side of the screen
	 * the velocity should swap between positive to negative and is located on the 
	 * correct side of the panel
	 * 
	 *
	 */
	
	@Test
	void testUpdateRightSide() {
		Sprite testball = new Sprite(0,500,500,0);
		
		
		testball.setX(485);
		testball.setDx(5.0);
		
		testball.update();
		
		
		//the next x value the ball should be at
		assertEquals(480.0,testball.getX());
		//the dx value should become a negative
		assertEquals(-5.0, testball.getDx());
	}
	
	
	/**
	 * testing the location of the ball when it hits the left side of the screen
	 * the velocity should swap between negative and positive and is located on the 
	 * correct side of the panel
	 */
	
	@Test
	void testUpdateLeftSide() {
		Sprite testball = new Sprite(0,500,500,0);
		
		
		testball.setX(0.0);
		testball.setDx(-5.0);
		
		testball.update();
		
		//the next x value the ball should be at
		assertEquals(20.0,testball.getX());
		//the dx value should become a positive
		assertEquals(5.0, testball.getDx());
	}
	
	/**
	 * testing the location of the ball when it hits the top of the screen
	 * the velocity should swap between negative and positive and is located on the 
	 * correct side of the panel
	 */
	
	@Test
	void testUpdateTopSide() {
		Sprite testball = new Sprite(0,500,500,0);
		
		
		testball.setY(0);
		testball.setDy(-5.0);
		
		testball.update();
		
		//the next x value the ball should be at
		assertEquals(20.0,testball.getY());
		//the dx value should become a positive
		assertEquals(5.0, testball.getDy());
	}

}
