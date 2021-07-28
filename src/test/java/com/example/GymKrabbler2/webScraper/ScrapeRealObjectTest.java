package com.example.GymKrabbler2.webScraper;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import com.example.GymKrabbler2.model.ScrapeData;


public class ScrapeRealObjectTest {
	
	
	@Test
	//Scrapen eines Gym Attributs
	public void scrapeGymAttributTest() throws Exception {
	long id=11;
	String url="https://fit-in.de/club/kaiserstrasse/"; 
	String xpath ="//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]"; 
	String start ="ÖFFNUNGSZEITEN";
	String end = "Noch";
	ScrapeData sd = new ScrapeData(id,url,xpath,start,end);
	Scraper scrappy = new Scraper();
	String öffn = scrappy.scrapeWebsite(sd);
	assertEquals("Mo - Fr : 06.00  Uhr – 23.00  Uhr Sa - So : 08.00  Uhr – 22.00  Uhr Feiertag 08.00  - 20.00  Uhr ",öffn);
	}

}
