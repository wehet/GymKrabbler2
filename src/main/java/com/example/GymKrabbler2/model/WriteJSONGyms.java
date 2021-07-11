package com.example.GymKrabbler2.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
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
				gymDetails.put("scrapeZeiten", gym.getScrapeZeiten());
				gymDetails.put("scrapePreis", gym.getScrapePreis());
				gymDetails.put("scrapeAdresse", gym.getScrapeAdresse());
				gymDetails.put("scrapeEmail", gym.getScrapeEmail());
				gymDetails.put("timestamp", gym.getTimestamp());
				gymDetails.put("timestamp", gym.getStatus());
				
				
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


	}
}