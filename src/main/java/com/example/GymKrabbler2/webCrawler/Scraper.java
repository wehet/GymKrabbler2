package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

import com.example.GymKrabbler2.model.ScrapeData;
import com.example.GymKrabbler2.webCrawler.exceptions.ScrapeException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {

//	static WebClient client = new WebClient();
	private ScrapeData scrapeData;

	public Scraper(ScrapeData scrapeData) {
		this.scrapeData = scrapeData;
	}

	// General Scraping method
	public String scrapeWebsite(ScrapeData scrapeData) throws Exception {
		@SuppressWarnings("resource")
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		String el = null;

		HtmlPage page = null;
		try {
			page = client.getPage(scrapeData.getUrl());
			
		
			HtmlElement element = ((HtmlElement) page.getFirstByXPath(scrapeData.getXpath()));
			
			
			el = element.asText();
		} catch (Exception e) {
			
			System.out.println("Fehler beim Scraper");
			throw new Exception();
		}
		
		//evtl noch was für Catch überlegen
		if (scrapeData.getNormal()) {
			GymParser scraper = new GymParser();
			try {
				el = scraper.getTokens(el, scrapeData.getStart(), scrapeData.getEnd());
			} catch (Exception e) {
				System.out.println("Fehler beim Parsing");
				throw new Exception();
			}
		} else {
			//switch-Implementierung
			switch ((int) scrapeData.getId()) {
			//@Schanne: als Utility Klasse ausgliedern?
			case 1:
				try {
					scrape_bulldog_adresse(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			case 2:
				try {
					scrape_bulldog_Email(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			case 3:
				try {
					scrape_fitpur_Adresse(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			case 4:
				try {
					scrape_fitpur_Email(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			case 5:
				try {
					scrape_snapfit_Email(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			case 6:
				try {
					scrape_dieBasis_Adresse(el);
				} catch (IOException e) {
					throw new Exception();
				}
				break;
			}
				
		}
		
		return el;
		
		
	}

	public static String scrape_bulldog_adresse(String el) throws IOException {
		String help = "";
		GymParser gymParser = new GymParser();
		help = gymParser.getTokens(el, ">", "|");
		help = help + gymParser.getTokens(el, "|", "<");
		el = help;
		return el;
	}

	public static String scrape_bulldog_Email(String el) throws IOException {
		GymParser gymParser = new GymParser();
		el = (gymParser).getTokens(el, ":", null);
		el = gymParser.getTokens(el, ":", "Internet");
		return el;
	}
	
	public static String scrape_fitpur_Email(String el) throws IOException {
		GymParser gymParser = new GymParser();
		for (int i = 0; i<4; i++) {
			el = gymParser.getTokens(el, ":", null);
		}
		return el;
	}

	public static String scrape_fitpur_Adresse(String el) throws IOException {
		// NLP
		String help = "";
		GymParser gymParser = new GymParser();
		help = gymParser.getTokens(el, "Karlsruhe", "Tel");
		help = help + gymParser.getTokens(el, "663", "karlsruhe@fit-pur");
		el = help;
		return el;
	}
	
	public static String scrape_snapfit_Email(String el) throws IOException {
		// NLP
		GymParser gymParser = new GymParser();
		for (int i = 0; i<3; i++) {
			el = gymParser.getTokens(el, ":", null);
		}
		el = gymParser.getTokens(el, ":", "Geschäftsführung");
		return el;
	}
	
	public static String scrape_dieBasis_Adresse(String el) throws IOException {
		String strasse = null;
		String plz = null;
//		strasse = scrapeWebsite(client, "https://basis-karlsruhe.de/impressum/",
//				"//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[2]");
//		plz = scrapeWebsite(client, "https://basis-karlsruhe.de/impressum/",
//				"//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[3]");
		return strasse + " " + plz;
	}
	
}