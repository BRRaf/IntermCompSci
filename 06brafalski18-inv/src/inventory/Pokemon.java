package inventory;

import java.io.InputStream;

import javafx.scene.image.Image;

public class Pokemon {

	int id;
	
	String name;
	
	String category;
	
	double height;

	double weight;
	
	double catchrate;
	
	boolean istype2;
	
	String type1;
	
	String type2;
	
	double genderratio;
	
	double caught;
	
	Image image;
	
	String url;
	
	/**
	 * This Object will hold specific variables that will be sent to the Pokemon View
	 * Model
	 * 
	 * @param id
	 * @param name
	 * @param category
	 * @param height
	 * @param weight
	 * @param catchrate
	 * @param type1
	 * @param type2
	 * @param genderratio
	 * @param istype2
	 * @param caught
	 * @param image
	 */
	
	public Pokemon(int id, String name, String category, double height, double weight, double catchrate, String type1, String type2, double genderratio, boolean istype2, double caught, String image) {	
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.height = height;
		this.weight = weight;
		this.catchrate = catchrate;
		this.type1 = type1;
		this.type2 = type2;
		this.genderratio = genderratio;
		this.istype2 = istype2;
		this.caught = caught;
		this.url = image;
		this.image = new Image("pics/"+url);
	}



	public int getId() {
		return id;
	}



	public Pokemon setId(int id) {
		this.id = id;
		return this;
	}



	public String getName() {
		return name;
	}



	public Pokemon setName(String name) {
		this.name = name;
		return this;
	}



	public double getHeight() {
		return height;
	}



	public Pokemon setHeight(double height) {
		this.height = height;
		return this;
	}



	public double getWeight() {
		return weight;
	}



	public Pokemon setWeight(double weight) {
		this.weight = weight;
		return this;
	}



	public double getCatchrate() {
		return catchrate;
	}



	public Pokemon setCatchrate(double catchrate) {
		this.catchrate = catchrate;
		return this;
	}



	public String getType1() {
		return type1;
	}



	public Pokemon setType1(String type1) {
		this.type1 = type1;
		return this;
	}



	public String getType2() {
		return type2;
	}



	public Pokemon setType2(String type2) {
		this.type2 = type2;
		return this;
	}
	
	
	public boolean getIstype2() {
		return istype2;
	}



	public Pokemon setIsType2(boolean istype2) {
		this.istype2 = istype2;
		return this;
	}



	public double getGenderratio() {
		return genderratio;
	}



	public Pokemon setGenderratio(double genderratio) {
		this.genderratio = genderratio;
		return this;
	}



	public String getCategory() {
		return category;
	}



	public Pokemon setCategory(String category) {
		this.category = category;
		return this;
	}



	public double getCaught() {
		return caught;
	}



	public Pokemon setCaught(double caught) {
		this.caught = caught;
		return this;
	}



	public Image getImage() {
		return image;
	}



	public void setImage(Image image) {
		this.image = image;
	}



	public void setIstype2(boolean istype2) {
		this.istype2 = istype2;
	}



	public String getUrl() {
		return url;
	}


	/*
	 * Whenever the url is loaded from the inventory view model 
	 * it will also set the image to that url variable
	 */
	
	public void setUrl(String url) {

		image = new Image("pics/"+url);
		this.url = url;
	}
}
