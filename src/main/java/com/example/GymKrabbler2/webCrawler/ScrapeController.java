package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

public class ScrapeController {

	public static void update(int id) throws IOException {
		switch (id) {
		case 1:
			update_fitIn_Kaiserstrasse();
			break;
		case 2:
			update_fitIn_Daimlerstrasse();
			break;
		case 3:
			update_fitIn_Ebertstrasse();
			break;
		case 4:
			update_fitIn_Durlach();
			break;
		case 5:
			update_VeniceBeach_postgalerie();
			break;
		case 6:
			update_VeniceBeach_suedstadt();
			break;
		case 7:
			update_dieBasis();
			break;
		case 8:
			update_snapfit_karlstrasse();
			break;
		case 9:
			update_snapfit_hagsfeld();
			break;
		case 10:
			update_cleverfit();
			break;
		case 11:
			update_fitpur();
			break;
		case 12:
			update_sportprinz_sued();
			break;
		case 13:
			update_sportprinz_west();
			break;
		case 14:
			update_jonnyM();
			break;
		case 15:
			update_bulldog();
			break;
		}
		
		

	}
	
	public static void updateAll() throws IOException {
		update_fitIn_Kaiserstrasse();
		 update_fitIn_Kaiserstrasse();
		 update_fitIn_Ebertstrasse();
		 update_fitIn_Durlach();
		 update_Pfitzenmeier();
		 update_VeniceBeach_postgalerie();
		 update_VeniceBeach_suedstadt();
		 update_dieBasis();
		 update_snapfit_karlstrasse();
		 update_snapfit_hagsfeld();
		 update_cleverfit();
		 update_fitpur();
		 update_sportprinz_sued();
		 update_sportprinz_west();
		 update_jonnyM();
		 update_bulldog();
		 
		 
		 
		 
		 
		 
		
		
		
		
		
		
	}

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
