package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;
import java.net.MalformedURLException;

import com.example.GymKrabbler2.webCrawler.exceptions.ScrapeException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {

	static WebClient client = new WebClient();

	// General Scraping method
	private static String scrapeWebsite(WebClient client, String link, String xPath) {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		String el = null;

		HtmlPage page = null;
		try {
			page = client.getPage(link);
			HtmlElement element = ((HtmlElement) page.getFirstByXPath(xPath));
			el = element.asText();
			return el;
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			return "Fehler";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return "Fehler";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Fehler";
		} catch (NullPointerException e) {
			return "Fehler";
		}
	}

	// FitIn Scraping

	public static String scrape_fitIn_Email() throws IOException {
		String el = scrapeWebsite(client, "https://fit-in.de/impressum/",
				"//*[@id=\"Content\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div/p[1]/a[2]");
		return el;
	}

	public static String scrape_fitIn_Kosten() throws IOException {

		String el = scrapeWebsite(client, "https://fit-in.de/mitgliedschaft/",
				"//*[@id=\"Content\"]/div/div/div/div/div/div/div[9]/div[2]/div/div/div[2]/div/div/p[1]");
		return el;
	}

	public static String scrape_fitIn_Adresse_Kaiserstraße() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/kaiserstrasse/",
				"//*[@id=\\\"Content\\\"]/div/div/div[2]/div/div[4]/div[2]");
		if(el=="Fehler") {
			throw new IOException("FitIn Adresse konnte nicht gescraped werden.");
		}
		
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "Tel.");
		return el;

	}

	public static String scrape_fitIn_Adresse_Daimlerstrasse() throws IOException {
		// NLP

		String el = scrapeWebsite(client, "https://fit-in.de/club/daimlerstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");

		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "Tel.");

		return el;

	}

	public static String scrape_fitIn_Adresse_Ebertstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/ebertstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "Tel.");

		return el;

	}

	// TODO
	public static String scrape_fitIn_Adresse_Durlach() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/durlach/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "Tel.");
		return el;

	}

	// TODO
	public static String scrape_fitIn_Adresse_Blankenloch() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/blankenloch/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "Tel.");

		return el;
	}

	public static String scrape_fitIn_Zeit_Kaiserstraße() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/kaiserstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "Noch");

		return el;
	}

	public static String scrape_fitIn_Zeit_Daimlerstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/daimlerstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "Noch");
		return el;
	}

	public static String scrape_fitIn_Zeit_Ebertstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/ebertstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "Noch");
		return el;
	}

	public static String scrape_fitIn_Zeit_Durlach() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/durlach/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "Noch");
		return el;

	}

	public static String scrape_fitIn_Zeit_Blankenloch() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/blankenloch/",
				"//*[@id=\\\"Content\\\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "KIDS");
		return el;

	}

	// Pfitzenmeier Scraping

	public static String scrape_pfitzenmeier_Email() throws IOException {
		String el = scrapeWebsite(client, "https://www.pfitzenmeier.de/impressum/",
				"//*[@id=\"pos_2\"]/div/div/div/div/div/div[1]/div[6]/div/div/p[1]/a");

		return el;
	}

//	public static String scrape_pfitzenmeier_Bewertung() throws IOException {
//		String el = scrapeWebsite(client,
//				"https://www.kununu.com/de/unternehmensgruppe-pfitzenmeier-pfitzenmeier-resorts-clubs/kommentare",
//				"//*[@id=\"__next\"]/div/main/div/div[4]/div/article[1]/div/div/span/span[1]/span[2]");
//
//		return el;
//	}

	public static String scrape_pfitzenmeier_Kosten() throws IOException {
		String el = scrapeWebsite(client, "https://www.pfitzenmeier.de/karlsruhe/",
				"//*[@id=\"tab_6767_30bis65\"]/div[1]/table/tbody/tr[1]/td[1]/span");
		return el;
	}

	public static String scrape_pfitzenmeier_Adresse() throws IOException {
		String el = scrapeWebsite(client, "https://www.pfitzenmeier.de/karlsruhe/", "//*[@id=\"collapseAddress\"]/div");
		return el;
	}

	public static String scrape_pfitzenmeier_Zeit() throws IOException {
		String el = scrapeWebsite(client, "https://www.pfitzenmeier.de/karlsruhe/",
				"//*[@id=\"tab_oeffnungszeiten\"]/div/div/div/table/tbody");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el);
		return el;
	}

	// Venice Beach Scraping

	public static String scrape_veniceBeach_Email() throws IOException {

		String el = scrapeWebsite(client, "https://www.venicebeach-fitness.de/service/impressum.html",
				"//*[@id=\"footer\"]/div/div/div[1]/div/div[2]/p/a");
		return el;
	}

//	public static String scrape_veniceBeach_Bewertung() throws IOException {
//
//		String el = scrapeWebsite(client,
//				"https://www.venicebeach-fitness.de/service/impressum.html",
//				"//*[@id=\"footer\"]/div/div/div[1]/div/div[2]/p/a");
//		return el;
//	}

	public static String scrape_veniceBeach_Kosten_postgalerie() throws IOException {
		String el = scrapeWebsite(client,
				"https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/",
				"//*[@id=\"tab-8-1\"]/div/div/div/div/ul/li[1]/strong");
		return el;
	}

	public static String scrape_veniceBeach_Adresse_postgalerie() throws IOException {
		String el = scrapeWebsite(client,
				"https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/",
				"//*[@id=\"kontakt\"]/div/p[1]");
		return el;
	}

	public static String scrape_veniceBeach_Zeit_postgalerie() throws IOException {
		// NLP
		String el = scrapeWebsite(client,
				"https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/",
				"//*[@id=\"pane_276\"]/div[1]/table/tbody");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromStart(el, "An");
		return el;
	}

	public static String scrape_veniceBeach_Kosten_suedstadt() throws IOException {
		String el = scrapeWebsite(client, "https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/",
				"//*[@id=\"tab-8-1\"]/div/div/div/div/ul/li[1]/strong");
		return el;
	}

	public static String scrape_veniceBeach_Adresse_suedstadt() throws IOException {
		String el = scrapeWebsite(client, "https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/",
				"//*[@id=\"kontakt\"]/div/p[1]");
		return el;
	}

	public static String scrape_veniceBeach_Zeit_suedstadt() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/",
				"//*[@id=\"pane_413\"]/div/table/tbody");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el);
		return el;
	}

	// DIe Basis

	public static String scrape_dieBasis_Email() throws IOException {
		String el = scrapeWebsite(client, "https://basis-karlsruhe.de/impressum/",
				"//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[8]");

		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, ":");

		return el;
	}

	public static String scrape_dieBasis_Kosten() throws IOException {
		String el = scrapeWebsite(client, "https://basis-karlsruhe.de/membership/",
				"//*[@id=\"content\"]/section[4]/div/div/div[1]/div/div/div/div/div[3]/p");
		return el;
	}

	public static String scrape_dieBasis_Adresse() throws IOException {
		String strasse = null;
		String plz = null;
		strasse = scrapeWebsite(client, "https://basis-karlsruhe.de/impressum/",
				"//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[2]");
		plz = scrapeWebsite(client, "https://basis-karlsruhe.de/impressum/",
				"//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[3]");
		return strasse + " " + plz;
	}

	public static String scrape_dieBasis_Zeit() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://finde-offen.de/karlsruhe/basis-karlsruhe-crossfit-karlsruhe-569669",
				"//*[@id=\"block-system-main\"]/div/div/div/div[2]/div/div[3]/div[1]/div/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div/div");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, "28.05.2021");
		return el;
	}

	// Snapfit scraping

	// oeffnungszeiten und kosten fehlen

	public static String scrape_snapfit_Email() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://snap-fit.de/impressum/", "/html/body/div[5]/div/div[2]/p[3]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokens(el, ":", "Geschäftsführung");
		return el;
	}

	public static String scrape_snapfit_Adresse_karlstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://snap-fit.de/location/", "/html/body/div[9]/div[1]/p[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "Karlstraße", "0721");
		return el;
	}

	public static String scrape_snapfit_Adresse_hagsfeld() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://snap-fit.de/location/", "/html/body/div[9]/div[3]/p[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "Hagsfeld", "0721");
		return el;
	}

	// Scrape Clever Fit

	public static String scrape_cleverfit_Email() throws IOException {
		// NLP
		String el = scrapeWebsite(client,
				"https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/",
				"//*[@id=\"contact-info\"]/div[2]/div[2]/div[3]/a");

		return el;
	}

	public static String scrape_cleverfit_kosten() throws IOException {
		String el = scrapeWebsite(client,
				"https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/#price",
				"//*[@id=\"s-prices-container\"]/div[2]/section/div/div[3]/div[1]/div[2]/p");
		return el;
	}

	public static String scrape_cleverfit_Adresse() throws IOException {
		// NLP
		String adresse = scrapeWebsite(client,
				"https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/#price",
				"//*[@id=\"s-additional-container\"]/div/section/div/div/div/div/div[1]/div/p[2]");
		GymParser gymParser = new GymParser();
		adresse = gymParser.getTokens(adresse);
		return adresse;
	}

	public static String scrape_cleverfit_zeit() throws IOException {
		// NLP
		String el = scrapeWebsite(client,
				"https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/",
				"//*[@id=\"contact-info\"]/div[2]/div[3]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, "Öffnungszeiten");
		return el;
	}


	// Scrape Fitpur

	public static String scrape_fitpur_Email() throws IOException {
		String el = scrapeWebsite(client, "https://www.fit-pur.eu/impressum/",
				"//*[@id=\"content\"]/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div[3]/div/div/p[4]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokensFromBehind(el, ":");
		return el;
	}

	public static String scrape_fitpur_kosten() throws IOException {
		String el = scrapeWebsite(client, "https://www.fit-pur.eu/karlsruhe/",
				"//*[@id=\"content\"]/div/div/div/section[8]/div[2]/div/div[3]/div/div/div[2]/div");
		return el;
	}

	public static String scrape_fitpur_Adresse() throws IOException {
		// NLP
		String adresse = scrapeWebsite(client, "https://www.fit-pur.eu/karlsruhe/",
				"//*[@id=\"content\"]/div/div/div/section[9]/div/div/div/div/div/section/div/div/div[1]/div/div/div[2]/div/div");
		String help = "";
		GymParser gymParser = new GymParser();
		help = gymParser.getTokens(adresse, "Karlsruhe", "Tel");
		help = help + gymParser.getTokens(adresse, "663", "karlsruhe@fit-pur");
		adresse = help;
		return adresse;
	}

	public static String scrape_fitpur_Zeit() throws IOException {
		// NLP
		String zeit = scrapeWebsite(client, "https://www.fit-pur.eu/karlsruhe/",
				"//*[@id=\"content\"]/div/div/div/section[9]/div/div/div/div/div/section/div/div/div[1]/div/div/div[2]/div/div");
		GymParser gymParser = new GymParser();
		zeit = gymParser.getTokensFromBehind(zeit, "!");
		return zeit;
	}

	// Scrape Sportprinz

	public static String scrape_sportprinz_Email() throws IOException {
		String el = scrapeWebsite(client, "https://www.sportprinz-fitness.de/impressum/",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section[2]/div/div/div[1]/div/div/div/div/div/p[4]/span[1]/a/strong");
		return el;
	}

	public static String scrape_sportprinz_kosten() throws IOException {
		String el = scrapeWebsite(client, "https://www.sportprinz-fitness.de/preise/",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section/div[2]/div/div/div/div/section[1]/div/div/div[1]/div/div/div/div/div/div[2]");
		return el;
	}

	public static String scrape_sportprinz_adresse_west() throws IOException {
		String el = scrapeWebsite(client, "https://www.sportprinz-fitness.de/karlsruhe-west",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section[1]/div[2]/div/div/div/div/div[2]/div/h4");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, "|");
		return el;
	}

	public static String scrape_sportprinz_adresse_sued() throws IOException {
		String el = scrapeWebsite(client, "https://www.sportprinz-fitness.de/karlsruhe-sued",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section[1]/div[2]/div/div/div/div/div[2]/div/h4");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, "|");
		return el;
	}

	public static String scrape_sportprinz_Zeit_west() throws IOException {
		String zeit = scrapeWebsite(client, "https://www.sportprinz-fitness.de/karlsruhe-west",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section[6]/div/div/div[1]/div/div/div[2]/div/div/p");
		return zeit;
	}

	public static String scrape_sportprinz_Zeit_sued() throws IOException {
		String zeit = scrapeWebsite(client, "https://www.sportprinz-fitness.de/karlsruhe-sued",
				"//*[@id=\"Wrapper\"]/div[2]/div/div/section[6]/div/div/div[1]/div/div/div[2]/div/div/p");
		return zeit;
	}

// Scrape Jonny M

	public static String scrape_jonnyM_Email() throws IOException {
		String el = scrapeWebsite(client, "https://jonny-m.de/impressum",
				"//*[@id=\"post-32194\"]/div/div/div/div/div/div/div/div/p[6]/a");
		return el;
	}

	public static String scrape_jonnyM_kosten() throws IOException {
		String zeit = scrapeWebsite(client, "https://jonny-m.de/preise/#blue-label",
				"//*[@id=\"blue-label\"]/div[1]/div/p[2]/span");
		return zeit;
	}

	public static String scrape_jonnyM_adresse() throws IOException {
		String adresse = scrapeWebsite(client, "https://jonny-m.de/clubs/karlsruhe/",
				"//*[@id=\"post-32544\"]/div/div/div/div[6]/div[2]/div[2]/div[1]/div/p[1]");
		GymParser gymParser = new GymParser();
		adresse = gymParser.getTokensFromBehind(adresse, "Europaplatz");
		return adresse;
	}

	public static String scrape_jonnyM_zeit() throws IOException {
		String zeit = scrapeWebsite(client, "https://jonny-m.de/clubs/karlsruhe/",
				"//*[@id=\"post-32544\"]/div/div/div/div[6]/div[2]/div[2]/div[2]");
		GymParser gymParser = new GymParser();
		zeit = gymParser.getTokensFromBehind(zeit, "Öffnungszeiten");
		return zeit;
	}

//Bulldog gym#
	public static String scrape_bulldog_Email() throws IOException {
		String el = scrapeWebsite(client, "https://bulldog-gym.com/impressum/",
				"//*[@id=\"main\"]/div/div/div/section[2]/div/div/div/div/div/div[2]/div/div/p[3]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokensFromBehind(el, ":");
		el = gymParser.getTokens(el, ":", "Internet");
		return el;
	}

	
	public static String scrape_bulldog_adresse() throws IOException {
		String zeit = scrapeWebsite(client, "https://bulldog-gym.com/",
				"//*[@id=\"offnungszeiten\"]/div[2]/div/div/div/div/section[1]/div/div/div/div/div/div[2]/div/div/p");
		String help = "";
		GymParser gymParser = new GymParser();
		help = gymParser.getTokens(zeit, ">", "|");
		help = help + gymParser.getTokens(zeit, "|", "<");
		zeit = help;
		return zeit;
	}

	public static String scrape_bulldog_zeiten() throws IOException {
		String zeit = scrapeWebsite(client, "https://bulldog-gym.com/",
				"//*[@id=\"offnungszeiten\"]/div[2]/div/div/div/div/section[1]/div/div/div/div/div/div[3]");
		return zeit;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(scrape_dieBasis_Zeit());

	}

}
