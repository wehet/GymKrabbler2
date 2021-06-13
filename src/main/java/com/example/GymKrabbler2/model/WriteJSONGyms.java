package com.example.GymKrabbler2.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.GymKrabbler2.repository.GymRepository;

public class WriteJSONGyms {
	static JSONParser jsonParser = new JSONParser();

	public static void updateJSON(GymRepository gymRepository) {
		try (FileWriter file = new FileWriter("src\\main\\resources\\gymData.json")) {
			
			JSONArray gymList = new JSONArray();


//			file.close();

//			FileWriter file2 = new FileWriter("src\\main\\resources\\gymData.json");
			for (Gym gym : gymRepository.findAll()) {
				
				JSONObject gymObject = new JSONObject();

				JSONObject gymDetails = new JSONObject();
				gymDetails.put("name", gym.getName());
				gymDetails.put("adresse", gym.getAdresse());
				gymDetails.put("zeiten", gym.getZeiten());
				gymDetails.put("url", gym.getUrl());
				gymDetails.put("email", gym.getEmail());
				gymDetails.put("preis", gym.getPreis());
				
				gymObject.put("gym", gymDetails);
				gymList.add(gymObject);
				

				

			}
			file.write(gymList.toJSONString());
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Read JSON file

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

//        //First Employee
//        JSONObject gymDetails = new JSONObject();
//        gymDetails.put("firstName", "Lokesh");
//        gymDetails.put("lastName", "Gupta");
//        gymDetails.put("website", "howtodoinjava.com");
//         
//        JSONObject gymObject = new JSONObject(); 
//        gymObject.put("employee", gymDetails);
//         
//        //Second Employee
//        JSONObject gymDetails2 = new JSONObject();
//        gymDetails2.put("firstName", "Brian");
//        gymDetails2.put("lastName", "Schultz");
//        gymDetails2.put("website", "example.com");
//         
//        JSONObject gymObject2 = new JSONObject(); 
//        gymObject2.put("employee", gymDetails2);
//         
//        //Add employees to list
//        JSONArray gymList = new JSONArray();
//        gymList.add(gymObject);
//        gymList.add(gymObject2);
//         
//        //Write JSON file
//        try (FileWriter file = new FileWriter("src\\main\\resources\\gymData.json")) {
//            //We can write any JSONArray or JSONObject instance to the file
//            file.write(gymList.toJSONString()); 
//            file.flush();
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	}
}