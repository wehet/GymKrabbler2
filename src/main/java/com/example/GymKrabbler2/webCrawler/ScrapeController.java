package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.GymKrabbler2.model.Gym;
import com.example.GymKrabbler2.model.ScrapeData;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;

public class ScrapeController {
	@Autowired
	private ScrapeDataRepository scrapeDataRepository;
	
	public ScrapeController() {}
	
	public String scrape (long id) throws Exception {
		ScrapeData scrapeData = scrapeDataRepository.findById(id).get();
		Scraper scraper = new Scraper(scrapeData);
		return scraper.scrapeWebsite(scrapeData);
	}
}
