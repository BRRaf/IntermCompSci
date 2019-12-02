package breakout;

import java.awt.*;
import java.util.Random;

public class Sprite {

	private double x;
	private double y;
	
	private double dx;
	private double dy;
	
	
	private Color myColor;
	
	private int minx,maxx,miny,maxy;
	
	private final double RADIUS;
	
	
	/**
	 * An instance of this object will create a circle that will be used in the game 
	 * class
	 * 
	 * the sprite object will update the position of the ball and send that 
	 * information to the game class
	 * 
	 * @param leftx
	 * @param rightx
	 * @param bottomy
	 * @param topy
	 */
	public Sprite(int leftx, int rightx, int bottomy, int topy) {
		
		//setting the left and top region where the ball can move to
		minx = leftx;
		miny = topy;
		
		maxx = rightx;
		maxy = bottomy;
		
		//setting initial position to be in the center of the frame
		x = maxx/2;
		y = maxy/2;
		//setting velocity to equal zero
		dx = 0.0;
		dy = 0.0;
		
		RADIUS = 20.0;
		
		
		
		myColor = Color.BLUE;
		
	}

	public double getRADIUS() {
		return RADIUS;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}

	
	/*
	 * 
	 * using the Graphics object to create the Sprite
	 * 
	 */
	
	public void drawOn(Graphics g) {
		
		g.setColor(myColor);
		g.fillOval((int)x-(int)RADIUS, (int)y-(int)RADIUS,(int)RADIUS, (int)RADIUS);
		
	}
	
	/*
	 *  changing the x and y variables by the dx and dy variables
	 *  
	 *  if x is greater or smaller than the minx and maxx it will correct the 
	 *  position to reverse
	 */
	
	public void update() {
		double extra;
		
		x += dx;
		y += dy;
		
		if(x + RADIUS > maxx) {
			x = maxx - RADIUS;
			dx = dx * -1;
		}
		
		if(x - RADIUS <= 0.0) {
			x = 0.0 + RADIUS;
			dx = dx * -1;
		}
		
		if(y - RADIUS <= 0.0) {
			y = 0.0 + RADIUS;
			dy = dy * -1;
		}
	
		
	}
	
	
	/*
	 * sets the ball to the default position and a default y position when it goes 
	 * below the paddle 
	 */
	public void setDefault() {
		//setting initial position to be in the center of the frame
		x = maxx/2;
		y = maxy/2;
		dy = 5;
		
		int randx;
		Random rand = new Random();
		
		do {
		randx = rand.nextInt(11) - 5;
		}while(randx == 0);
		
		dx = randx;
		
		
	}
	
	/*
	 * This method will change the dx and dy by the same amount every time the ball hits 
	 * the paddle, the amount that dx and dy will be changed by will increase every time 
	 * the ball hits the paddle
	 */
	public void accelerate() {
		
		// dy will always be negative after the ball hits the paddle
		dy += dy*.10;
		
		dx += dx*.10;
		
		
		
	}
	
	
	
}
