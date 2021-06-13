package com.example.GymKrabbler2.controller;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GymKrabbler2.model.Gym;
import com.example.GymKrabbler2.model.ScrapeData;
import com.example.GymKrabbler2.model.WriteJSON;
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;
import com.example.GymKrabbler2.webCrawler.ScrapeController;
import com.example.GymKrabbler2.webCrawler.Scraper;

@Controller
public class GymController {

	@Autowired
	private GymRepository gymRepository;
	@Autowired
	private ScrapeDataRepository scrapeDataRepository;
	public static String errorMessage = "Aktuell gibt es keine Fehler.";

	public GymController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("gyms", gymRepository.findAll());

		return "index";
	}

	@PostMapping("/update/{id}")
	public String updateGym(@PathVariable("id") long id, Gym gym, BindingResult result, Model model) {
		if (result.hasErrors()) {
			gym.setId(id);
			return "update-gym";
		}

		gymRepository.save(gym);
		return "redirect:/index";
	}

	@GetMapping("/updateGym/{id}")
	public String update(@PathVariable("id") long id, Model model){
		ScrapeController scrapeController = new ScrapeController();
		Gym gym = gymRepository.findById(id).get();

		try {
			String zeit = scrapeController.scrape(id * 10 + 1);
			String preis = scrapeController.scrape(id * 10 + 2);
			String adresse = scrapeController.scrape(id * 10 + 3);
			String email = scrapeController.scrape(id * 10 + 4);

			gym.setZeiten(zeit);
			gym.setPreis(preis);
			gym.setAdresse(adresse);
			gym.setEmail(email);

			gymRepository.save(gym);

			// Adresse
			// scraper.scrape(gym.adressescraper);
		} catch (Exception e) {
			errorMessage = "Die Webseite des Gyms " + gym.getName()
					+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
		}
		model.addAttribute("errorMessage", errorMessage);

		return "redirect:/index";
	}

	@GetMapping("/messageBox")
	public String messageBox(Model model) throws IOException {
		model.addAttribute("errorMessage", errorMessage);
		System.out.println(errorMessage);
		return "messageBox";

	}

	@GetMapping("/updateAllGyms")
	public String update(Model model) {

		for (Gym gym : gymRepository.findAll()) {

				GymController gymController = new GymController();
				gymController.update(gym.getId(), model);
				gymRepository.save(gym);
			
		}
		model.addAttribute("errorMessage", errorMessage);
		return "redirect:/index";
	}

	@GetMapping("/writeGym/{id}")
	public String write(@PathVariable("id") long id, Model model) throws IOException {
		WriteJSON.updateJSON(gymRepository);

		return "redirect:/index";
	}

	@GetMapping("/saveAllGyms")
	public String write(Model model) throws IOException {
		WriteJSON.updateJSON(gymRepository);

		return "redirect:/index";
	}

}
