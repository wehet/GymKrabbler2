package com.example.GymKrabbler2;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class GymKrabblerPage {
	//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
	WebDriver driver;
	
	By updateButton = By.xpath("//*[@id=\"Content\"]/center[1]/p/button/a");
	
	public GymKrabblerPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickUpdate() {
		driver.findElement(updateButton).submit();
	}

}
