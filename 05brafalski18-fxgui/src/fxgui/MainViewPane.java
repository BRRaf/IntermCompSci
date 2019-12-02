package fxgui;
import javafx.scene.Scene;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;




import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class MainViewPane extends BorderPane {
	
	
	
	/**
	 * setting up the main pane with all the other pane classes
	 * within their respective area
	 * 
	 * The action event code was borrowed from 
	 * https://code.makery.ch/blog/javafx-8-event-handling-examples/
	 */
	
	private Controller c;
	private RenderSpec rs;
	private paneCenter pc;
	
	public MainViewPane() {
	c = new Controller();	
	rs = new RenderSpec();
		
	this.setBottom(new paneBottom());
	this.setTop(new paneTop());
	this.setLeft(new paneLeft());
	//making the center pane to be a class variable so that it can be accessed by other classes, such as the ok button
	pc = new paneCenter();
	this.setCenter(pc);
	}
	
	/**
	 * 
	 * This class will set up the Bottom Pane which will
	 * include two buttons
	 * 
	 * the Quit button will end the program when pressed
	 * and the Ok button will activate the center panes repaint
	 * method
	 *
	 */
	private class paneBottom extends FlowPane {
		
		public paneBottom() {
			this.setId("paneBottom");
			
			//the ok button which will repaint the center pane
			Button btOk = new Button("Ok");
			btOk.setId("btOk");
			//creating the okhandler
			OkHandler okh = new OkHandler();
			btOk.setOnAction(okh);
			
			//the quit button which will end the program
			Button btQuit = new Button("Quit");
			btQuit.setId("btQuit");
			//creating the quithandler
			QuitHandler qh = new QuitHandler();
			btQuit.setOnAction(qh);
				
			
			
			this.getChildren().addAll(btOk,btQuit);
		}
		
		/**
		 *  telling the center panel to use the repaint method when the ok button is pressed
		 *
		 */
		private class OkHandler implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent e) {
				pc.repaint();
			}
		}
		
		
		/**
		 * 
		 * telling the program to end when the quit button is pressed
		 *
		 */
		private class QuitHandler implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);;
			}
		}
		
		
	}
	
	/**
	 * 
	 * Creates the objects located in the top pane
	 * which are three combo boxes that 
	 * include the font, font style, and size of the font
	 *
	 */
	private class paneTop extends FlowPane{
		
		private ComboBox boxFont;
		private ComboBox boxStyle;
		private ComboBox boxSize;
		
		public paneTop() {
			this.setId("paneTop");
			
			//creating the three string lists which will be used with the matching comboboxes.
			String[] Fontname = {"Dialog","Comic Sans MS", "Harrington", "Times New Roman"};
			String[] Stylelist = {"Regular","Italics","Bold"};
			String[] Sizelist = {"8pt","12pt","16pt","24pt"};
			
			//setting up the combo box for the font names with a matching label
			Label lblFontList = new Label("Font:");
			lblFontList.setId("lblFontList");
			ObservableList<String> fontlist =
					FXCollections.observableArrayList(Fontname);
			boxFont = new ComboBox(fontlist);
			boxFont.setId("boxFont");
			boxFont.getSelectionModel().selectFirst();
			
			//setting up the Fontname handler
			FontNameHandler fnh = new FontNameHandler();
			boxFont.setOnAction(fnh);
			
			//setting up the combo box for the style list with a matching label
			Label lblStyleList = new Label("Style:");
			lblStyleList.setId("lblStyleList");
			ObservableList<String> stylelist =
					FXCollections.observableArrayList(Stylelist);	
			boxStyle = new ComboBox(stylelist);
			boxStyle.setId("boxStyle");		
			boxStyle.getSelectionModel().selectFirst();
			
			//setting up the font style handler
			FontStyleHandler styleh = new FontStyleHandler();
			boxStyle.setOnAction(styleh);
			
			
			
			//setting up the combo box for the size list with a matching label
			Label lblSizeList = new Label("Size:");
			lblSizeList.setId("lblSizeList");
			ObservableList<String> sizelist =
					FXCollections.observableArrayList(Sizelist);			
			boxSize = new ComboBox(sizelist);
			boxSize.setId("boxSize");
			boxSize.getSelectionModel().selectFirst();
			
			//setting up the size handler 
			FontSizeHandler sizeh = new FontSizeHandler();
			boxSize.setOnAction(sizeh);
			
			
		
		
			this.getChildren().addAll(lblFontList,boxFont,lblStyleList,boxStyle,lblSizeList,boxSize);
		}
		
		/**
		 * 
		 * This class will set the font name in the Controller
		 *
		 */
		private class FontNameHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				c.setfontName(boxFont.getValue().toString());
				
			}
		}
		
		/**
		 * 
		 * This class will set the font style in the controller
		 * return a FontWeight if it's bold, 
		 * return a FontPosture if it's anything else
		 *
		 */
		private class FontStyleHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				if(boxStyle.getValue().toString() == "Bold") {
					c.setfontStyle(FontPosture.REGULAR);
					c.setfontStyleBold(FontWeight.BOLD);
				}else {
					if(boxStyle.getValue().toString() == "Regular") {
						c.setfontStyleBold(FontWeight.NORMAL);
						c.setfontStyle(FontPosture.REGULAR);
					} else if(boxStyle.getValue().toString() == "Italics") {
						c.setfontStyleBold(FontWeight.NORMAL);
						c.setfontStyle(FontPosture.ITALIC);
					
					}	
				}
			}
		}
		
		
		/**
		 * 
		 * this class will set the font size in the Controller
		 *
		 */
		private class FontSizeHandler implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent event) {
				c.setSize(boxSize.getValue().toString());
				
			}
		}
	}
	
	
	
	/**
	 * Creates the left pane with all the panes inside it, including the pane
	 * with the text field, the pane with the sliders, and the pane with the radio/check buttons
	 */
	
	private class paneLeft extends BorderPane{
		public paneLeft() {
			
			this.setId("paneLeft");
			
			this.setPrefWidth(200);
			
			this.setTop(new paneTopLeft());
			this.setCenter(new paneCenterLeft());
			this.setBottom(new paneBottomLeft());
			
		}
		
		
		
		private class paneTopLeft extends FlowPane{
			
			private TextField text;
			
			public paneTopLeft() {
				
				//setting up the textfield with a matching label
				Label lblText = new Label("Text: ");
				lblText.setId("lblText");
				text = new TextField();
				text.setId("text");
				
				//setting up the Textfield handler
				TextHandler th = new TextHandler();
				text.setOnKeyReleased(th);
				
				this.getChildren().addAll(lblText,text);
			}
			
			/**
			 * 
			 * This class will set the text in the Controller
			 *
			 */
			private class TextHandler implements EventHandler<InputEvent>{
				@Override
				public void handle(InputEvent event) {
					c.setText(text.getText());
					
				}

				
			}
		}
		
		
		/**
		 * 
		 * This pane will set up all three color sliders with
		 * respective labels in the center of the left main pane
		 *
		 */
		private class paneCenterLeft extends GridPane{
			
			private Slider sldrRed;
			private Slider sldrGreen;
			private Slider sldrBlue;
			
			
			public paneCenterLeft() {
				this.setId("paneCenterLeft");
				//creating a single color handler as all three sliders will perform the same task
				ColorHandler ch = new ColorHandler();
				
				//setting up red slider
				Label lblRed = new Label("Red:   ");
				lblRed.setId("lblRed");
				sldrRed = new Slider();
				sldrRed.setId("sldrRed");
				sldrRed.setMin(0);
				sldrRed.setMax(255);
				sldrRed.setOnMouseReleased(ch);
				//setting up a pane to connect the red label and slider
				FlowPane paneRed = new FlowPane();
				paneRed.setId("paneRed");
				paneRed.getChildren().addAll(lblRed,sldrRed);
				
				this.add(paneRed,1,1);
				
				
				//setting up green slider
				Label lblGreen = new Label("Green:");
				lblGreen.setId("lblGreen");
				sldrGreen = new Slider();
				sldrGreen.setId("sldrGreen");
				sldrGreen.setMin(0);
				sldrGreen.setMax(255);
				sldrGreen.setOnMouseReleased(ch);
				//setting up a pane to connect the green label and slider
				FlowPane paneGreen = new FlowPane();
				paneGreen.setId("paneGreen");
				paneGreen.getChildren().addAll(lblGreen,sldrGreen);
				
				this.add(paneGreen,1,2);
				
				//setting up blue slider
				Label lblBlue = new Label("Blue:  ");
				lblBlue.setId("lblBlue");
				sldrBlue = new Slider();
				sldrBlue.setId("sldrBlue");
				sldrBlue.setMin(0);
				sldrBlue.setMax(255);
				sldrBlue.setOnMouseReleased(ch);
				//setting up a pane to connect the blue label and slider
				FlowPane paneBlue = new FlowPane();
				paneBlue.setId("paneBlue");
				paneBlue.getChildren().addAll(lblBlue,sldrBlue);
				
				this.add(paneBlue,1,3);
				
			}
			
			/**
			 * 
			 * grabbing the values from all three sliders and returning a color to the Controller
			 *
			 */
			private class ColorHandler implements EventHandler<MouseEvent> {

				@Override
				public void handle(MouseEvent event) {
					c.setColor((int)sldrRed.getValue(), (int)sldrGreen.getValue(),(int)sldrBlue.getValue());
				}
				
			}

		}	
		
		
		/**
		 * 
		 * This class will set up Radio buttons and 
		 * a checkbox in the bottom of the left main pane
		 *
		 */
		private class paneBottomLeft extends GridPane{
			
			private RadioButton rec;
			private RadioButton oval;
			private CheckBox outline;
			
			public paneBottomLeft() {
				
				//creating the rectangle radio button
				rec = new RadioButton("Rectangle");
				rec.setDisable(true);
				rec.setId("rec");
				
				//setting up the rectangle handler
				RectangleButtonHandler rbh = new RectangleButtonHandler();
				rec.setOnAction(rbh);
				
				this.add(rec, 2, 2);
				
				//creating the oval radio button
				oval = new RadioButton("Oval");
				oval.setDisable(true);
				oval.setId("oval");
				
				//setting up the oval handler
				OvalButtonHandler ovalbh = new OvalButtonHandler();
				oval.setOnAction(ovalbh);
				this.add(oval, 1,2);
				
				
				//creating the outline checkbox
				outline = new CheckBox("Outline");
				outline.setId("outline");
				
				//setting up the outline handler
				OutlineButtonHandler outlinebh = new OutlineButtonHandler();
				outline.setOnAction(outlinebh);
				this.add(outline, 1, 1);
				
			}
			
			
			/**
			 * 
			 * The outline checkbox when clicked will either enable the 
			 * two radiobuttons if checked
			 * or disable the two radio buttons and
			 * turn them off
			 *
			 */
			private class OutlineButtonHandler implements EventHandler<ActionEvent>{

				@Override
				public void handle(ActionEvent event) {
					
					if(outline.isSelected() == true) {
						rec.setDisable(false);
						oval.setDisable(false);
					} else if(outline.isSelected() == false) {
						rec.setSelected(false);
						rec.setDisable(true);
						c.setIsRecTrue(false);
						oval.setSelected(false);
						oval.setDisable(true);
						c.setIsOvalTrue(false);
					}
					
				}
				
			}
			
			
			/**
			 * 
			 * The Rectangle RadioButton will turn off the oval button if clicked
			 * and return true to the controller
			 *
			 */
			private class RectangleButtonHandler implements EventHandler<ActionEvent>{

				@Override
				public void handle(ActionEvent event) {
					
					if(rec.isSelected() == true) {
						oval.setSelected(false);
						c.setIsOvalTrue(false);
						c.setIsRecTrue(true);
					} else if(rec.isSelected() == false) {	
						c.setIsRecTrue(false);
					}
				}	
			}
			
			/**
			 * 
			 * The Oval RadioButton will turn off the Rectangle Button if clicked
			 * and return true to the controller
			 *
			 */
			private class OvalButtonHandler implements EventHandler<ActionEvent>{

				@Override
				public void handle(ActionEvent event) {
					
					if(oval.isSelected() == true) {
						rec.setSelected(false);
						c.setIsRecTrue(false);
						c.setIsOvalTrue(true);
					} else if(oval.isSelected() == false) {	
						c.setIsOvalTrue(false);
					}
				}	
			}
			
			
			
			
		}
	}
	
	
	/**
	 * 
	 * setting up the center pane in the main pane
	 * which includes the canvas
	 * 
	 * and include a repaint method
	 *
	 */
	private class paneCenter extends StackPane{
		
		private Text text;
		
		public paneCenter() {
			
			this.setId("paneCenter");
			
		}
		
		/*
		 * This method will recreate the text using renderspec data
		 * and if the rectangle or oval buttons are pressed
		 * create the appropriate border around the text
		 */
		private void repaint() {
			
			this.getChildren().clear();
			
			//creating the visible text
			text = new Text(rs.getText());
		
			text.setFont(rs.getFont());
			text.setFill(rs.getColor());
			
			if(rs.isOutlineRectangle() == true) {
				
				Rectangle rec = new Rectangle(text.getX(),text.getY(),text.getLayoutBounds().getWidth() + 5,text.getFont().getSize() + 10);
				rec.setStroke(Color.BLACK);
				rec.setFill(Color.color(0, 0, 0, 0));
				this.getChildren().add(rec);
			} else if(rs.isOutlineOval() == true) {
				
				Ellipse oval = new Ellipse(text.getX(),text.getY(),text.getLayoutBounds().getWidth(), text.getFont().getSize());
				oval.setStroke(Color.BLACK);
				oval.setFill(Color.color(0, 0, 0, 0));
				this.getChildren().add(oval);
			}
			
			
			this.getChildren().add(text);
			
			
		}
	}
	
	/**
	 * 
	 * This class will organize the data that is sent to it and send it to the
	 * Renderspec
	 *
	 */
	
	private class Controller{
		
		private Font f;
		private String fontName;
		private FontPosture style1;
		private FontWeight style2;
		private int size;
		
		private Color c; 
		
		public Controller(){
		}
		
		private void setText(String text) {
			rs.setText(text);
		}
		
		/*
		 * converting the size string to an int
		 * so it can be read by the Font object
		 */
		private void setSize(String inputsize) {
			String strsize = inputsize;
			
			if(strsize == "8pt") {
				size = 8;
			}else if(strsize == "12pt") {
				size = 12;
			}else if(strsize == "16pt") {
				size = 16;
			}else if(strsize == "24pt") {
				size = 24;
			}	
			
			setFont();
		}
		
		private void setfontName(String fontName) {
			this.fontName = fontName;
			setFont();
		}
		
		private void setfontStyle(FontPosture style) {
			style1 = style;
			setFont();
		}
		
		private void setfontStyleBold(FontWeight style) {
			style2 = style;
			setFont();
		}
		
		private void setFont() {
			
			rs.setFont(Font.font(fontName, style2, style1, size));
		}
		
		private void setColor(int red, int green, int blue) {
			rs.setColor(Color.rgb(red, green, blue));
		}
		
		private void setIsRecTrue(Boolean rec) {
			rs.setOutlineRectangle(rec);
		}
		
		private void setIsOvalTrue(Boolean oval) {
			rs.setOutlineOval(oval);
		}
	}
	
	
	
	
	
}


