package gui;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 
 * An instance of this class will create all the
 * panels to be used within this panel and also
 * create all objects to be used in the panel
 *
 */

public class MainViewPanel extends JPanel {
	
	private pnlTop top;
	private pnlBottom bot;
	private pnlLeft left;
	private pnlCenter center;
	
	private JComboBox fontBox;
	private JComboBox styleBox;
	private JComboBox sizeBox;
	
	private JTextField input;
	
	private JSlider redSlider;
	private JSlider greenSlider;
	private JSlider blueSlider;
	
	private JCheckBox outline;
	
	private JRadioButton rec;
	private JRadioButton oval;
	
	private Controller c;
	
	private RenderSpec rs;
	public MainViewPanel() {
		super();
		this.setLayout(new BorderLayout());
		
		//adding the top panel to the north side of the main panel
		top = new pnlTop();
		this.add(top, BorderLayout.NORTH);
		
		//adding the bottom panel to the south side of the main panel
		bot = new pnlBottom();
		this.add(bot, BorderLayout.SOUTH);
		
		//adding the left panel and all the panels inside it to the west side of the main panel
		left = new pnlLeft();
		this.add(left, BorderLayout.WEST);
		
		//adding the center panel and its canvas to the center of the main panel
		center = new pnlCenter();
		this.add(center, BorderLayout.CENTER);
		
		//an extra panel just to give the canvas a clear stopping point
		JPanel blank = new JPanel();
		this.add(blank,BorderLayout.EAST);
		
		//creating the controller to send data to the renderspec
		c = new Controller();
		
		//the renderspec which will store and use the data that is sent to it
		rs = new RenderSpec(800, 500);
	}
	
	
	/**
	 * 
	 * An instance of this class will create the 
	 * combo boxes and labels that are attached to it
	 *
	 */
	private class pnlTop extends JPanel {
		
		public pnlTop() {
			super();
			this.setLayout(new FlowLayout());
			
			//creating the three string lists which will be used with the matching comboboxes.
			//They arn't JLists due to them not being compatable with comboboxes for some reason
			String[] Fontlist = {"Dialog","Comic Sans MS", "Harrington", "Times New Roman"};
			String[] Stylelist = {"regular","italic","bold"};
			String[] Sizelist = {"8pt","12pt","16pt","24pt"};
			
			//creating the font family combobox and matching label
			JLabel Fontlbl = new JLabel("Font:");
			add(Fontlbl);
			fontBox = new JComboBox(Fontlist);
			add(fontBox);
			fontBox.addActionListener(new FontListener());
			
			//creating the style combobox and matching label
			JLabel Stylelbl = new JLabel(" Style:");
			add(Stylelbl);
			styleBox = new JComboBox(Stylelist);
			add(styleBox);
			styleBox.addActionListener(new StyleListener());
			
			//creating the size combobox and matching label
			JLabel Sizelbl = new JLabel (" Size:");
			add(Sizelbl);
			sizeBox = new JComboBox(Sizelist);
			add(sizeBox);
			sizeBox.addActionListener(new SizeListener());
			
		}
		
		
	}
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	private class FontListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		//	System.out.println(fontBox.getSelectedItem());
			c.Callback();
			
		}
	}
	
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	
	private class StyleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		//	System.out.println(styleBox.getSelectedItem());
			c.Callback();
		}
	}
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	
	private class SizeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		//	System.out.println(sizeBox.getSelectedItem());
			c.Callback();
			
		}
	}
	
	
	
	
	/**
	 * 
	 * An instance of this class will create the 
	 * "Ok" and "Quit" buttons that go on the bottom
	 * of the frame
	 *
	 */
	private class pnlBottom extends JPanel {
		
		
		public pnlBottom() {
			super();
			this.setLayout(new FlowLayout());
			
			/*
			 * setting up the Button listeners
			 */
			ButtonHelperOk bhok = new ButtonHelperOk();
			ButtonHelperQuit bhq = new ButtonHelperQuit();
			
			//button will send all the information 
			JButton Ok = new JButton("Ok");
			add(Ok);
			Ok.addActionListener(bhok);
			
			//button will close window and end the game early
			JButton Quit = new JButton("Quit");
			add(Quit);
			Quit.addActionListener(bhq);
			
			
		}
	}
	
	/**
	 * 
	 * an instance of this class will force activate
	 * the center panel's repaint method in order
	 * to update the center panel
	 *
	 *
	 */
	private class ButtonHelperOk implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent f) {
			c.Callback();
			center.repaint();
		}
	}
	
	/**
	 * An instance of this class will end the program when activated
	 */
	private class ButtonHelperQuit implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	
	/**
	 * An instance of this class will create the left main panel 
	 * in a border style and create every panel inside it
	 */
	
	private class pnlLeft extends JPanel{
		
		public pnlLeft() {
			super();
			this.setLayout(new BorderLayout());
			
			//adding the text box panel to the north side of the left panel
			pnlLeftNorth pnlln = new pnlLeftNorth();
			add(pnlln, BorderLayout.NORTH);
			
			//adding the sliders to the center of the left panel
			pnlLeftCenter pnllc = new pnlLeftCenter();
			add(pnllc, BorderLayout.CENTER);
			
			//adding the checkbox and radio buttons to the bottom of the left panel
			pnlLeftBottom pnllb = new pnlLeftBottom();
			add(pnllb, BorderLayout.SOUTH);
			
		}
	}
	
	/**
	 * 
	 * an instance of this class will include the text box with matching 
	 * label
	 *
	 */
	private class pnlLeftNorth extends JPanel{
		
		public pnlLeftNorth() {
			super();
			
			JLabel textlbl = new JLabel("Text: ");
			add(textlbl);
			
			input = new JTextField(15);
			add(input);
			input.addActionListener(new TextListener());
			
			
		}
	}
	
	/**
	 * 
	 * This listener will only activate if the user presses enter 
	 * while typing in the text box. In order to avoid the user
	 * forgetting to press enter, the OkButtonListener has a controller
	 * callback method to update everything before the center panel paints
	 *
	 */
	private class TextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		//	System.out.println(input.getText());
			c.Callback();
		}
		
	}
	
	
	/**
	 * 
	 * an instance of this class will create
	 * the color sliders that will be put in the center panel of the 
	 * left side of the frame
	 *
	 */
	private class pnlLeftCenter extends JPanel{
		
		public pnlLeftCenter() {
			super();
			
			//setting up required border
			Border myBorder = BorderFactory.createTitledBorder("color");
			setBorder(myBorder);
			
			//using a grid layout so that the sliders are evenly spaced
			setLayout(new GridLayout(3,1));
			
			//setting up a red panel to hold the red label and matching slider
			JPanel redpnl = new JPanel();
			
			JLabel redlbl = new JLabel("red");
			redpnl.add(redlbl);
			
			redSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
			redSlider.setMajorTickSpacing(51);
			redSlider.setPaintTicks(true);
			redpnl.add(redSlider);
			redSlider.addChangeListener(new RedListener());
			
			this.add(redpnl);
			
			//setting up a green panel to hold the green label and matching slider
			JPanel greenpnl = new JPanel();
			
			JLabel greenlbl = new JLabel("green");
			greenpnl.add(greenlbl);
			
			greenSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
			greenSlider.setMajorTickSpacing(51);
			greenSlider.setPaintTicks(true);
			greenpnl.add(greenSlider);
			greenSlider.addChangeListener(new GreenListener());
			
			this.add(greenpnl);
			
			
			//setting up a blue panel to hold the blue label and matching slider
			JPanel bluepnl = new JPanel();
			
			JLabel bluelbl = new JLabel("blue");
			bluepnl.add(bluelbl);
			
			blueSlider = new JSlider(JSlider.HORIZONTAL,0,255,0);
			blueSlider.setMajorTickSpacing(51);
			blueSlider.setPaintTicks(true);
			bluepnl.add(blueSlider);
			blueSlider.addChangeListener(new BlueListener());
			
			this.add(bluepnl);
			
		}
	}
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	private class RedListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		//	System.out.println(redSlider.getValue());
			c.Callback();
		}
		
	}
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	private class GreenListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		//	System.out.println(greenSlider.getValue());
			c.Callback();
		}
		
	}
	
	/**
	 * 
	 * an instance of this class will 
	 * activate the controller callback method and
	 * update the data
	 */
	private class BlueListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		//	System.out.println(blueSlider.getValue());
			c.Callback();
		}
		
	}
	
	/**
	 * 
	 * An instance of this class will create the radio and
	 * checkbox buttons which will be added to the bottom left corner of the main Panel
	 *
	 */
	private class pnlLeftBottom extends JPanel{
		public pnlLeftBottom() {
			super();
			
			//using a grid layout so that the buttons are evenly spaced
			setLayout(new GridLayout(1,2));
			
			outline = new JCheckBox("Outline");
			add(outline);
			outline.addActionListener(new OutlineListener());
			
			pnlButtons pnlb = new pnlButtons();
			add(pnlb);
			
			
		}
		
		/**
		 * 
		 * Creating an extra class inside the pnlLeftBottom
		 * class in order to group the radio buttons
		 * together
		 *
		 */
		private class pnlButtons extends JPanel{
			public pnlButtons() {
			super();
			//using the grid layout so that the buttons are evenly spaced together
			setLayout(new GridLayout(2,1));
			
			
			rec = new JRadioButton("Rectangle");
			rec.setEnabled(false);
			add(rec);
			rec.addActionListener(new RectangleListener());
			
			oval = new JRadioButton("Oval");
			oval.setEnabled(false);
			add(oval);
			oval.addActionListener(new OvalListener());
			
			
		}
	}
	
}
	
	/**
	 * 
	 * An instance of this class will disable the rectangle and oval buttons
	 * if not selected and enable them if it is
	 * 
	 * and then call the controllers Callback method
	 *
	 */
	private class OutlineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(outline.isSelected() == false) {
				rec.setEnabled(false);
				rec.setSelected(false);
				oval.setEnabled(false);
				oval.setSelected(false);
			}else if(outline.isSelected() == true) {
				rec.setEnabled(true);
				oval.setEnabled(true);
			}
			c.Callback();
		}
		
	}
	
	/**
	 * An instance of this class will set the rectangle button to true and the oval
	 * to false if it had been selected
	 * 
	 * and then call the controllers Callback method
	 */
	
	private class RectangleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rec.isSelected() == true && oval.isSelected() == true) {
				oval.setSelected(false);
				
			}
			c.Callback();
		}
	}
	
	
	/**
	 * An instance of this class will set the oval button to true and the rectangle
	 * to false if it had been selected
	 * 
	 * and then call the controller Callback method
	 */
	
	private class OvalListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(oval.isSelected() == true && rec.isSelected() == true) {
				rec.setSelected(false);
				
			}
			c.Callback();
			
		}
		
	}
	
	
	/**
	 * 
	 * an instance of this class will add the canvas to the 
	 * center of the main panel
	 * 
	 */
	private class pnlCenter extends JPanel{
		
		public pnlCenter() {
			super();
			//adding required border
			Border myBorder = BorderFactory.createLoweredBevelBorder();
			setBorder(myBorder);
			Color background = new Color(255,248,220);
			
			//basing the panel on a canvas so that it's easier to draw
			Canvas c = new Canvas();
			setBackground(background);
		
						
		}
		
		/*
		 * passing the code along to the 
		 * RenderSpec paint method so that
		 * it can create the text
		 * 
		 */
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			rs.paint(g);
		}
		
	}
	
	
	/**
	 * 
	 * An instance of this class will go through all the widgets and take their current
	 * information, converting them if they arn't in the correct format
	 *
	 */
	private class Controller{
		public Controller() {	
		}
		
		public void Callback() {
			
			//grabing the current comboboxes selected items
			String fonttype = (String)fontBox.getSelectedItem();
			String style = (String)styleBox.getSelectedItem();
			String strsize = (String)sizeBox.getSelectedItem();
			
			//setting the default size to the smallest option
			int intsize = 8;
			//converting the size item into an int due to Fontsize only being compatible with ints
			if(strsize == "8pt") {
				intsize = 8;
			}else if(strsize == "12pt") {
				intsize = 12;
			}else if(strsize == "16pt") {
				intsize = 16;
			}else if(strsize == "24pt") {
				intsize = 24;
			}
			
			rs.setSize(intsize);
			
			//converting the style item into a Font.STYLE due to the style argument only being compatible with Font.STYLE objects
			//the font which is sent to Renderspec is also created here, since at this point it has all the info it needs to send
			//it over
			Font font;
			if(styleBox.getSelectedItem() == "regular") {
				font = new Font(fonttype,Font.PLAIN,intsize);
			}else if(styleBox.getSelectedItem() == "italic") {
				font = new Font(fonttype,Font.ITALIC,intsize);
			}else if(styleBox.getSelectedItem() == "bold") {
				font = new Font(fonttype,Font.BOLD,intsize);
			} else {
				font = new Font(fonttype,Font.PLAIN,intsize);
			}
			
			rs.setFont(font);
			
			//taking the textbox info and sending it to Renderspec
			String text = input.getText();
			rs.setText(text);
			
			//grabbing the slider values, converting it into a color so that the Renderspec doesn't have to 
			int red = redSlider.getValue();
			int blue = blueSlider.getValue();
			int green = greenSlider.getValue();
			
			Color color = new Color(red,green,blue);
			
			rs.setColor(color);
			
			//converting the button selections into ints so that it's easier to process
			//in Renderspec
			int isShape = 0;
			
			if(rec.isSelected() == true) {
				isShape = 1;
			}else if(oval.isSelected() == true) {
				isShape = 2;
			}else {
				isShape = 0;
			}
			
			rs.setIsShape(isShape);

		}
	}
	
	
	
	
}




