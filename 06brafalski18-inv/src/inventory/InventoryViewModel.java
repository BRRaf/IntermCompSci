package inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;


/**
 * 
 * An instance of this class will hold the entire list of Pokemon objects
 * that will be read by the main view. The 
 *
 */
public class InventoryViewModel {

	//setting up the observable list of Pokemon Objects
	ObservableList<Pokemon> list = FXCollections.observableArrayList();
	
	IntegerProperty totalSpecies;
	IntegerProperty totalCaught;
	File f;
	

	public InventoryViewModel() {

	// the file the list reads and writes to
	f = new File("PokeList.txt");
	
	
	totalSpecies = new SimpleIntegerProperty();		
	totalCaught = new SimpleIntegerProperty();
	
//	Pokemon p = new Pokemon(1, "Bulbasaur", "Seed", 0.7, 6.9, 5.9, "Grass", "Poison", 87.5, true, 1, "1.png");
//	Pokemon q = new Pokemon(2, "Charmander", "Lizard", 0.6, 8.5, 5.9, "Fire", "", 87.5, false, 3, "2.png");
//	Pokemon r = new Pokemon(3, "Squirtle", "Turtle", 0.5, 8.5, 9.0, "Water", "", 87.5, false, 3, "3.png");
	
//	list.add(p);
//	list.add(q);
//	list.add(r);
	
	this.ReadTextFile();
//	this.WriteTextFile();
	
	
	this.calculateTotalSpecies();
	this.calculateTotalCaught();
	
	
	}
	
	// A quick access to the remove command to use in the inventory pane
	public void Delete(int i) {
		if (list.size() > 1) {
		list.remove(i);
		} else {
			System.out.println("Can't Delete. Need more items");
		}
	}
	
	/*
	 * A method that sets the first elements in the list to a blank editable 
	 * item and then removes every item after that
	 */
	public void DeleteAllItems() {
		System.out.println("Hello");
		
		
		list.set(0, new Pokemon(1,"Blank","",0,0,0,"","",50,false,0,"unknown.png"));
		
		for(int i = 1; i < list.size(); i++){ 
			list.remove(i);
		}
		
	//	list.removeAll(list);
		
	}
	
	
	/*
	 * Returns specifc item by index
	 */
	public Pokemon FindItem(int i) {
		Pokemon p = list.get(i);
		return p;
	}
	
	/*
	 * inserts a new Pokemon object into the next available slot on the list
	 */
	public void addItem() {
		list.add(new Pokemon(list.get(list.size() - 1).getId() + 1,"Blank","",0,0,0,"","",50,false,0,"unknown.png"));
	}
	
	public ObservableList<Pokemon> getList() {
		return list;
	}

	public void setList(ObservableList<Pokemon> list) {
		this.list = list;
	}

	public IntegerProperty getTotalSpecies() {
		return totalSpecies;
	}
	

	public void setTotalSpecies(IntegerProperty totalSpecies) {
		this.totalSpecies = totalSpecies;
	}
	
	/*
	 * Calculate the number of species in the list
	 * i.e how many items are in the list
	 * 
	 */
	
	public void calculateTotalSpecies() {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += 1;
		}
		totalSpecies.set(sum);
	}

	public IntegerProperty getTotalCaught() {
		return totalCaught;
	}

	public void setTotalCaught(IntegerProperty totalCaught) {
		this.totalCaught = totalCaught;
	}
	
	
	/*
	 * sums up all the caught variables in each object
	 */
	public void calculateTotalCaught() {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i).getCaught();	
		}
		totalCaught.set(sum);
	}
		
	/*
	 * retrives the information from
	 * a specific file
	 */
	
	public void ReadTextFile() {
		
		BufferedReader br = null;
	
			
		try {
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String str = br.readLine();
			while (str != null) {
				String [] splitString = str.split(",");
				Pokemon p = new Pokemon(1, "", "", 0, 0, 0, "", "", 0, false, 0, "unknown.png");
			
				
				p.setId(Integer.parseInt(splitString[0]));
				p.setName(splitString[1]);
				p.setCategory(splitString[2]);
				p.setHeight(Double.parseDouble(splitString[3]));
				p.setWeight(Double.parseDouble(splitString[4]));
				p.setCatchrate(Double.parseDouble(splitString[5]));
				p.setType1(splitString[6]);
				p.setType2(splitString[7]);
				p.setGenderratio(Double.parseDouble(splitString[8]));
				p.setIstype2(Boolean.parseBoolean(splitString[9]));
				p.setCaught(Double.parseDouble(splitString[10]));
				p.setUrl(splitString[11]);
				
				
				
				list.add(p);
				str = br.readLine();
			}
		} catch (IOException ex) {
			
			System.err.println(ex.getMessage());
		} finally {
			
			try {
				if(br != null) {
					br.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	
	/*
	 * writes to a saved text file that will
	 * be read when the program closes and becomes reopened
	 */

	public void WriteTextFile() {
		
		PrintWriter pw = null;
		try {
			
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
	
			for(int i = 0; i < list.size(); i++) {
				pw.write(String.valueOf(list.get(i).getId()));
				pw.write(",");
				pw.write(list.get(i).getName());
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getCategory()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getHeight()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getWeight()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getCatchrate()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getType1()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getType2()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getGenderratio()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getIstype2()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getCaught()));
				pw.write(",");
				pw.write(String.valueOf(list.get(i).getUrl()));
				
				
				pw.println();
			}
			
			
		}
		catch (IOException ex) {
			
			System.err.println("Trouble with file: "+ex.getMessage());
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		
	}

	
}
