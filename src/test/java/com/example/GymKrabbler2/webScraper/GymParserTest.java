package com.example.GymKrabbler2.webScraper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.*;


public class GymParserTest {
	@Test
	//NLP in GymParser überprüfen
	void tokenTest() throws IOException {
		GymParser gymParser = new GymParser();
		String gesamt, start, end;
		//Beispieltext (String)
		gesamt = "Kaiserstraße 94 a \r\n" + " 76133 Karlsruhe\r\n" + " Tel.: 0721 – 663 37 37\r\n" + "\r\n"
				+ " ÖFFNUNGSZEITEN\r\n" + "\r\n" + " Mo - Fr: 06.00 Uhr – 23.00 Uhr\r\n"
				+ " Sa - So: 08.00 Uhr – 22.00 Uhr\r\n" + "\r\n" + " KIDS CLUB\r\n" + "\r\n"
				+ " Mo + Mi + Fr: 09.00 Uhr – 12.00 Uhr\r\n" + " Di + Do: 17.00 Uhr – 20.00 Uhr\r\n"
				+ " So: 10.00 Uhr – 13.00 Uhr\r\n" + "\r\n" + " Noch mehr Fitness, noch mehr Fit-in!\r\n"
				+ " Ab sofort jeden Feiertag von 09.00 - 20.00 Uhr geöffnet.\r\n"
				+ " (ohne Kinderbetreuung und Kurse)\r\n" + "\r\n" + " Vorübergehend geschlossen";
		start = null;
		end = "ÖFFNUNGSZEITEN";
		
		String result = gymParser.getTokens(gesamt, start, end);
		assertEquals("Kaiserstraße 94 a 76133 Karlsruhe Tel. : 0721 – 663 37 37 ",result);
	}
	
}
