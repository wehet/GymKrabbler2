package com.example.GymKrabbler2.webCrawler;

import com.example.GymKrabbler2.model.ScrapeData;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {
	private ScrapeData scrapeData;

//	static WebClient client = new WebClient();

	public Scraper() {
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
			System.out.println("getPage: " + page);

			HtmlElement element = ((HtmlElement) page.getFirstByXPath(scrapeData.getXpath()));

			el = element.asText();
		} catch (Exception e) {

			System.out.println("Fehler beim Scraper");
			e.printStackTrace();
			throw new Exception("Fehler beim Scraper");
		}

		GymParser parser = new GymParser();
		try {
			el = parser.getTokens(el, scrapeData.getStart(), scrapeData.getEnd());
		} catch (Exception e) {
			System.out.println("Fehler beim Parsing");
			throw new Exception();
		}

		return el;

	}

}