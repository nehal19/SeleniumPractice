package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario4 {
	
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
	public void googleSearch() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		List<WebElement> list = driver.findElements
				(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		
		System.out.println("List Size:" + list.size());
		
		for(WebElement s : list) {
			
			if(s.getText().equalsIgnoreCase("selenium tutorial")) {
				s.click();
				
				((JavascriptExecutor)driver).executeScript("scroll(0,400)");
				
				
				Thread.sleep(2000);
				
				break;
			}
		}
		
	}
	
	@Test
	public void scroll() {
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		
	}
	
	
}
