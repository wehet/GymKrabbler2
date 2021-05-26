package com.example.GymKrabbler2.webCrawler;

public class ScrapeController {

	public static void update_fitIn_Kaiserstrasse() {
		
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Kaiserstraße();
		Scraper.scrape_fitIn_Zeit_Kaiserstraße();
	}
	

	public static void update_fitIn_Daimlerstrasse() {
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Daimlerstrasse();
		Scraper.scrape_fitIn_Zeit_Daimlerstrasse();
	}

	public static void update_fitIn_Ebertstrasse() {
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Ebertstrasse();
		Scraper.scrape_fitIn_Zeit_Ebertstrasse();
	}
	
	public static void update_fitIn_Durlach() {
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Durlach();
		Scraper.scrape_fitIn_Zeit_Durlach();
	}
	
	
	public static void update_Pfitzenmeier() {
		Scraper.scrape_pfitzenmeier_Kosten();
		Scraper.scrape_pfitzenmeier_Adresse();
		Scraper.scrape_pfitzenmeier_Zeit();
	}
	
	
	
	public static void update_VeniceBeach_postgalerie() {
		Scraper.scrape_veniceBeach_Kosten_postgalerie();
		Scraper.scrape_veniceBeach_Adresse_postgalerie();
		Scraper.scrape_veniceBeach_Zeit_postgalerie();
	}
	
	
	
	public static void update_VeniceBeach_suedstadt() {
		Scraper.scrape_veniceBeach_Kosten_suedstadt();
		Scraper.scrape_veniceBeach_Adresse_suedstadt();
		Scraper.scrape_veniceBeach_Zeit_suedstadt();
		
	}
	
	
	public static void update_dieBasis() {
		Scraper.scrape_dieBasis_Adresse();
		Scraper.scrape_dieBasis_Zeit();
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}
