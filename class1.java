/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;

/**
 *
 * @author DSC
 */
public class class1 {
    //Declaring instance variables
    private int id;
    private String name;
    private File file = new File ("names.txt");
    
    

    

    public void generateid(){
     
     
    //Error Handling with try catch block
    try{
    //creating Scanner object for reading file
    Scanner view = new Scanner(file);
    //creating json object
    JSONObject obj= new JSONObject();
    int counter=0;
    //Reading file line by line and loop runing till end
    while(view.hasNextLine()){
        
        this.name=view.nextLine();
        this.id=counter;
        
        counter++;
        //creating another json object for each name
        JSONObject obj1=new JSONObject();
        obj1.put("name",this.name);
        obj.put(this.id,obj1);
        }
       
       view.close();
       System.out.println(obj);
       
      //creating Objects.json file and writing json object to it
       FileWriter jsonfile=new FileWriter("Objects.json");
       jsonfile.write(obj.toString());
       jsonfile.close();
     
    }
     catch (FileNotFoundException e) {
            System.out.println("The FIle can't be found error :"+e);
        }
     catch (IOException e) {
            System.out.println("There was an I/O error :" + e);
        }

    }
}
