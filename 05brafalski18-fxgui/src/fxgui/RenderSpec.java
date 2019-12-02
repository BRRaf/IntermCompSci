package fxgui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * 
 * This class will store all the information that will be used in the center
 * pane from the MainViewPane 
 *
 */
public class RenderSpec {
	
	Font f;
	String text;
	Color c;
	boolean outlineRectangle;
	boolean outlineOval;
	
	//setting a default font and color in case nothing is changed and the null is not a factor
	public RenderSpec() {
	setFont(f.font("Dialog", FontWeight.NORMAL, FontPosture.REGULAR, 8));
	setColor(c.rgb(0, 0, 0));
	}
	
	public Font getFont() {
		return f;
	}
	public void setFont(Font font) {
		this.f = font;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Color getColor() {
		return c;
	}
	public void setColor(Color color) {
		this.c = color;
	}
	public boolean isOutlineRectangle() {
		return outlineRectangle;
	}
	public void setOutlineRectangle(boolean outlineRectangle) {
		this.outlineRectangle = outlineRectangle;
	}
	public boolean isOutlineOval() {
		return outlineOval;
	}
	public void setOutlineOval(boolean outlineOval) {
		this.outlineOval = outlineOval;
	}
	
}
