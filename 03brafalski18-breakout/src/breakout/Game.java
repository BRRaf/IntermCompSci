package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Rectangle;

/**
 * 
 * an instance of this class will manage the game state and it's collaborating
 * objects, while returning the state to the mainframe
 *
 */
public class Game {

	private Rectangle paddle;
	private Rectangle checktangle;
	private int padx;
	
	private final int PADY;
	private final int PADWIDTH;
	private final int PADHEIGHT;
	
	private Sprite ball;
	
	private ArrayList<Rectangle> Bricks;
	private final int TOTAL_BRICKS;
	
	private int brickx;
	private double bricky;
	private final int BRICKW;
	private final int BRICKH;
	
	private ArrayList<Color> BrickColor;
	
	private int lives;
	private int score;
	
	Random r;
	
	private int red;
	private int green; 
	private int blue;
	
	Color randcolor;
	
	public Game() {
		
		//setting up the random variable for the brick colors
		r = new Random();
		
		//the structure of the paddle with its position based on the frame height
		PADWIDTH = 50;
		PADHEIGHT = 15;
		PADY = MainFrame.FRAME_HEIGHT - 200;
		
		padx = 0;
		
		//the paddle will be controlled by the user and used to 
		//hit the ball back up the screen
		paddle = new Rectangle(padx, PADY, PADWIDTH, PADHEIGHT);
		
		//creation of a new sprite representing the ball, its location based on the frame size
		ball = new Sprite(0,MainFrame.FRAME_WIDTH,MainFrame.FRAME_HEIGHT,0);
		
		//the amount of bricks that will be on the screen
		TOTAL_BRICKS = 20;
		
		//An array that will hold the bricks, location represented by the frame
		Bricks = new ArrayList<Rectangle>();
		BRICKW = 40;
		BRICKH = 20;
		brickx = 20;
		bricky = MainFrame.FRAME_HEIGHT - MainFrame.FRAME_HEIGHT*0.875;
		
		//a list in parallel with Bricks to set an individual bricks color
		BrickColor = new ArrayList<Color>();
		
		//if the total bricks is less than or equal to 0 then the win screen will
		//automatically appear
		if (TOTAL_BRICKS > 0) {
			
			// setting up the random rgb values for the brick
			red = r.nextInt(254) + 1;
			green =  r.nextInt(254) + 1;
			blue = r.nextInt(254) + 1;
			
			randcolor = new Color(red,green,blue);
			
			BrickColor.add(randcolor);
			
			Bricks.add(new Rectangle(brickx, (int)bricky, BRICKW, BRICKH));
			for (int i = 1; i <= TOTAL_BRICKS; i++) {
				brickx += 50;
				//adding a new row of bricks when the bricks no longer fit the frame
				if(brickx + BRICKW >= MainFrame.FRAME_WIDTH) {
					brickx = 20;
					bricky += 40;
				}
				
				red = r.nextInt(254) + 1;
				green =  r.nextInt(254) + 1;
				blue = r.nextInt(254) + 1;
				
				randcolor = new Color(red,green,blue);
				
				BrickColor.add(randcolor);
				
				Bricks.add(new Rectangle(brickx, (int)bricky, BRICKW, BRICKH));
				
			}
			
		}
		
		
		//the score will keep track of how many bricks the user hits
		score = 0;
		//lives keeps track of how many balls the user has till they lose
		lives = 0;
		
	}
	
	/*this method sets the x value of the paddle and
	 * creating a new rectangle to replace it
	 */
	public void setPaddle(int x) {
		padx = x;
		paddle = new Rectangle (padx, PADY, PADWIDTH, PADHEIGHT);
	}
	
	public Rectangle getPaddle() {
		return paddle;
	}
	
	/*
	 * Moves the paddle to the specific x,y position to stop
	 * the paddle from going over the frame
	 */
	public void moveTo(int x) {
		if(x <= 0) {
			setPaddle(0);
		}else if(x >= MainFrame.FRAME_WIDTH - PADWIDTH) {
			setPaddle(MainFrame.FRAME_WIDTH- PADWIDTH);
		}else {
		setPaddle(x);
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public void setLives(int l) {
		lives = l;
	}
	
	/*
	 * waits till specific moments are met then
	 * reports back to MainFrame
	 * 
	 */
	public boolean isGameOver() {
		if(lives == 0) {
			return true;
		}
		
		for (int i = 0; i < TOTAL_BRICKS; i++) {
			if(Bricks.get(i) != null) {
				return false;
			}
		}
	
		return true;
	}
	
	/*
	 * repositions the ball to its initial position with
	 * a random velocity in the downward direction
	 */
	public void reset() {
		
		ball.setDefault();
	
		
		
	
		
	}
	
	/*
	 * This method creates a new rectangle that is the 
	 * same size and position as the ball. Then checks
	 * are done that determine whether the ball has hit 
	 * the wall or hit one of the bricks
	 */
	public void moveBall() {
		ball.update();
		//a non visible rectangle that is located in the same place and is the same size
		checktangle = new Rectangle((int)ball.getX() - (int)ball.getRADIUS(), (int)ball.getY()-(int)ball.getRADIUS(),(int)ball.getRADIUS(),(int)ball.getRADIUS());
		Rectangle temp;
		
		if(paddle.intersects(checktangle)) {
			ball.setY(PADY);
			ball.setDy(ball.getDy() * -1);
			ball.accelerate();
			
		}
		
		for(int i = 0; i < TOTAL_BRICKS; i++) {
			//a temporary brick that grabs its variables
			temp = Bricks.get(i);
			if(temp != null) {
				if(temp.intersects(checktangle)) {
					Bricks.set(i, null);
					score += 10;
					ball.setDy(ball.getDy()*-1);
				}
			}
		}
		
		// the extra number gives the user visual wiggle room to see it pass
		if(ball.getY() >= PADY + PADHEIGHT + 50) {
			lives -= 1;
			ball.setDefault();
		}
		
	}
	
	/*
	 * renders all the bricks, paddle and ball, 
	 */
	public void drawOn(Graphics g) {
		
		Rectangle temp;
		
		g.fillRect(padx, PADY, PADWIDTH, PADHEIGHT);
		
		ball.drawOn(g);
		
		for(int i = 0; i < TOTAL_BRICKS; i++) {
			temp = Bricks.get(i);
			if(temp != null) {
			g.setColor(Color.GRAY);
			g.fillRect((int)temp.getX()-1,(int)temp.getY()-1,(int)temp.getWidth()+2,(int)temp.getHeight()+2);
			g.setColor(BrickColor.get(i));	
			g.fillRect((int)temp.getX(),(int)temp.getY(),(int)temp.getWidth(),(int)temp.getHeight());
			
			}
		}
		
		
	}
	
	
	
}
