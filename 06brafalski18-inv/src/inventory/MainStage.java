package inventory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * 
 * Creates the new stage that will be launched in the program
 *
 */

public class MainStage extends Application {
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			PokemonInventoryPane pip = new PokemonInventoryPane();
			
			Scene s = new Scene(pip,900, 580);
			s.getStylesheets().add(getClass().getResource("rules.css").toExternalForm());
			primaryStage.setTitle("Pokedex Inventory");
			primaryStage.setScene(s);
			primaryStage.show();
			
			
		

		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		launch(args);

	}
	
}
