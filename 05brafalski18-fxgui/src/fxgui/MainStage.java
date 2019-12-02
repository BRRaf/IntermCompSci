package fxgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * This program copies the function of lab 04 but utilize javafx instead of swing
 * 
 * the function is to have the program paint user inputed text with user inputed options such as
 * font, text color and an outline
 *
 */
public class MainStage extends Application {

	RenderSpec rs = new RenderSpec();
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MainViewPane pane = new MainViewPane();
		
		Scene scene = new Scene(pane, 700, 250);
		scene.getStylesheets().add(getClass().getResource("rules.css").toExternalForm());
		primaryStage.setTitle("Options");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
