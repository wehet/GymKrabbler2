package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

import com.example.GymKrabbler2.model.Gym;

public class ScrapeController {

//	public static void update(Gym gym) throws IOException {
//
//		switch ((int) gym.getId()) {
//		case 1:
//			update_fitIn_Kaiserstrasse(gym);
//			break;
//		case 2:
//			update_fitIn_Daimlerstrasse(gym);
//			break;
//		case 3:
//			update_fitIn_Ebertstrasse(gym);
//			break;
//		case 4:
//			update_fitIn_Durlach(gym);
//			break;
//
//		case 5:
//			update_Pfitzenmeier(gym);
//			break;
//		case 6:
//			update_VeniceBeach_postgalerie(gym);
//			break;
//		case 7:
//			update_VeniceBeach_suedstadt(gym);
//			break;
//		case 8:
//			update_dieBasis(gym);
//			break;
//		case 9:
//			update_snapfit_karlstrasse(gym);
//			break;
//		case 10:
//			update_snapfit_hagsfeld(gym);
//			break;
//		case 11:
//			update_cleverfit(gym);
//			break;
//		case 12:
//			update_fitpur(gym);
//			break;
//		case 13:
//			update_sportprinz_sued(gym);
//			break;
//		case 14:
//			update_sportprinz_west(gym);
//			break;
//		case 15:
//			update_jonnyM(gym);
//			break;
//		case 16:
//			update_bulldog(gym);
//			break;
//		}
//
//	}
//
//	public static void update_fitIn_Kaiserstrasse(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_fitIn_Kosten();
//		String adresse = Scraper.scrape_fitIn_Adresse_Kaiserstraße();
//		String zeit = Scraper.scrape_fitIn_Zeit_Kaiserstraße();
//		String email = Scraper.scrape_fitIn_Email();
//	
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//	}
//
//	public static void update_fitIn_Daimlerstrasse(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_fitIn_Kosten();
//		String adresse = Scraper.scrape_fitIn_Adresse_Daimlerstrasse();
//		String zeit = Scraper.scrape_fitIn_Zeit_Daimlerstrasse();
//		String email = Scraper.scrape_fitIn_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_fitIn_Ebertstrasse(Gym gym) throws IOException {
//
//		String kosten = Scraper.scrape_fitIn_Kosten();
//		String adresse = Scraper.scrape_fitIn_Adresse_Ebertstrasse();
//		String zeit = Scraper.scrape_fitIn_Zeit_Ebertstrasse();
//		String email = Scraper.scrape_fitIn_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//	}
//
//	public static void update_fitIn_Durlach(Gym gym) throws IOException {
//
//		String kosten = Scraper.scrape_fitIn_Kosten();
//		String adresse = Scraper.scrape_fitIn_Adresse_Durlach();
//		String zeit = Scraper.scrape_fitIn_Zeit_Durlach();
//		String email = Scraper.scrape_fitIn_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_Pfitzenmeier(Gym gym) throws IOException {
//
//		String kosten = Scraper.scrape_pfitzenmeier_Kosten();
//		String adresse = Scraper.scrape_pfitzenmeier_Adresse();
//		String zeit = Scraper.scrape_pfitzenmeier_Zeit();
//		String email = Scraper.scrape_pfitzenmeier_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_VeniceBeach_postgalerie(Gym gym) throws IOException {
//
//		String kosten = Scraper.scrape_veniceBeach_Kosten_postgalerie();
//		String adresse = Scraper.scrape_veniceBeach_Adresse_postgalerie();
//		String zeit = Scraper.scrape_veniceBeach_Zeit_postgalerie();
//		String email = Scraper.scrape_veniceBeach_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_VeniceBeach_suedstadt(Gym gym) throws IOException {
//
//		String kosten = Scraper.scrape_veniceBeach_Kosten_suedstadt();
//		String adresse = Scraper.scrape_veniceBeach_Adresse_suedstadt();
//		String zeit = Scraper.scrape_veniceBeach_Zeit_suedstadt();
//		String email = Scraper.scrape_veniceBeach_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_dieBasis(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_dieBasis_Kosten();
//		String adresse = Scraper.scrape_dieBasis_Adresse();
//		String zeit = Scraper.scrape_dieBasis_Zeit();
//		String email = Scraper.scrape_dieBasis_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_snapfit_karlstrasse(Gym gym) throws IOException {
//		String adresse = Scraper.scrape_snapfit_Adresse_karlstrasse();
//		String email = Scraper.scrape_snapfit_Email();
//
//		gym.setAdresse(adresse);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_snapfit_hagsfeld(Gym gym) throws IOException {
//		String adresse = Scraper.scrape_snapfit_Adresse_hagsfeld();
//		String email = Scraper.scrape_snapfit_Email();
//
//		gym.setAdresse(adresse);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_cleverfit(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_cleverfit_kosten();
//		String adresse = Scraper.scrape_cleverfit_Adresse();
//		String zeit = Scraper.scrape_cleverfit_zeit();
//		String email = Scraper.scrape_cleverfit_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_fitpur(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_fitpur_kosten();
//		String adresse = Scraper.scrape_fitpur_Adresse();
//		String zeit = Scraper.scrape_fitpur_Zeit();
//		String email = Scraper.scrape_fitpur_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_sportprinz_sued(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_sportprinz_kosten();
//		String adresse = Scraper.scrape_sportprinz_adresse_sued();
//		String zeit = Scraper.scrape_sportprinz_Zeit_sued();
//		String email = Scraper.scrape_sportprinz_Email();
//		
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_sportprinz_west(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_sportprinz_kosten();
//		String adresse = Scraper.scrape_sportprinz_adresse_west();
//		String zeit = Scraper.scrape_sportprinz_Zeit_west();
//		String email = Scraper.scrape_sportprinz_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_jonnyM(Gym gym) throws IOException {
//		String kosten = Scraper.scrape_jonnyM_kosten();
//		String adresse = Scraper.scrape_jonnyM_adresse();
//		String zeit = Scraper.scrape_jonnyM_zeit();
//		String email = Scraper.scrape_jonnyM_Email();
//
//		gym.setAdresse(adresse);
//		gym.setPreis(kosten);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}
//
//	public static void update_bulldog(Gym gym) throws IOException {
//		String adresse = Scraper.scrape_bulldog_adresse();
//		String zeit = Scraper.scrape_bulldog_zeiten();
//		String email = Scraper.scrape_bulldog_Email();
//
//		gym.setAdresse(adresse);
//		gym.setZeiten(zeit);
//		gym.setEmail(email);
//
//	}

}
