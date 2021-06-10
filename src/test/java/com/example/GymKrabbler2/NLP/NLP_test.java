package com.example.GymKrabbler2.NLP;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.GymKrabbler2.webCrawler.Scraper;

import static org.junit.Assert.*;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

@SpringBootTest
class NLP_test {

	@Test
	public void tokenizeText() throws Exception {
		InputStream inputStream = getClass().getResourceAsStream("/models/de-token.bin");
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize("Das ist ein Satz.");
		String[] test = {"Das", "ist", "ein", "Satz", "."};
		
		System.out.println("Das ist der Output: " + tokens[0] + tokens[1] + tokens[2]);

		assertArrayEquals(tokens, test);
	}

}
