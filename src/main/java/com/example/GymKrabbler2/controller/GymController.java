package com.example.GymKrabbler2.controller;

import java.io.IOException;

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
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.webCrawler.ScrapeController;

@Controller
public class GymController {

	@Autowired
	private GymRepository gymRepository;

	public GymController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/signup")
	public String showSignUpForm(Gym gym) {
		return "add-gym";
	}

	@PostMapping("/addgym")
	public String addUser(Gym gym, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-gym";
		}

		gymRepository.save(gym);
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("gyms", gymRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Gym gym = gymRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gym Id:" + id));

		model.addAttribute("gym", gym);
		return "gym-user";
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

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Gym gym = gymRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gym Id:" + id));
		gymRepository.delete(gym);
		return "redirect:/index";
	}

	@GetMapping("/updateGym/{id}")
	public String update(@PathVariable("id") long id, Model model) throws IOException {
		Gym gym = gymRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gym Id:" + id));
		ScrapeController.update(gym);
		
		gymRepository.save(gym);

		return "redirect:/index";

	}

}
