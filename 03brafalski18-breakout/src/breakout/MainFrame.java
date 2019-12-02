package breakout;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 * 
 * An instance of this JFrame will create the presentation layer
 * and allow the game object to perform it's actions. 
 *
 */

public class MainFrame extends JFrame {
	
	// this height and width of the frame
	public static final int FRAME_HEIGHT = 600;
	public static final int FRAME_WIDTH = 550;
	

	
	private Game theGame;
	private GamePanel gp;
	
	private BtnPanel bp;
	
	private LabelPanel lp;
	
	
	private Timer t;
	
	private boolean gamestart;
	
	public MainFrame() {
		super("Breakout");
		
		this.setLayout(new BorderLayout());
		
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		
		//setting up the timer to run 15 frames a second
		t = new Timer(1000/15, new TimerHelper());
	
		
		
		//creation of a new Game object
		theGame = new Game();
		
		//creating a new JPanel that is located on the bottom frame and will include buttons
		bp = new BtnPanel();		
		this.getContentPane().add(bp, BorderLayout.SOUTH);
		
		
		//creating a new JPanel that is located at the top of the frame to include game information		
		lp = new LabelPanel();
		this.getContentPane().add(lp, BorderLayout.NORTH);
		
		
		
		//creating the Gamepanel that will go in the center of the frame
		gp = new GamePanel();
		this.getContentPane().add(gp, BorderLayout.CENTER);
		
		//setting the gamestart to be false until the start button is pressed
		gamestart = false;
		
	}
	
	
	/**
	 * An instance of this class will create the 
	 * game panel used in the center which will give the Game
	 * object responsibilities and repaint the panel
	 *
	 *
	 */
	private class GamePanel extends JPanel {
		
		public GamePanel() {
			//setting up mouse helper to listen for mouse commands
			MouseHelper mh = new MouseHelper();
			addMouseMotionListener(mh);
			
		}
		
		
		/*
		 * this method will paint the background and call the game object to paint
		 * its items. When the game is over it will set up a game over screen
		 * depending on whether the user wins or loses
		 */
		public void paint(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.red);
			theGame.drawOn(g);
			
			if (theGame.isGameOver() == true && gamestart == true) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				
				g.setColor(Color.RED);
				//creating a large font so the user can see the game over text
				Font f = new Font("Dialog", Font.PLAIN, 50);
				
				g.setFont(f);
				if(theGame.getLives() == 0) {
					g.drawString("Game Over: You Lost!", 20, 100);
				}else {
					g.drawString("Game Over: You Win!", 20, 100);
				}
			}
			
		}
	
		

	}
	
	
	/**
	 * 
	 * an instance of this class will create the button panel
	 * on the south of the frame
	 *
	 */
private class BtnPanel extends JPanel {
	
	public BtnPanel() {
		
		//setting up the start and quit button listeners so that specific actions
		//will happen when they are activated
		ButtonHelperStart bhs = new ButtonHelperStart();
		ButtonHelperQuit bhq = new ButtonHelperQuit();
		
		//button will start the game so the player has time to get ready and view the game before hand
		JButton Start = new JButton("Start");
		add(Start);
		Start.addActionListener(bhs);
		
		
		//button will close the window and end the game early
		JButton Quit = new JButton("Quit");
		add(Quit);
		Quit.addActionListener(bhq);
	}
}
	
	/**
	 * 
	 * An instance of this class will begin the game in it's natural state, 
	 * 
	 * will not work if the game is already running
	 *
	 */
	public class ButtonHelperStart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			t.start();
			if(gamestart == false) {
				gamestart = true;
				theGame.setLives(3);
				theGame.reset();
				
			}
			
		}
		
	}
	
	
	/**
	 *An instance of this class will
	 *end the program when pressed
	 *
	 */
	public class ButtonHelperQuit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	
	
	
	/**
	 * An instance of this class will take the mouse
	 * movements and send them to Game moveTo method
	 * 
	 *
	 */
	
	public class MouseHelper implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			theGame.moveTo(e.getX());
		}	
	}
	
	
	/**
	 * This custom panel will have access to the Game object
	 * 
	 * it will use the score and lives variables and update it to the panel
	 */
	
	private class LabelPanel extends JPanel{
		private JLabel scorelbl;
		private JLabel liveslbl;
		public LabelPanel() {
			
			scorelbl = new JLabel();
			liveslbl = new JLabel();
			
			scorelbl.setText("Score:" + theGame.getScore());
			liveslbl.setText("Lives:" + theGame.getLives());
			
			add(liveslbl);
			add(scorelbl);
		}
		
		public void updatelbls() {
			scorelbl.setText("Score:" + theGame.getScore());
			liveslbl.setText("Lives:" + theGame.getLives());
		}
			
	}
	
	
	
	
	/**
	 * 
	 * An instance of this timer implements actionlistener and 
	 * keeps track of the timer
	 *
	 */
	public class TimerHelper implements ActionListener {	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			theGame.moveBall();
			lp.updatelbls();
			repaint();
			if (theGame.isGameOver() == true) {
				t.stop();
				
			}
		}	
	}
	
	
	public static void main(String[] args) {
		

		MainFrame mf = new MainFrame();
		
		mf.setVisible(true);
		
		
		
	}

}
