package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.GymKrabbler2.controller.GymController;
import com.example.GymKrabbler2.model.Gym;
import com.example.GymKrabbler2.model.ScrapeData;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;
@Controller
public class ScrapeController {

	
	
	public ScrapeController() {}
	
	public String scrape (long id, ScrapeDataRepository scrapeDataRepository) throws Exception {
		
//		for (ScrapeData data : scrapeDataRepository.findAll()) {
//
//			System.out.println(data.getId());
//		
//	}
		ScrapeData scrapeData = scrapeDataRepository.findById(id).get();
		Scraper scraper = new Scraper(scrapeData);
		return scraper.scrapeWebsite(scrapeData);
	}
}
