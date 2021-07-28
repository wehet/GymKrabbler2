package com.example.GymKrabbler2.webScraper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;
import org.junit.Assert;
import java.io.IOException;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.example.GymKrabbler2.model.ScrapeData;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ScrapeWebsiteTest {
	@Test
	//Exception bei scrapeWebseite testen
	void scrapeWebsiteTest() throws Exception{
		//Fehlerhaftes Scrapedata Objekt erstellen
		ScrapeData sd = new ScrapeData();
		
		//an Scraper Objekt übergeben
		Scraper scraper = new Scraper();
		
		
		try {
		//scrapeWebsite Methode ausführen
		scraper.scrapeWebsite(sd);
		fail();
		}catch(Exception e) {
			String message = e.getMessage();
			assertEquals("Fehler beim Scraper",message);
		}
	}

}
