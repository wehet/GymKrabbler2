package com.example.GymKrabbler2.webCrawler;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.example.GymKrabbler2.model.ScrapeData;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ScraperTest {
	
	@Test
	void scrapeWebsiteTest() throws Exception {
		
		ScrapeData mockData = mock(ScrapeData.class);
		when(mockData.getUrl()).thenReturn("https://www.google.com/");  
		when(mockData.getXpath()).thenReturn("Start irgendwas End");
		when(mockData.getStart()).thenReturn("Start");
		when(mockData.getEnd()).thenReturn("End");
		
//		 MyObject myObjectMock = mock(MyObject.class);
//	        when(myObjectMock.method1()).thenReturn(<whatever you want to return>);   
//	        PowerMockito.whenNew(MyObject.class).withNoArguments().thenReturn(myObjectMock);
//	        
//	        MyClass objectTested = new MyClass();
//	        objectTested.method1();
		
//		WebClient client = mock(WebClient.class);
//		when(client.getPage("https://www.google.com/")).thenReturn(new HtmlPage(null, null, null));
		WebClient client = mock(WebClient.class);
		HtmlElement mockElement = mock(HtmlElement.class);
		HtmlPage page = mock(HtmlPage.class);
		HtmlPage mockPage = mock(HtmlPage.class);
		HtmlElement element = mock(HtmlElement.class);
		when(client.getPage("https://www.google.com/")).thenReturn(mockPage);
		when(page.getFirstByXPath("Start irgendwas End")).thenReturn(mockElement);
		when(element.asText()).thenReturn("Start irgendwas End");
		
//		PowerMockito.whenNew(MyObject.class).withNoArguments().thenReturn(myObjectMock);
		
		
		Scraper s = new Scraper(mockData);
		String el = s.scrapeWebsite(); 
		assertEquals("irgendwas", el);
	}

}
