package com.example.GymKrabbler2.webScraper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class GymParser {

	public GymParser() {
		// TODO Auto-generated constructor stub
	}

	public String getTokens(String gesamt, String start, String end) throws IOException {
		String result = "";
		InputStream inputStream = getClass().getResourceAsStream("/models/de-token.bin");
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(gesamt);
		int startInt;
		int endInt;
		String help = null;

		startInt = Arrays.asList(tokens).indexOf(start) + 1;
		endInt = Arrays.asList(tokens).indexOf(end);

		if (endInt == -1)
			endInt = tokens.length;

		for (int i = startInt; i < endInt; i++) {
			// Ggf. ausgliedern
			if (tokens[i].indexOf("00") != -1) {
				help = tokens[i].substring(0, tokens[i].indexOf("00") + 2) + " "
						+ tokens[i].substring(tokens[i].indexOf("00") + 2);
				tokens[i] = help;
			}

			result = result + tokens[i] + " ";

		}

		return result;
	}

}
