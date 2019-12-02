package gui;

import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * 
 * An instance of this class will create the frame and start the program
 *
 */
public class MainFrame extends JFrame {
	
	private MainViewPanel p;
	private final int WIDTH;
	private final int HEIGHT;
	
	public MainFrame() {
		super("Options");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		WIDTH = 800;
		HEIGHT = 400;
		
		this.setSize(new Dimension(WIDTH,HEIGHT));
		
		p = new MainViewPanel();
		
		this.getContentPane().add(p);
		
		
	}
	

	public static void main(String[] args) {
	
		MainFrame f = new MainFrame();
		
		f.setVisible(true);
	}

}
