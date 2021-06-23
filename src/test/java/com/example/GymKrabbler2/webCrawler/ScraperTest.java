package com.example.GymKrabbler2.webCrawler;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.*;

import com.example.GymKrabbler2.model.ScrapeData;

public class ScraperTest {
	
	@Test
	void scrapeWebsiteTest() throws Exception {
		
		ScrapeData mockData = mock(ScrapeData.class);
		when(mockData.getUrl()).thenReturn("url");  
		when(mockData.getXpath()).thenReturn("Start irgendwas End");
		when(mockData.getStart()).thenReturn("Start");
		when(mockData.getEnd()).thenReturn("End");
		
		Scraper s = new Scraper(mockData);
		String el = s.scrapeWebsite(); 
		assertEquals(" irgendwas ", el);
	}

}
