package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

public class ScrapeController {

	public static void update_fitIn_Kaiserstrasse() throws IOException {
		
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Kaiserstraße();
		Scraper.scrape_fitIn_Zeit_Kaiserstraße();
	}
	

	public static void update_fitIn_Daimlerstrasse() throws IOException {
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Daimlerstrasse();
		Scraper.scrape_fitIn_Zeit_Daimlerstrasse();
		
	}

	public static void update_fitIn_Ebertstrasse() throws IOException {
		Scraper.scrape_fitIn_Kosten();
		Scraper.scrape_fitIn_Adresse_Ebertstrasse();
		Scraper.scrape_fitIn_Zeit_Ebertstrasse();
	}
	
	public static void update_fitIn_Durlach() throws IOException {
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
	
	
	public static void update_snapfit_karlstrasse() {
		Scraper.scrape_snapfit_Adresse_karlstrasse();
	}
	
	public static void update_snapfit_hagsfeld() {
		Scraper.scrape_snapfit_Adresse_hagsfeld();
	}
	
	public static void update_cleverfit() {
		Scraper.scrape_cleverfit_kosten();
		Scraper.scrape_cleverfit_Adresse();
		Scraper.scrape_cleverfit_zeit();
	}
	
	public static void update_fitpur() {
		Scraper.scrape_fitpur_kosten();
		Scraper.scrape_fitpur_Adresse();
		Scraper.scrape_fitpur_Zeit();
	}
	
	
	
	public static void update_sportprinz_sued() {
		Scraper.scrape_sportprinz_kosten();
		Scraper.scrape_sportprinz_adresse_sued();
		Scraper.scrape_sportprinz_Zeit_sued();
	}
	
	public static void update_sportprinz_west() {
		Scraper.scrape_sportprinz_kosten();
		Scraper.scrape_sportprinz_adresse_west();
		Scraper.scrape_sportprinz_Zeit_west();
		
	}
	
	public static void update_jonnyM() {
		Scraper.scrape_jonnyM_kosten();
		Scraper.scrape_jonnyM_adresse();
		Scraper.scrape_jonnyM_zeit();
	}
	
	
	public static void update_bulldog() {
		Scraper.scrape_bulldog_adresse();
		Scraper.scrape_bulldog_zeiten();
	}
	
	
	
	

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}
