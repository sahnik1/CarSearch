package Backend;

import java.io.*;
import java.util.*;

import Backend.Car.*;

/**
* <h1>parseCar Class</h1>
* Parsing Methods for Extracting
* Data From Files into the Car Type.
* <p>
*
* @author  Anant Jain, Karanjot Sahni
* @version 1.0
* @since   2019-02-16 
*/
public class parseCar {

	private static Car[] carlist;
	
	/**
	 * Function to Parse Data Into an Array of Cars
	 * @param String of Name of File to be Read
	 * @return Array of Car Objects
	 */
	public static Car[] readFile(String filename) {
            
		carlist = new Car[11134];
		try {   
                        BufferedReader file = new BufferedReader(new FileReader(filename));
			String line = file.readLine();
			
			for (int i = 0; line != null; i++) {
				line = file.readLine();
				if (line != null) {
					String[] csvline = line.split(",");
					Category type = getCarType(csvline[2]);
					String make = csvline[3].replace("\"", "");
					String model = csvline[4].replace("\"", "");
					int year = Integer.parseInt(csvline[1]);
					int recalls = Integer.parseInt(csvline[5]);
					int id = Integer.parseInt(csvline[0]);
					int vaff = Integer.parseInt(csvline[6]);
                                        int city = Integer.parseInt(csvline[7]);
                                        int high = Integer.parseInt(csvline[8]);
                                        int comb = Integer.parseInt(csvline[9]);
                                        int cyl = Integer.parseInt(csvline[10]);
                                        double dis = Math.round(Float.parseFloat(csvline[11])*10.0)/10.0;
                                        String trans = (csvline[12]).replace("\"", "");
                                        String drive = (csvline[13]).replace("\"", "");
                                        
					carlist[i] = new Car(make, model, year, type, recalls, id, vaff, city, high, comb, cyl, dis, trans, drive);
					
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return carlist;
		
	}
	
	private static Category getCarType(String type) {
		String cartype = type.replace("\"", "");
		if (cartype.compareTo("Standard Pickup Trucks 2WD") == 0 || cartype.compareTo("Standard Pickup Trucks") == 0 || cartype.compareTo("Small Pickup Trucks") == 0) {
			return Category.TRUCK;
		}
		else if (cartype.compareTo("Minivan - 2WD") == 0) {
			return Category.MINIVAN;
		}
		else if (cartype.compareTo("Sport Utility Vehicle - 4WD") == 0 || cartype.compareTo("Sport Utility Vehicle - 2WD") == 0) {
			return Category.SUV;
		}
		else {
			return Category.CAR;
		}
	}
	
	/**
	 * Function to Generate BST to Get Cars From Their Unique IDs
	 * @return BST with Integer Keys and Car Values
	 */
	public static BST<Integer, Car> getIDBst(){
		BST<Integer, Car> st = new BST<Integer, Car>();
	    Car[] cars = parseCar.readFile("final.csv");
	    for (int i = 0; i < cars.length; i++) {
	    	  st.put(cars[i].getID(), cars[i]);
	    }
		return st;
	}
	
	/**
	 * Function to Generate BST to Get Cars Associated with Model Names
	 * @return BST with String Keys and List of Car Values
	 */
	public static BST<String, Vector<Car> > getModelBst(){
		BST<String, Vector<Car> > st = new BST<String, Vector<Car> >();
		
	    Car[] cars = parseCar.readFile("final.csv");
	    for (int i = 0; i < cars.length; i++) {
	    	Vector<Car> list = new Vector();
	    	String currmodel = cars[i].getModel().toUpperCase();
	    	  if(st.get(currmodel) != null) {
	    		  list = st.get(currmodel);
	    		  list.add(cars[i]);
	    		  st.put(currmodel, list);
	    	  }
	    	  else {
	    		  list.add(cars[i]);
	    		  st.put(cars[i].getModel().toUpperCase(), list);
	    	  }
	    }
		return st;
	}
	
	public static void main(String[] args) {
	}

}
