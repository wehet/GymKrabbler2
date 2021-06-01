package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;

import com.example.GymKrabbler2.model.Gym;

public class ScrapeController {

	public static void update(Gym gym) throws IOException {

		switch ((int) gym.getId()) {
		case 1:
			update_fitIn_Kaiserstrasse(gym);
			break;
		case 2:
			update_fitIn_Daimlerstrasse(gym);
			break;
		case 3:
			update_fitIn_Ebertstrasse(gym);
			break;
		case 4:
			update_fitIn_Durlach(gym);
			break;

		case 5:
			update_Pfitzenmeier(gym);
			break;
		case 6:
			update_VeniceBeach_postgalerie(gym);
			break;
		case 7:
			update_VeniceBeach_suedstadt(gym);
			break;
		case 8:
			update_dieBasis(gym);
			break;
		case 9:
			update_snapfit_karlstrasse(gym);
			break;
		case 10:
			update_snapfit_hagsfeld(gym);
			break;
		case 11:
			update_cleverfit(gym);
			break;
		case 12:
			update_fitpur(gym);
			break;
		case 13:
			update_sportprinz_sued(gym);
			break;
		case 14:
			update_sportprinz_west(gym);
			break;
		case 15:
			update_jonnyM(gym);
			break;
		case 16:
			update_bulldog(gym);
			break;
		}

	}

	public static void updateAll(Gym gym) throws IOException {
		update_fitIn_Kaiserstrasse(gym);
		update_fitIn_Kaiserstrasse(gym);
		update_fitIn_Ebertstrasse(gym);
		update_fitIn_Durlach(gym);
		update_Pfitzenmeier(gym);
		update_VeniceBeach_postgalerie(gym);
		update_VeniceBeach_suedstadt(gym);
		update_dieBasis(gym);
		update_snapfit_karlstrasse(gym);
		update_snapfit_hagsfeld(gym);
		update_cleverfit(gym);
		update_fitpur(gym);
		update_sportprinz_sued(gym);
		update_sportprinz_west(gym);
		update_jonnyM(gym);
		update_bulldog(gym);

	}

	private static void update_fitIn_Kaiserstrasse(Gym gym) throws IOException {

		String kosten = Scraper.scrape_fitIn_Kosten();
		String adresse = Scraper.scrape_fitIn_Adresse_Kaiserstraße();
		String zeit = Scraper.scrape_fitIn_Zeit_Kaiserstraße();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);
	}

	private static void update_fitIn_Daimlerstrasse(Gym gym) throws IOException {
		String kosten = Scraper.scrape_fitIn_Kosten();
		String adresse = Scraper.scrape_fitIn_Adresse_Daimlerstrasse();
		String zeit = Scraper.scrape_fitIn_Zeit_Daimlerstrasse();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_fitIn_Ebertstrasse(Gym gym) throws IOException {

		String kosten = Scraper.scrape_fitIn_Kosten();
		String adresse = Scraper.scrape_fitIn_Adresse_Ebertstrasse();
		String zeit = Scraper.scrape_fitIn_Zeit_Ebertstrasse();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);
	}

	private static void update_fitIn_Durlach(Gym gym) throws IOException {

		String kosten = Scraper.scrape_fitIn_Kosten();
		String adresse = Scraper.scrape_fitIn_Adresse_Durlach();
		String zeit = Scraper.scrape_fitIn_Zeit_Durlach();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_Pfitzenmeier(Gym gym) throws IOException {

		String kosten = Scraper.scrape_pfitzenmeier_Kosten();
		String adresse = Scraper.scrape_pfitzenmeier_Adresse();
		String zeit = Scraper.scrape_pfitzenmeier_Zeit();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_VeniceBeach_postgalerie(Gym gym) throws IOException {

		String kosten = Scraper.scrape_veniceBeach_Kosten_postgalerie();
		String adresse = Scraper.scrape_veniceBeach_Adresse_postgalerie();
		String zeit = Scraper.scrape_veniceBeach_Zeit_postgalerie();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_VeniceBeach_suedstadt(Gym gym) throws IOException {

		String kosten = Scraper.scrape_veniceBeach_Kosten_suedstadt();
		String adresse = Scraper.scrape_veniceBeach_Adresse_suedstadt();
		String zeit = Scraper.scrape_veniceBeach_Zeit_suedstadt();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_dieBasis(Gym gym) throws IOException {
		String kosten = Scraper.scrape_dieBasis_Kosten();
		String adresse = Scraper.scrape_dieBasis_Adresse();
		String zeit = Scraper.scrape_dieBasis_Zeit();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_snapfit_karlstrasse(Gym gym) {
		String adresse = Scraper.scrape_snapfit_Adresse_karlstrasse();

		gym.setAdresse(adresse);

	}

	private static void update_snapfit_hagsfeld(Gym gym) {
		String adresse = Scraper.scrape_snapfit_Adresse_hagsfeld();

		gym.setAdresse(adresse);

	}

	private static void update_cleverfit(Gym gym) {
		String kosten = Scraper.scrape_cleverfit_kosten();
		String adresse = Scraper.scrape_cleverfit_Adresse();
		String zeit = Scraper.scrape_cleverfit_zeit();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_fitpur(Gym gym) {
		String kosten = Scraper.scrape_fitpur_kosten();
		String adresse = Scraper.scrape_fitpur_Adresse();
		String zeit = Scraper.scrape_fitpur_Zeit();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_sportprinz_sued(Gym gym) {
		String kosten = Scraper.scrape_sportprinz_kosten();
		String adresse = Scraper.scrape_sportprinz_adresse_sued();
		String zeit = Scraper.scrape_sportprinz_Zeit_sued();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_sportprinz_west(Gym gym) {
		String kosten = Scraper.scrape_sportprinz_kosten();
		String adresse = Scraper.scrape_sportprinz_adresse_west();
		String zeit = Scraper.scrape_sportprinz_Zeit_west();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_jonnyM(Gym gym) {
		String kosten = Scraper.scrape_jonnyM_kosten();
		String adresse = Scraper.scrape_jonnyM_adresse();
		String zeit = Scraper.scrape_jonnyM_zeit();

		gym.setAdresse(adresse);
		gym.setPreis(kosten);
		gym.setZeiten(zeit);

	}

	private static void update_bulldog(Gym gym) {
		String adresse = Scraper.scrape_bulldog_adresse();
		String zeit = Scraper.scrape_bulldog_zeiten();

		gym.setAdresse(adresse);
		gym.setZeiten(zeit);

	}

}
