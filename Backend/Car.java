package Backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
* <h1>Car Class</h1>
* Car Class Implements an Abstract
* Car Object to Easily Store Cars
* With Their Relevant Information.
* <p>
*
* @author  Anant Jain
* @author Karanjot Sahni
* @version 1.0
* @since   2019-02-16 
*/
public class Car {
	
	enum Category{ SUV, CAR, MINIVAN, TRUCK };
	
    private String Make;
    private String Model;
    private Category Cartype;
    private int Year;
    private int numRecall;
    private int VehicleID;
    private int VehicleAff;
    private int Citympg;
    private int Highmpg;
    private int Combmpg;
    private int Cyl;
    private double EngDis;
    private String Transmission;
    private String Drive;
    
    /**
	 * Constructor for Making a Car Object
	 * @param make - Make/Manufacturer of the Car
	 * @param model - Model Name of the Car
	 * @param cartype - Category of Vehicles the Car Comes Under
	 * @param recall - Total Number of Recalls Against the Car
	 * @param id - Unique ID to Represent the Car
	 * @param vehicleaff - Number of Individual Vehicles Affected By Recalls
	 * @param citympg - City Mileage for the Car
	 * @param highmpg - Highway Mileage for the Car
	 * @param combmpg - Combined Mileage for the Car
	 * @param cyl - Number of Cylinders in Engine
	 * @param dis - Total Displacement of Engine
	 * @param trans - Transmission Type
	 * @param drive - Type of Wheel Drive
	 */
    public Car(String make, String model, int year, Category cartype, int recall, int id, int vehicleaff, int citympg, int highmpg, int combmpg, int cyl, double dis, String trans, String drive){
        Make = make;
        Model = model;
        Year = year;
        Cartype = cartype;
        VehicleID = id;
        numRecall = recall;
        VehicleAff = vehicleaff;
        Citympg = citympg;
        Highmpg = highmpg;
        Combmpg = combmpg;
        Cyl = cyl;
        EngDis = dis;
        Transmission = trans;
        Drive = drive;
    }
    
    /**
	 * Getter Method for Cartype of a Car
	 * @return Cartype of the Car
	 */
    public Category getCartype(){
        return Cartype;
    }
    
    /**
	 * Getter Method for Model of a Car
	 * @return Model of the Car
	 */
    public String getModel(){
        return Model;
    }
    
    /**
	 * Getter Method for Make of a Car
	 * @return Make of the Car
	 */
    public String getMake(){
        return Make;
    }
    
    /**
	 * Getter Method for Year of a Car
	 * @return Year of the Car
	 */
    public int getYear(){
        return Year;
    }
    
    /**
	 * Getter Method for Number of Recalls on a Car
	 * @return Number of Recalls on the Car
	 */
    public int getRecall(){
        return numRecall;
    }
    
    /**
	 * Getter Method for the Unique ID of a Car
	 * @return Unique ID of the Car
	 */
    public int getID(){
        return VehicleID;
    }
    
    /**
	 * Getter Method for Number of Individual Vehicles Affected By Recalls of a Car
	 * @return Number of Individual Vehicles Affected By Recalls of the Car
	 */
    public int getVehicleAff(){
        return VehicleAff;
    }
    
    /**
	 * Getter Method for City Mileage for a Car
	 * @return City Mileage of the Car
	 */
    public int getCitympg(){
        return Citympg;
    }
    
    /**
	 * Getter Method for Highway Mileage for a Car
	 * @return Highway Mileage of the Car
	 */
    public int getHighmpg(){
        return Highmpg;
    }
    
    /**
	 * Getter Method for Combined Mileage for a Car
	 * @return Combined Mileage of the Car
	 */
    public int getCombmpg(){
        return Combmpg;
    }
    
    /**
	 * Getter Method for Number of Cylinders in the Engine for a Car
	 * @return Number of Cylinders in the Engine for the Car
	 */
    public int getCyl(){
        return Cyl;
    }
    
    /**
	 * Getter Method for Total Engine Displacement of a Car
	 * @return Total Engine Displacement of the Car
	 */
    public double getEngDis(){
        return EngDis;
    }
    
    /**
	 * Getter Method for Transmission of a Car
	 * @return Transmission of the Car
	 */
    public String getTrans(){
        return Transmission;
    }
    
    /**
	 * Getter Method for Type of Drive of a Car
	 * @return Type of Drive of the Car
	 */
    public String getDrive(){
        return Drive;
    }
    
}
