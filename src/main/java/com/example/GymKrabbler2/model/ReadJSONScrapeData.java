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

import com.example.GymKrabbler2.repository.ScrapeDataRepository;
 
public class ReadJSONScrapeData 

{
	static JSONParser jsonParser = new JSONParser();
	
	
    
    @SuppressWarnings("unchecked")
	public static void parseGyms(ScrapeDataRepository scrapeDataRepository) {
    	  try (FileReader reader = new FileReader("src\\main\\resources\\scrapeData.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray scrapeDataList = (JSONArray) obj;
            System.out.println(scrapeDataList);
             
            List<ScrapeData> scrapeData = new LinkedList<ScrapeData>();
            
            //Iterate over gym array
            scrapeDataList.forEach( emp -> parseGymObject( (JSONObject) emp, scrapeData) );
            
            //update the repository
            scrapeDataRepository.saveAll(scrapeData);
            
           
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseGymObject(JSONObject employee, List<ScrapeData> scrapeData) 
    {
        //Get gym object within list
        JSONObject employeeObject = (JSONObject) employee.get("scrape");
        
        //Get id
        long id = Long.parseLong((String) employeeObject.get("id"));
        System.out.println("" + id);
        
        //Get gym name
        Boolean normal = Boolean.parseBoolean((String) employeeObject.get("normal"));    
        System.out.println(normal);
         
        //Get gym url
        String url = (String) employeeObject.get("url");  
        System.out.println(url);
         
        //Get gym email
        String xpath = (String) employeeObject.get("xpath");    
        System.out.println(xpath);
        
        String start = (String) employeeObject.get("start");    
        System.out.println(start);
        
        String end = (String) employeeObject.get("end");    
        System.out.println(end);
        
    
        
        
       
        //add new Gym
        scrapeData.add(new ScrapeData(id, normal, url, xpath, start, end));
        
        
        
        
    }
}