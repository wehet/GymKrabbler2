package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {

	static WebClient client = new WebClient();

	// General Scraping method
	private static String scrapeWebsite(WebClient client, String link, String xPath) throws IOException {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		String el = null;

		HtmlPage page = client.getPage(link);

		HtmlElement element = ((HtmlElement) page.getFirstByXPath(xPath));
		el = element.asText();
		return el;
	}

	// FitIn Scraping

	public static String scrape_fitIn_Kosten() throws IOException {

		String el = scrapeWebsite(client, "https://fit-in.de/mitgliedschaft/",
				"//*[@id=\"Content\"]/div/div/div/div/div/div/div[9]/div[2]/div/div/div[2]/div/div/p[1]");
		return el;
	}

	public static String scrape_fitIn_Adresse_Kaiserstraße() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/kaiserstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");

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
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "KIDS");

		return el;
	}

	public static String scrape_fitIn_Zeit_Daimlerstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/daimlerstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "KIDS");
		return el;
	}

	public static String scrape_fitIn_Zeit_Ebertstrasse() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/ebertstrasse/",
				"//*[@id=\"Content\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "KIDS");
		return el;
	}

	public static String scrape_fitIn_Zeit_Durlach() throws IOException {
		// NLP
		String el = scrapeWebsite(client, "https://fit-in.de/club/durlach/",
				"//*[@id=\\\"Content\\\"]/div/div/div[2]/div/div[4]/div[2]");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el, "ÖFFNUNGSZEITEN", "KIDS");
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
				"//*[@id=\"tab_oeffnungszeiten-02.11.2020\"]/div/div/div/table/tbody");
		GymParser gymParser = new GymParser();
		el = gymParser.getTokens(el);
		return el;
	}

	// Venice Beach Scraping

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

	public static String scrape_dieBasis_Zeit() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.gelbeseiten.de/gsbiz/b3ef6479-31e7-44f8-9dbe-27f75db9e777");

			HtmlElement element = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"oeffnungszeiten\"]/div/div/div/table/tbody"));
			el = element.asText();

			GymParser gymParser = new GymParser();
			el = gymParser.getTokensFromStart(el, "unterschiedliche");

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}

	// Snapfit scraping

	// oeffnungszeiten und kosten fehlen

	public static String scrape_snapfit_Adresse_karlstrasse() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://snap-fit.de/location/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("/html/body/div[9]/div[1]/p[2]"));
			el = element.asText();

			GymParser gymParser = new GymParser();
			el = gymParser.getTokens(el, "Karlstraße", "0721");

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	public static String scrape_snapfit_Adresse_hagsfeld() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://snap-fit.de/location/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("/html/body/div[9]/div[3]/p[2]"));
			el = element.asText();

			GymParser gymParser = new GymParser();
			el = gymParser.getTokens(el, "Hagsfeld", "0721");

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}
	// Scrape Clever Fit

	public static String scrape_cleverfit_kosten() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client
					.getPage("https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/#price");

			HtmlElement element = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"s-prices-container\"]/div[2]/section/div/div[3]/div[1]/div[2]/p"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	public static String scrape_cleverfit_Adresse() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String adresse = null;
		try {
			HtmlPage page = client
					.getPage("https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/#price");

			HtmlElement element2 = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"s-additional-container\"]/div/section/div/div/div/div/div[1]/div/p[2]"));
			adresse = element2.asText();

			GymParser gymParser = new GymParser();
			adresse = gymParser.getTokens(adresse);

			return adresse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return adresse;

	}

	public static String scrape_cleverfit_zeit() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client
					.getPage("https://www.clever-fit.com/de-de/fitnessstudio-in-der-naehe/clever-fit-karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"contact-info\"]/div[2]/div[3]"));
			el = element.asText();

			GymParser gymParser = new GymParser();
			el = gymParser.getTokensFromBehind(el, "Öffnungszeiten");

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	// Scrape Active fit SEITE GEHT NICHT

//	public static String activeFit_adresse() {
//		//NLP
//		client.getOptions().setCssEnabled(false);
//		client.getOptions().setJavaScriptEnabled(false);
//
//		String el = null;
//		try {
//			HtmlPage page = client.getPage("https://www.activ-fitness-deutschland.de/karlsruhe.html");
//
//			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"footer\"]/div[1]/div[1]/p"));
//			el = element.asText();
//
//			return el;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//		return el;
//
//	}

	// Scrape Fitpur

	public static String scrape_fitpur_kosten() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.fit-pur.eu/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"content\"]/div/div/div/section[8]/div[2]/div/div[3]/div/div/div[2]/div"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	public static String scrape_fitpur_Adresse() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String adresse = null;
		String help = "";
		try {
			HtmlPage page = client.getPage("https://www.fit-pur.eu/karlsruhe/");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"content\"]/div/div/div/section[9]/div/div/div/div/div/section/div/div/div[1]/div/div/div[2]/div/div"));
			adresse = element1.asText();

			GymParser gymParser = new GymParser();
			help = gymParser.getTokens(adresse, "Karlsruhe", "Tel");
			help = help + gymParser.getTokens(adresse, "663", "karlsruhe@fit-pur");
			adresse = help;

			return adresse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return adresse;

	}

	public static String scrape_fitpur_Zeit() {
		// NLP
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;
		try {
			HtmlPage page = client.getPage("https://www.fit-pur.eu/karlsruhe/");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"content\"]/div/div/div/section[9]/div/div/div/div/div/section/div/div/div[1]/div/div/div[2]/div/div"));
			zeit = element1.asText();

			GymParser gymParser = new GymParser();
			zeit = gymParser.getTokensFromBehind(zeit, "!");

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

	// Scrape Sportprinz

	public static String scrape_sportprinz_kosten() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.sportprinz-fitness.de/preise/");

			HtmlElement element = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"Wrapper\"]/div[2]/div/div/section/div[2]/div/div/div/div/section[1]/div/div/div[1]/div/div/div/div/div/div[2]"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	public static String scrape_sportprinz_adresse_west() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.sportprinz-fitness.de/karlsruhe-west");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"studio\"]/article/div/div[2]/p[21]"));
			el = element.asText();

			GymParser gymParser = new GymParser();
			el = gymParser.getTokensFromBehind(el, "WEST");

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;

	}

	public static String scrape_sportprinz_adresse_sued() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String adresse = null;
		try {
			HtmlPage page = client.getPage("https://www.sportprinz-fitness.de/karlsruhe-sued");

			HtmlElement element2 = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"studio\"]/article/div/div[2]/div[4]"));
			adresse = element2.asText();

			GymParser gymParser = new GymParser();
			adresse = gymParser.getTokens(adresse);

			return adresse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return adresse;

	}

	public static String scrape_sportprinz_Zeit_west() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;

		try {
			HtmlPage page = client.getPage("https://www.sportprinz-fitness.de/karlsruhe-west");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath("//*[@id=\"studio\"]/article/div/div[2]/div"));
			zeit = element1.asText();

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

	public static String scrape_sportprinz_Zeit_sued() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;

		try {
			HtmlPage page = client.getPage("https://www.sportprinz-fitness.de/karlsruhe-sued");

			HtmlElement element1 = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"studio\"]/article/div/div[2]/div[1]"));
			zeit = element1.asText();

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

// Scrape Jonny M

	public static String scrape_jonnyM_kosten() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;

		try {
			HtmlPage page = client.getPage("https://jonny-m.de/preise/#blue-label");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath("//*[@id=\"blue-label\"]/div[1]/div/p[2]/span"));
			zeit = element1.asText();

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

	public static String scrape_jonnyM_adresse() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String adresse = null;

		try {
			HtmlPage page = client.getPage("https://jonny-m.de/clubs/karlsruhe/");

			HtmlElement element1 = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"post-32544\"]/div/div/div/div[6]/div[2]/div[2]/div[1]/div/p[1]"));
			adresse = element1.asText();
			GymParser gymParser = new GymParser();
			adresse = gymParser.getTokensFromBehind(adresse, "Europaplatz");

			return adresse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return adresse;

	}

	public static String scrape_jonnyM_zeit() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;

		try {
			HtmlPage page = client.getPage("https://jonny-m.de/clubs/karlsruhe/");

			HtmlElement element1 = ((HtmlElement) page
					.getFirstByXPath("//*[@id=\"post-32544\"]/div/div/div/div[6]/div[2]/div[2]/div[2]"));
			zeit = element1.asText();

			GymParser gymParser = new GymParser();
			zeit = gymParser.getTokensFromBehind(zeit, "Öffnungszeiten");

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

//Bulldog gym#

	public static String scrape_bulldog_adresse() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;
		String help = "";

		try {
			HtmlPage page = client.getPage("https://bulldog-gym.com/");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"offnungszeiten\"]/div[2]/div/div/div/div/section[1]/div/div/div/div/div/div[2]/div/div/p"));
			zeit = element1.asText();

			GymParser gymParser = new GymParser();
			help = gymParser.getTokens(zeit, ">", "|");
			help = help + gymParser.getTokens(zeit, "|", "<");
			zeit = help;

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

	public static String scrape_bulldog_zeiten() {

		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String zeit = null;

		try {
			HtmlPage page = client.getPage("https://bulldog-gym.com/");

			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"offnungszeiten\"]/div[2]/div/div/div/div/section[1]/div/div/div/div/div/div[3]"));
			zeit = element1.asText();

			return zeit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return zeit;

	}

	public static void main(String[] args) throws IOException {
		System.out.println(scrape_bulldog_adresse());

	

	}

}
