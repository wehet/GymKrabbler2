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
import com.example.GymKrabbler2.model.WriteJSON;
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.webCrawler.ScrapeController;

@Controller
public class GymController {

	@Autowired
	private GymRepository gymRepository;
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

//	@GetMapping("/updateGym/{id}")
//	public String update(@PathVariable("id") long id, Model model) throws IOException {
//		Gym gym = gymRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gym Id:" + id));
//
//		try {
//			//
//			//Scraper scraper = new Scraper(gymRepository.findById(id));
//			//Adresse
//			//scraper.scrape(gym.adressescraper);
//			Scraper scraper = new Scraper();
//		} catch (IOException e) {
//			errorMessage = e.getMessage();
//		}
//		model.addAttribute("errorMessage", errorMessage);
//		gymRepository.save(gym);
//
//		return "redirect:/index";
//	}

	@GetMapping("/messageBox")
	public String messageBox(Model model) throws IOException {
		model.addAttribute("errorMessage", errorMessage);
		System.out.println(errorMessage);
		return "messageBox";

	}

//	@GetMapping("/updateAllGyms")
//	public String update(Model model) {
//
//		for (Gym gym : gymRepository.findAll()) {
//
//			try {
//				ScrapeController.update(gym);
//				gymRepository.save(gym);
//			} catch (IOException e) {
//				// TODO: handle exception
//				errorMessage = errorMessage + "\n" + e.getMessage();
//				continue;
//			}
//		}
//		model.addAttribute("errorMessage", errorMessage);
//		return "redirect:/index";
//	}

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
