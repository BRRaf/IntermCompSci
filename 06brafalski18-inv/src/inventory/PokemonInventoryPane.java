package inventory;


import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;


/**
 * 
 * This class will contain all the important visual
 * panes and widgets using the different view models
 *
 */

public class PokemonInventoryPane extends BorderPane {

	
	PokemonViewModel pvm;
	InventoryViewModel ivm;
	ListView<Pokemon> listview;
	
	public PokemonInventoryPane() {
		pvm = new PokemonViewModel();
		ivm = new InventoryViewModel();
		this.setId("PokemonInventoryPane");
		
//		Pokemon p = new Pokemon(001, "Bulbasaur", "Seed", 0.7, 6.9, 5.9, "Grass", "Poison", 87.5, true, 1, "1.png");
		
//		pvm.setPokemon(p);
		
		this.setCenter(new paneInfo());
		this.setLeft(new paneList());
		this.setBottom(new paneBottomInfo());
	}
	
	/**
	 * 
	 * a main view pane that shows all the information from the list 
	 *
	 */
	
	private class paneInfo extends FlowPane {
		
		public paneInfo() {
			this.setId("paneInfo");	
			
			
			this.getChildren().add(new paneImage());
			
			GridPane gp = new GridPane();
			gp.setId("paneInfogp");
			
			gp.add(new paneId(), 2, 1);
			gp.add(new paneName(), 2, 2);
			gp.add(new paneCategory(), 2, 3);
			gp.add(new paneType(), 2, 4);
			gp.add(new paneSize(), 2, 5);
			gp.add(new panePercent(), 2, 6);
			gp.add(new paneCaught(), 2, 7);
			gp.add(new paneButtons(), 2, 8);
			this.getChildren().add(gp);
		}
		
		
		/**
		 * 
		 * This pane will show the image
		 *
		 */
		private class paneImage extends StackPane {
			
			public paneImage() {
				this.setId("paneImage");
				ImageView iv = new ImageView();
			
				iv.setFitWidth(100);
				iv.setFitHeight(100);
				
				iv.imageProperty().bind(pvm.getImageProperty());
				this.getChildren().add(iv);
				
			}
			
		}
		
		/**
		 * 
		 * This pane will show the ID variable
		 *
		 */
		private class paneId extends FlowPane {
			
			public paneId() {
				this.setId("paneId");
				//creating the ID labels and binding the specific value
				Label lblId = new Label("Pokedex ID: ");
				lblId.setId("lblId");
				Label Id = new Label();
				Id.setId("Id");
				Id.textProperty().bind(pvm.getIdProperty().asString());	
				
				this.getChildren().addAll(lblId, Id);
				
				
			}
		}
		
		/**
		 * 
		 * This pane will show the Name variable
		 *
		 */
		private class paneName extends FlowPane {
			
			public paneName() {
				this.setId("paneName");
				//creating a new name label
				Label lblName = new Label("Name: ");
				lblName.setId("lblName");
				//creating a changable textfield that is bound to the view model property
				TextField Name = new TextField();
				Name.setId("Name");
				Name.textProperty().bindBidirectional(pvm.getNameProperty());
				
				this.getChildren().addAll(lblName,Name);
				
			}
		}
		
		/**
		 * 
		 * This pane will show the category variable
		 *
		 */
		private class paneCategory extends FlowPane {
			
			public paneCategory() {
				this.setId("paneCategory");
				
				//creating category label
				Label lblCategory = new Label("Category: The");
				lblCategory.setId("lblCategory");
				//creating a changeable textfield that is bound to the view model property
				TextField Category = new TextField();
				Category.setId("Category");
				Category.textProperty().bindBidirectional(pvm.getCategoryProperty());
				
				Label lblPokemon = new Label("Pokemon");
				
				this.getChildren().addAll(lblCategory,Category,lblPokemon);
				
			}
		}
		
		
		/**
		 * 
		 * This pane will show the two type variables that will be seen in
		 * Comboboxes. 
		 * 
		 * This pane will also show a radio button that will disable and 
		 * enable the second combobox
		 *
		 */
		private class paneType extends GridPane {
			
			private ComboBox boxType2;
			private RadioButton btnIsType2;
			
			paneType() {
				this.setId("paneType");
				//creating the type list which will be used by both comboboxes
				String[] Types = {"Normal","Grass","Fire","Water","Electric","Flying","Fighting","Bug", "Rock", "Ground","Ghost","Dark","Poison","Psychic","Steel","Ice","Fairy","Dragon"};
				ObservableList<String> Typelist = 
						FXCollections.observableArrayList(Types);
				
				// creating the first combobox with matching label
				Label lblType1 = new Label("Main Type: ");		
				lblType1.setId("lblType1");
				ComboBox boxType1 = new ComboBox(Typelist);
				boxType1.setId("boxType1");
				boxType1.valueProperty().bindBidirectional(pvm.getType1Property());
				
				//creating the second combobox with matching label
				Label lblType2 = new Label("  Secondary Type: ");
				lblType2.setId("lblType2");
				boxType2 = new ComboBox(Typelist);
				boxType2.setId("boxType2");
				boxType2.valueProperty().bindBidirectional(pvm.getType2Property());
				lblType2.disableProperty().bind(pvm.getIstype2Property().not());
				boxType2.disableProperty().bind(pvm.getIstype2Property().not());
				
				//creating the radio button with listener
				btnIsType2 = new RadioButton("Second Type?");
				btnIsType2.setId("btnIsType2");
				btnIsType2.selectedProperty().bindBidirectional(pvm.getIstype2Property());
				ButtonType2Handler bt2h = new ButtonType2Handler();
				btnIsType2.setOnAction(bt2h);
				
				
				this.add(lblType1, 1, 1);
				this.add(boxType1, 2, 1);
				
				this.add(lblType2, 3, 1);
				this.add(boxType2, 4, 1);
				
				this.add(btnIsType2, 4, 2);

				
				
			}
			
			/**
			 *  Because the button and disable feature are bound to the pvm properties 
			 *  the only action that is needed is to reset the combobox value to blank
			 */
			private class ButtonType2Handler implements EventHandler<ActionEvent>{

				@Override
				public void handle(ActionEvent event) {
					
					if(btnIsType2.isSelected() == false) {
						pvm.getType2Property().set("");
					}	
				}
			}			
		}
		
		
		
		
		/**
		 * 
		 * This pane will show the Height and Weight variables with appropriate labels
		 *
		 */
		private class paneSize extends GridPane{
			public paneSize() {
				StringConverter<Number> c = new NumberStringConverter();
				this.setId("paneSize");
				
				//creating Hieght textfields with matching labels
				Label lblHeight = new Label("Avg Height: ");
				lblHeight.setId("lblHeight");
				TextField Height = new TextField();
				Height.setId("Height");
				Height.setPrefSize(50, getPrefHeight());
				Height.textProperty().bindBidirectional(pvm.getHeightProperty(), c);
				Label lblHUnit = new Label("m ");
				lblHUnit.setId("lblHUnit");
				
				
				//creating weight textfields with matching labels
				Label lblWeight = new Label("Avg Weight: ");
				lblWeight.setId("lblWeight");
				TextField Weight = new TextField();
				Weight.setId("Weight");
				Weight.setPrefSize(50, getPrefHeight());
				Weight.textProperty().bindBidirectional(pvm.getWeightProperty(), c);
				Label lblWUnit = new Label("kg");
				lblWUnit.setId("lblWUnit");
				
				
				
				this.add(lblHeight, 1, 1);
				this.add(Height, 2, 1);
				this.add(lblHUnit, 3, 1);
				
				this.add(lblWeight, 1, 2);
				this.add(Weight, 2, 2);
				this.add(lblWUnit, 3, 2);
				
				
				
			}
		}
		
		
		/**
		 * 
		 * This pane will show the two percent variables GenderRatio and CatchRate
		 * 
		 * they will be shown with sliders and can be adjusted accordingly
		 * 
		 * method of setting slider labels from
		 * https://stackoverflow.com/questions/18447963/javafx-slider-text-as-tick-label
		 *
		 */
		private class panePercent extends GridPane{
			
			public panePercent() {
			this.setId("panePercent");
			//Creating the gender ratio slider and appropriate labels
			Label lblGender = new Label("Gender Ratio:");
			lblGender.setId("lblGender");
			Slider Gender = new Slider(0,100,0);
			Gender.setId("Gender");
			Gender.valueProperty().bindBidirectional(pvm.getGenderratioProperty());
			
			
			Gender.setLabelFormatter(new StringConverter<Double>() {

				@Override
				public String toString(Double object) {
					if (object == 0.0) return "Female";
					if (object == 25.0) return "75/25";
					if (object == 50.0) return "50/50";
					if (object == 75.0) return "25/75";
					return "Male";
				}

				@Override
				public Double fromString(String string) {
					// TODO Auto-generated method stub
					return null;
				}
				
			});
			
			// creating Catchrate slider and appropriate labels
			Label lblCatchRate = new Label("Catch Rate:");
			lblCatchRate.setId("lblCatchRate");
			Slider CatchRate = new Slider(0,100,0);
			CatchRate.setId("CatchRate");
			CatchRate.valueProperty().bindBidirectional(pvm.getCatchrateProperty());
			
			
			this.add(lblGender, 1, 1);
			this.add(Gender, 1, 2);
			
			this.add(lblCatchRate, 2, 1);
			this.add(CatchRate, 2, 2);
			}
					
			
		}
		
		
		/**
		 * 
		 * This pane will show the Caught variable with labels
		 *
		 */
		private class paneCaught extends FlowPane{
			public paneCaught() {
				this.setId("paneCaught");
				StringConverter<Number> c = new NumberStringConverter();
				Label lblCaught = new Label("Total Caught:");
				lblCaught.setId("lblCaught");
				TextField Caught = new TextField();
				Caught.setId("Caught");
				Caught.textProperty().bindBidirectional(pvm.getCaughtProperty(), c);
				
				this.getChildren().addAll(lblCaught,Caught);
				
				
			}
		}
		
		/**
		 * 
		 * This pane will show buttons that will either update the pvm or update the current Pokemon Object
		 *
		 */
		private class paneButtons extends FlowPane{
			public paneButtons() {
				this.setId("paneButtons");
				
				//creating the update button with its handler
				Button Update = new Button("Update");
				Update.setId("Update");
				UpdateHandler uh = new UpdateHandler();
				Update.setOnAction(uh);
				
				//creating the cancel button with its handler
				Button Cancel = new Button("Cancel");
				Cancel.setId("Cancel");
				CancelHandler ch = new CancelHandler();
				Cancel.setOnAction(ch);
				
				
				this.getChildren().addAll(Update,Cancel);
				
			}
			
			/**
			 * 
			 * Handler that will update the currently selected Pokemon object
			 *
			 */
			private class UpdateHandler implements EventHandler<ActionEvent> {

				@Override
				public void handle(ActionEvent event) {
					pvm.updatePoke();
					
					ivm.WriteTextFile();
					ivm.calculateTotalCaught();
					listview.refresh();
					
					
				}
			}
			
			/**
			 * 
			 * Handler that will reset the pvm
			 *
			 */
			private class CancelHandler implements EventHandler<ActionEvent> {

				@Override
				public void handle(ActionEvent event) {
					pvm.setPokemon(pvm.getMyPoke());;
					
				}
			}	
		}
	}
	
	
	
	
	/**
	 * 
	 * This pane shows the ViewList and two
	 * buttons that will change and update the list
	 * 
	 *
	 */
	
	private class paneList extends BorderPane{
		
		
		public paneList() {
		this.setId("paneLists");
		
		listview = new ListView<Pokemon>(ivm.getList());
		listview.setId("listview");
		
	//	listview.getSelectionModel().getSelectedItem();
	//	pvm.setPokemon(cell);
		
		//setting up a custom cell to equal the name variable 
		listview.setCellFactory(new Callback<ListView<Pokemon>, ListCell<Pokemon>>() {
		@Override
		public ListCell<Pokemon> call (ListView<Pokemon> list) {
			
				return new NameListCell();
			}
		}
	);
		
		
		
		
		
		listview.setId("listview");
		
		
		/*
		 * Setting up the change listener to switch pvm when 
		 * another object is selected
		 */
		listview.getSelectionModel().selectedItemProperty().addListener(new ListChangeListener());
				
		
		
		listview.getSelectionModel().select(0);
		this.setCenter(listview);
		
		//setting up a new pane to separate the buttons from the list
		FlowPane fp = new FlowPane();
		fp.setId("fp");
		
		//Creating the new button and its handler
		Button New = new Button("New");
		this.setId("New");
		NewHandler nh = new NewHandler();
		New.setOnAction(nh);
		
		//Creating the delete button and its handler
		Button Delete = new Button("Delete");
		this.setId("Delete");
		DeleteHandler dh = new DeleteHandler();
		Delete.setOnAction(dh);
		
		fp.getChildren().addAll(New,Delete);
		this.setBottom(fp);
	
		
		}
		
		/**
		 * custom cell to have the name variable of the Pokemon object
		 * 
		 *
//		 */
	private class NameListCell extends ListCell<Pokemon> {
			@Override
			public void updateItem(Pokemon item, boolean empty) {
				super.updateItem(item, empty);
				if (empty == true || item == null) {
					setText(null);
			} else {
				setText(item.getName());
			}
			}
			
		}
		
		
		
		private class ListChangeListener implements ChangeListener<Pokemon>{

			@Override
			public void changed(ObservableValue<? extends Pokemon> observable, Pokemon oldValue, Pokemon newValue) {
				
				pvm.setPokemon(newValue);
				listview.refresh();
				
			}
			
			
		}
		
		
	
		/**
		 * 
		 * The new handler in insert a new Pokemon object at the end of the list
		 * and have it automatically selected for the user to change
		 * and then updates the file
		 */
		private class NewHandler implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent event) {
				ivm.addItem();
				listview.getSelectionModel().select(ivm.getList().size() - 1);
				
				ivm.WriteTextFile();
				
				ivm.calculateTotalCaught();
				ivm.calculateTotalSpecies();
				listview.refresh();
			}
		}
		
		/**
		 * 
		 * removes the currently selected item from the list and updates the file
		 * 
		 */
		private class DeleteHandler implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent event) {
				
				
			
				
				ivm.Delete(listview.getSelectionModel().getSelectedIndex());
	//			ivm.DeleteAllItems();
				
			
				
				ivm.WriteTextFile();
				
				ivm.calculateTotalCaught();
				ivm.calculateTotalSpecies();
				listview.refresh();
				
			}
			
		}
		
	}
	
	

	/**
	 * This pane will show the total pokemon caught
	 * and the total species entered
	 * 
	 */
	private class paneBottomInfo extends StackPane{
		
		public paneBottomInfo() {
			this.setId("paneBottomInfo");
			
			
			//setting up a custom flow pane to organize the total caught labels
			FlowPane cFlow = new FlowPane();
			cFlow.setId("cFlow");
			//creating the total caught label with bound int label
			Label lblTotalCaught = new Label("Total Pokemon Caught:");
			Label TotalCaught = new Label();
			TotalCaught.setId("TotalCaught");
			TotalCaught.textProperty().bind(ivm.getTotalCaught().asString());
			cFlow.getChildren().addAll(lblTotalCaught,TotalCaught);
			
			//setting up a custom flow pane to organize the species seen labels
			FlowPane sFlow = new FlowPane();
			sFlow.setId("sFlow");
			//creating the total species label with bound int label
			Label lblTotalSpecies = new Label("Total Species Seen: ");
			Label TotalSpecies = new Label();
			TotalSpecies.setId("TotalSpecies");
			TotalSpecies.textProperty().bind(ivm.getTotalSpecies().asString());
			sFlow.getChildren().addAll(lblTotalSpecies,TotalSpecies);
			
			//organizeing all the labels within a grid label
			GridPane gp = new GridPane();
			gp.setId("paneBottomInfogp");
			gp.add(cFlow, 1, 1);
			gp.add(sFlow, 1, 2);
			
			
			
			this.getChildren().add(gp);
			
		}
		
	}
	

	
	
	


}

