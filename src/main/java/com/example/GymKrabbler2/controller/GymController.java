package com.example.GymKrabbler2.controller;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

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
import com.example.GymKrabbler2.model.WriteJSONGyms;
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;
import com.example.GymKrabbler2.webCrawler.ScrapeController;
import com.example.GymKrabbler2.webCrawler.Scraper;

@Controller
public class GymController {

	@Autowired
	GymRepository gymRepository;
	@Autowired
	ScrapeDataRepository scrapeDataRepository;
	public static String errorMessage = "Aktuell gibt es keine Fehler.";

	public GymController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("gyms", gymRepository.findAll());

		return "index";
	}

//	@PostMapping("/update/{id}")
//	public String updateGym(@PathVariable("id") long id, Gym gym, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			gym.setId(id);
//			return "update-gym";
//		}
//
//		gymRepository.save(gym);
//		return "redirect:/index";
//	}

	@GetMapping("/updateGym/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		ScrapeController scrapeController = new ScrapeController();
		Gym gym = gymRepository.findById(id).get();

//		System.out.println(scrapeDataRepository.findById((long) 11).get().getUrl());

		try {

			String zeit = scrapeController.scrape(id * 10 + 1, scrapeDataRepository);
			System.out.println(zeit);

			gym.setZeiten(zeit);

		} catch (Exception e) {
			errorMessage = "Die Öffnungszeiten des Gyms " + gym.getName()
					+ " konnten nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
		}
		try {

			String preis = scrapeController.scrape(id * 10 + 2, scrapeDataRepository);
			System.out.println(preis);

			gym.setPreis(preis);

		} catch (Exception e) {
			errorMessage = "Der Preis des Gyms " + gym.getName()
					+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
		}
		try {

			String adresse = scrapeController.scrape(id * 10 + 3, scrapeDataRepository);
			System.out.println(adresse);

			gym.setAdresse(adresse);

		} catch (Exception e) {
			errorMessage = "Die Adresse des Gyms " + gym.getName()
					+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
		}
		try {

			String email = scrapeController.scrape(id * 10 + 4, scrapeDataRepository);
			System.out.println(email);

			gym.setEmail(email);

		} catch (Exception e) {
			errorMessage = "Die Email des Gyms " + gym.getName()
					+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
		}

		gymRepository.save(gym);
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

			this.update(gym.getId(), model);
			

		}
		model.addAttribute("errorMessage", errorMessage);
		return "redirect:/index";
	}

	@GetMapping("/writeGym/{id}")
	public String write(@PathVariable("id") long id, Model model) throws IOException {
		WriteJSONGyms.updateJSON(gymRepository);

		return "redirect:/index";
	}

	@GetMapping("/saveAllGyms")
	public String write(Model model) throws IOException {
		WriteJSONGyms.updateJSON(gymRepository);

		return "redirect:/index";
	}

}
