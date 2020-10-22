package com.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {
	
	
	
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nehal.kadapatti\\"
				+ "Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void createGoogleAccount() throws InterruptedException {
		driver.get("https://accounts.google.com/signup");
		//First Name
		driver.findElement(By.id("firstName")).sendKeys("Nehal");
		//Last Name
		driver.findElement(By.id("lastName")).sendKeys("Kadapatti");
		//user name
		driver.findElement(By.id("username")).sendKeys("nehal1234");
		//Password
		driver.findElement(By.name("Passwd")).sendKeys("abcdefghijklmnop");
		//ConfirmPassword
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("abcdefghijklmnop");
		//Click on Next
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]"
				+ "/form/div[2]/div/div[2]/div[1]/div/span/span")).click();
		Thread.sleep(5000);
	}
	
	@After
	public void teardown() {
		driver.close();
	}

}
