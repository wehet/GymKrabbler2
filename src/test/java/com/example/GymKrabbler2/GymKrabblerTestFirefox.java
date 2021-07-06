package com.example.GymKrabbler2;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import de.bgetem.selenium.configuration.Config;
//import de.bgetem.selenium.configuration.Config;

public class GymKrabblerTestFirefox extends Helper{
	
	GymKrabblerPage gymp;
	static WebDriver driver;
	
	@BeforeClass	
	public static void beforeCalculationTest() throws Exception {
		
	//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
	//driver.get(Config.getBaseUrl());
	//driver.get("https://www.saucelabs.com");
	}
	
	@AfterClass
	public static void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void seitenTest() {
		WebDriver webdriver = getDriver();
        webdriver.navigate().to("https://www.google.com");
        webdriver.manage().window().maximize();
        System.out.println("Started session");
		//driver.get("https://localhost:8080/index");
		//objSearch = new Localhost(driver);
		//gymp.clickUpdate();
	}
	

}
