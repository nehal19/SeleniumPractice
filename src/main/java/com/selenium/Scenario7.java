 package com.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario7 {
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nehal.kadapatti\\"
				+ "Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void enterText() throws InterruptedException {
		driver.get("https://www.google.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Dimension d = new Dimension(640,480);
		driver.manage().window().setSize(d);
		
		WebElement searchbox = driver.findElement(By.name("q"));
		js.executeScript("arguments[0].value='Selenium'", searchbox);
		Thread.sleep(2000);
		
		
	}
}
