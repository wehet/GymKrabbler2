package com.example.GymKrabbler2.model;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.example.GymKrabbler2.repository.GymRepository;
 
public class ReadJSON 

{
	static JSONParser jsonParser = new JSONParser();
	
	
    
    @SuppressWarnings("unchecked")
	public static void parseGyms(GymRepository gymRepository) {
    	  try (FileReader reader = new FileReader("src\\main\\resources\\gymData.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray gymList = (JSONArray) obj;
            System.out.println(gymList);
             
            List<Gym> gyms = new LinkedList<Gym>();
            
            //Iterate over gym array
            gymList.forEach( emp -> parseGymObject( (JSONObject) emp, gyms) );
            
            //update the repository
            gymRepository.saveAll(gyms);
            
           
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseGymObject(JSONObject employee, List<Gym> gyms) 
    {
        //Get gym object within list
        JSONObject employeeObject = (JSONObject) employee.get("gym");
        
        //Get id
        long id = Long.parseLong((String) employeeObject.get("name"));
        System.out.println("" + id);
        
        //Get gym name
        String name = (String) employeeObject.get("name");    
        System.out.println(name);
         
        //Get gym url
        String url = (String) employeeObject.get("url");  
        System.out.println(url);
         
        //Get gym email
        String email = (String) employeeObject.get("email");    
        System.out.println(email);
        
        String zeiten = (String) employeeObject.get("zeiten");    
        System.out.println(zeiten);
        
        String adresse = (String) employeeObject.get("adresse");    
        System.out.println(adresse);
        
        String bewertung = (String) employeeObject.get("bewertung");    
        System.out.println(bewertung);
        
        String preis = (String) employeeObject.get("preis");    
        System.out.println(preis);
        
        
       
        //add new Gym
        gyms.add(new Gym(id, name, url, email, zeiten, preis, adresse, bewertung ));
        
        
        
        
    }
}