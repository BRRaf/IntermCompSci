package inventory;

import javafx.beans.property.BooleanProperty;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * 
 * This class will contain the values of the currently selected Pokemon
 * item from the list, which will either update the Pokemon object values
 * or reset the values from the currently selected pokemon
 *  
 */
public class PokemonViewModel {
	
	
	IntegerProperty idProperty;
	
	StringProperty nameProperty;
	
	StringProperty categoryProperty;
	
	DoubleProperty heightProperty;
	
	DoubleProperty weightProperty;
	
	DoubleProperty catchrateProperty;
	
	StringProperty type1Property;
	
	StringProperty type2Property;
	
	DoubleProperty genderratioProperty;
	
	DoubleProperty caughtProperty;
	
	BooleanProperty istype2Property;
	
	ObjectProperty<Image> imageProperty;
	
	Pokemon myPoke;
	
	public PokemonViewModel() {
		
		idProperty = new SimpleIntegerProperty();
		
		nameProperty = new SimpleStringProperty();
		
		categoryProperty = new SimpleStringProperty();
		
		heightProperty = new SimpleDoubleProperty();
		
		weightProperty = new SimpleDoubleProperty();
		
		catchrateProperty = new SimpleDoubleProperty();
		
		type1Property = new SimpleStringProperty();
		
		type2Property = new SimpleStringProperty();
		
		genderratioProperty = new SimpleDoubleProperty();
		
		caughtProperty = new SimpleDoubleProperty();
		
		istype2Property = new SimpleBooleanProperty();
		
		imageProperty = new SimpleObjectProperty();
		
	}
	
	public IntegerProperty getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(IntegerProperty idProperty) {
		this.idProperty = idProperty;
	}

	public StringProperty getNameProperty() {
		return nameProperty;
	}

	public void setNameProperty(StringProperty nameProperty) {
		this.nameProperty = nameProperty;
	}

	public StringProperty getCategoryProperty() {
		return categoryProperty;
	}

	public void setCategoryProperty(StringProperty descriptionProperty) {
		this.categoryProperty = descriptionProperty;
	}

	public DoubleProperty getHeightProperty() {
		return heightProperty;
	}

	public void setHeightProperty(DoubleProperty heightProperty) {
		this.heightProperty = heightProperty;
	}

	public DoubleProperty getWeightProperty() {
		return weightProperty;
	}

	public void setWeightProperty(DoubleProperty weightProperty) {
		this.weightProperty = weightProperty;
	}

	public DoubleProperty getCatchrateProperty() {
		return catchrateProperty;
	}

	public void setCatchrateProperty(DoubleProperty catchrateProperty) {
		this.catchrateProperty = catchrateProperty;
	}

	public StringProperty getType1Property() {
		return type1Property;
	}

	public void setType1Property(StringProperty type1Property) {
		this.type1Property = type1Property;
	}

	public StringProperty getType2Property() {
		return type2Property;
	}

	public void setType2Property(StringProperty type2Property) {
		this.type2Property = type2Property;
	}

	public BooleanProperty getIstype2Property() {
		return istype2Property;
	}

	public void setIstype2Property(BooleanProperty istype2Property) {
		this.istype2Property = istype2Property;
	}
	
	

	public DoubleProperty getGenderratioProperty() {
		return genderratioProperty;
	}

	public void setGenderratioProperty(DoubleProperty genderratioProperty) {
		this.genderratioProperty = genderratioProperty;
	}

	public DoubleProperty getCaughtProperty() {
		return caughtProperty;
	}

	public void setCaughtProperty(DoubleProperty caughtProperty) {
		this.caughtProperty = caughtProperty;
	}

	public ObjectProperty getImageProperty() {
		return imageProperty;
	}

	public void setImageProperty(ObjectProperty imageProperty) {
		this.imageProperty = imageProperty;
	}

	public Pokemon getMyPoke() {
		return myPoke;
	}

	public void setMyPoke(Pokemon myPoke) {
		this.myPoke = myPoke;
	}

	/*
	 * This method will set all the property values to the selected Pokemon object to show
	 * on the inventory pane
	 */
	public void setPokemon(Pokemon p) {
		
		this.idProperty.setValue(p.getId());
		
		nameProperty.set(p.getName());
		
		categoryProperty.set(p.getCategory());
		
		heightProperty.set(p.getHeight());
		
		weightProperty.set(p.getWeight());
		
		catchrateProperty.set(p.getCatchrate());
		
		type1Property.set(p.getType1());
		
		type2Property.set(p.getType2());
		
		genderratioProperty.set(p.getGenderratio());
		
		caughtProperty.set(p.getCaught());
		
		istype2Property.set(p.getIstype2());
		
		imageProperty.set(p.getImage());
	
		
		myPoke = p;	
		
		
	}
	
	/*
	 * this will change the values of the currently selected pokemon object
	 * to the current values of this model
	 */
	public void updatePoke() {
		
		myPoke.setName(nameProperty.get());
		myPoke.setCatchrate(catchrateProperty.get());
		myPoke.setCaught(caughtProperty.get());
		myPoke.setCategory(categoryProperty.get());
		myPoke.setGenderratio(genderratioProperty.get());
		myPoke.setHeight(heightProperty.get());
		myPoke.setWeight(weightProperty.get());
		myPoke.setType1(type1Property.get());
		myPoke.setType2(type2Property.get());
		myPoke.setIsType2(istype2Property.get());
		myPoke.setImage(imageProperty.get());
		
		
	}
	
	
	

}
