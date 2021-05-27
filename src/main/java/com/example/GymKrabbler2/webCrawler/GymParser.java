package com.example.GymKrabbler2.webCrawler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class GymParser {

	public GymParser() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTokens(String gesamt, String end) throws IOException {
		String result = "";
		InputStream inputStream = getClass().getResourceAsStream("/models/de-token.bin");
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(gesamt);
		
		int endInt = Arrays.asList(tokens).indexOf(end);
		
		for (int i=0; i < endInt; i++) {
			result = result + tokens[i] + " ";
		}
		
		return result;
	}
	
	public String getTokens(String gesamt, String start, String end) throws IOException {
		String result = "";
		InputStream inputStream = getClass().getResourceAsStream("/models/de-token.bin");
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(gesamt);
		
		int startInt = Arrays.asList(tokens).indexOf(start);
		int endInt = Arrays.asList(tokens).indexOf(end);
		
		for (int i=startInt +1; i < endInt; i++) {
			result = result + tokens[i] + " ";
		}
		
		return result;
	}
	
	public static void main (String args[]) throws IOException {
		GymParser gymParser = new GymParser();
		String result = gymParser.getTokens("Kaiserstraße 94 a \r\n"
				+ " 76133 Karlsruhe\r\n"
				+ " Tel.: 0721 – 663 37 37\r\n"
				+ "\r\n"
				+ " ÖFFNUNGSZEITEN\r\n"
				+ "\r\n"
				+ " Mo - Fr: 06.00 Uhr – 23.00 Uhr\r\n"
				+ " Sa - So: 08.00 Uhr – 22.00 Uhr\r\n"
				+ "\r\n"
				+ " KIDS CLUB\r\n"
				+ "\r\n"
				+ " Mo + Mi + Fr: 09.00 Uhr – 12.00 Uhr\r\n"
				+ " Di + Do: 17.00 Uhr – 20.00 Uhr\r\n"
				+ " So: 10.00 Uhr – 13.00 Uhr\r\n"
				+ "\r\n"
				+ " Noch mehr Fitness, noch mehr Fit-in!\r\n"
				+ " Ab sofort jeden Feiertag von 09.00 - 20.00 Uhr geöffnet.\r\n"
				+ " (ohne Kinderbetreuung und Kurse)\r\n"
				+ "\r\n"
				+ " Vorübergehend geschlossen", "ÖFFNUNGSZEITEN");
		
		System.out.println(result);
	}

}
