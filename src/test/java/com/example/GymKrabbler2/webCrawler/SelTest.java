package com.example.GymKrabbler2.webCrawler;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelTest {

	//zum Ausführen der Tests: geckodriver.exe lokal installieren und Dateipfad entsprechend anpassen
	
	@Test
	//Anzeige der Hauptwebseite überprüfen
    public void websiteConnectionTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zoech\\Documents\\DHBW\\6. Semester\\SE\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/index");
        driver.quit();
    }
	
	@Test
	//Anzeige der Fehlerseitseite überprüfen
    public void errorConnectionTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zoech\\Documents\\DHBW\\6. Semester\\SE\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/error");
        driver.quit();
    }
	
	
	@Test
	//Suchleiste überprüfen
	public void searchTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zoech\\Documents\\DHBW\\6. Semester\\SE\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/index");
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"myInput\"]"));
		searchbox.sendKeys("Pfitze");
		driver.quit();
	}
	
	
	@Test
	//Update Button Testen
	public void updateButtonTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\zoech\\Documents\\DHBW\\6. Semester\\SE\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/index");
		driver.findElement(By.xpath("/html/body/center[1]/p/button/a")).click();
        driver.quit();
    }

}
