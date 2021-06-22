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

public class ReadJSONGyms

{
	static JSONParser jsonParser = new JSONParser();

	@SuppressWarnings("unchecked")
	public static void parseGyms(GymRepository gymRepository) {
		try (FileReader reader = new FileReader("src\\main\\resources\\gymData.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray gymList = (JSONArray) obj;
			System.out.println(gymList);

			List<Gym> gyms = new LinkedList<Gym>();

			// Iterate over gym array
			gymList.forEach(gym -> parseGymObject((JSONObject) gym, gyms));

			// update the repository
			gymRepository.saveAll(gyms);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseGymObject(JSONObject gym, List<Gym> gyms) {
		// Get gym object within list
		JSONObject gymObject = (JSONObject) gym.get("gym");

		long id = Long.parseLong((String) gymObject.get("id"));
		String name = (String) gymObject.get("name");
		String url = (String) gymObject.get("url");
		String email = (String) gymObject.get("email");
		String zeiten = (String) gymObject.get("zeiten");
		String adresse = (String) gymObject.get("adresse");
		String bewertung = (String) gymObject.get("bewertung");
		String preis = (String) gymObject.get("preis");
		long scrapeZeiten = Long.parseLong((String) gymObject.get("scrapeZeiten"));
		long scrapePreis = Long.parseLong((String) gymObject.get("scrapePreis"));
		long scrapeAdresse = Long.parseLong((String) gymObject.get("scrapeAdresse"));
		long scrapeEmail = Long.parseLong((String) gymObject.get("scrapeEmail"));

		// add new Gym
		gyms.add(new Gym(id, name, url, email, zeiten, preis, adresse, bewertung, scrapeZeiten, scrapePreis,
				scrapeAdresse, scrapeEmail));

	}
}