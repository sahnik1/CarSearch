/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaswindersinghsahni
 */

public class TableEx {    
    public static JFrame f;    
    public static void TableEx(Car[] cars){    
    f = new JFrame();    
    String columns[]={"VehicleID","Type", "Make","Model", "Recalls_Total", "Vehicles_Affected"};  
    //Car[] cars = parseCar.readFile("Recalls_final.csv");
    
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    for (int i = 0; i < cars.length; i++)
    {
        model.addRow( new Object[]{ cars[i].getID(), cars[i].getCartype(), cars[i].getMake().toUpperCase(), cars[i].getModel().toUpperCase(), cars[i].getRecall(), cars[i].getVehicleAff() } );
    }
    JTable jt = new JTable(model);            
    jt.setBounds(30,40,200,300);
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);  

    }       
    /*public static void main(String[] args) {    
    }*/   
}  
