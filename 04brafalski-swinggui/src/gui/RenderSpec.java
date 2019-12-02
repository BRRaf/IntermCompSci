package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * An instance of this class will use all the data
 * gathered in the MainViewPanel and use it
 * to draw specific text and a shape depending on
 * certain conditions
 *
 */
public class RenderSpec {

	private Color color;
	
	private String text;
	
	private Font font;
	
	private final int PANELWIDTH;
	private final int PANELHEIGHT;
	
	private int isShape;
	
	private int size;
	
	/*
	 * setting up defaults in the constructor so that it doesn't produce an error when created
	 */
	public RenderSpec(int width, int height) {
		PANELWIDTH = width;
		PANELHEIGHT = height;
		
		color = new Color(0,0,0);
		
		size = 0;
		
		text = "";
		
		font = new Font(null, Font.PLAIN, 0);
		
		isShape = 0;
		
		
	}
	
	/*
	 * This method will paint the text using the set font and color,
	 * if the buttons were selected it will also draw one of the following
	 * shapes around the text
	 */
	public void paint(Graphics g) {
	
		g.setColor(color);
		g.setFont(font);
		
		int textwidth = g.getFontMetrics().stringWidth(text);
		int textheight = g.getFontMetrics().getHeight();
		
		//guesstimating where the center of the panel is
		int height = PANELHEIGHT/2 - 100 - textheight/2;
		int width = PANELWIDTH/4 - textwidth/2;
		
		g.drawString(text, width, height);
		
		//calculating where the left top corner of the circle is based off the relative center of the text
		int ovalx = width;
		int ovaly = height - textheight;
		
		g.setColor(Color.BLACK);
		if(isShape == 1) {
			g.drawRect(width - size, height - size, textwidth + size*2, textheight);
			
		}else if(isShape == 2) {
			g.drawOval(ovalx - size, ovaly, textwidth + size*2, textheight + size);
			
		}
		
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getIsShape() {
		return isShape;
	}

	public void setIsShape(int isShape) {
		this.isShape = isShape;
	}
	
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
