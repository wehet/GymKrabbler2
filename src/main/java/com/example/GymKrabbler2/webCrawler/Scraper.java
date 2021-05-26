package com.example.GymKrabbler2.webCrawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {
	
	static WebClient client = new WebClient();

	
	
	
	//FitIn Scraping
	
	public static String scrape_fitIn_Kosten() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://fit-in.de/mitgliedschaft/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath(
					"//*[@id=\"Content\"]/div/div/div/div/div/div/div[9]/div[2]/div/div/div[2]/div/div/p[1]"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_fitIn_Adresse_Kaiserstraße() {
		return "";
			
	}
	
	public static String scrape_fitIn_Adresse_Daimlerstrasse() {
		return "";
			
	}
	public static String scrape_fitIn_Adresse_Ebertstrasse() {
		return "";
			
	}
	public static String scrape_fitIn_Adresse_Durlach() {
		return "";
			
	}
	public static String scrape_fitIn_Adresse_Blankenloch() {
		return "";
			
	}
	
	public static String scrape_fitIn_Zeit_Kaiserstraße() {
		return "";
			
	}
	
	public static String scrape_fitIn_Zeit_Daimlerstrasse() {
		return "";
			
	}
	public static String scrape_fitIn_Zeit_Ebertstrasse() {
		return "";
			
	}
	public static String scrape_fitIn_Zeit_Durlach() {
		return "";
			
	}
	public static String scrape_fitIn_Zeit_Blankenloch() {
		return "";	
	}
	
	
	
	//Pfitzenmeier Scraping
	
	public static String scrape_pfitzenmeier_Kosten() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.pfitzenmeier.de/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"tab_6767_30bis65\"]/div[1]/table/tbody/tr[1]/td[1]/span"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_pfitzenmeier_Adresse() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.pfitzenmeier.de/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"collapseAddress\"]/div"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_pfitzenmeier_Zeit() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.pfitzenmeier.de/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"tab_oeffnungszeiten-02.11.2020\"]/div/div/div/table/tbody"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	
	
	
	
	//Venice Beach Scraping
	
	public static String scrape_veniceBeach_Kosten_postgalerie() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"tab-8-1\"]/div/div/div/div/ul/li[1]/strong"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	
	
	public static String scrape_veniceBeach_Adresse_postgalerie() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"kontakt\"]/div/p[1]"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_veniceBeach_Zeit_postgalerie() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/premium-fitness/karlsruhe-postgalerie/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"pane_276\"]/div[1]/table/tbody"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_veniceBeach_Kosten_suedstadt() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"tab-8-1\"]/div/div/div/div/ul/li[1]/strong"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	public static String scrape_veniceBeach_Adresse_suedstadt() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"kontakt\"]/div/p[1]"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	
	public static String scrape_veniceBeach_Zeit_suedstadt() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.venicebeach-fitness.de/clubs/lifestyle-fitness-plus/karlsruhe/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"pane_413\"]/div/table/tbody"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	
	//DIe Basis
	
	public static String scrape_dieBasis_Adresse() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String name = null;
		String strasse = null;
		String plz = null;
		try {
			HtmlPage page = client.getPage("https://basis-karlsruhe.de/impressum/");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[1]"));
			name = element.asText();
			HtmlElement element1 = ((HtmlElement) page.getFirstByXPath("//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[2]"));
			strasse = element1.asText();
			HtmlElement element2 = ((HtmlElement) page.getFirstByXPath("//*[@id=\"content\"]/section/div/div/div/div/div/div/div[2]/div/p[3]"));
			plz = element2.asText();
			
			
			return name + " " + strasse + " " + plz;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return name;
	}
	
	
	public static String scrape_dieBasis_Zeit() {
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		String el = null;
		try {
			HtmlPage page = client.getPage("https://www.gelbeseiten.de/gsbiz/b3ef6479-31e7-44f8-9dbe-27f75db9e777");

			HtmlElement element = ((HtmlElement) page.getFirstByXPath("//*[@id=\"oeffnungszeiten\"]/div/div/div/table/tbody"));
			el = element.asText();

			return el;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return el;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		System.out.print(scrape_dieBasis_Zeit());

	}
	
	
	
	
	
	

}
