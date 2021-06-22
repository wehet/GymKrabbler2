package com.example.GymKrabbler2.controller;

import java.io.IOException;
import org.json.simple.JSONObject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.GymKrabbler2.model.Gym;
import com.example.GymKrabbler2.model.WriteJSONGyms;
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;
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

	@GetMapping("/messageBox")
	public String messageBox(Model model) throws IOException {
		model.addAttribute("errorMessage", errorMessage);
		System.out.println(errorMessage);
		return "messageBox";

	}

	@GetMapping("/updateAllGyms")
	public String update(Model model) {

		for (Gym gym : gymRepository.findAll()) {

			try {
				String zeit = new Scraper(scrapeDataRepository.findById(gym.getScrapeZeiten()).get()).scrapeWebsite();

				gym.setZeiten(zeit);

			} catch (Exception e) {
				errorMessage = "Die Öffnungszeiten des Gyms " + gym.getName()
						+ " konnten nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
			}
			try {

				String preis = new Scraper(scrapeDataRepository.findById(gym.getScrapePreis()).get()).scrapeWebsite();
				System.out.println(preis);

				gym.setPreis(preis);

			} catch (Exception e) {
				errorMessage = "Der Preis des Gyms " + gym.getName()
						+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
			}
			try {

				String adresse = new Scraper(scrapeDataRepository.findById(gym.getScrapeAdresse()).get())
						.scrapeWebsite();
				System.out.println(adresse);

				gym.setAdresse(adresse);

			} catch (Exception e) {
				errorMessage = "Die Adresse des Gyms " + gym.getName()
						+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
			}
			try {

				String email = new Scraper(scrapeDataRepository.findById(gym.getScrapeEmail()).get()).scrapeWebsite();
				System.out.println(email);

				gym.setEmail(email);

			} catch (Exception e) {
				errorMessage = "Die Email des Gyms " + gym.getName()
						+ " konnte nicht gescraped werden :( Bitte kontaktieren Sie den Support unter xxx@example.com";
			}

			gymRepository.save(gym);

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
