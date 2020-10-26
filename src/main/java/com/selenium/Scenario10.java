package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Scenario10 {
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
	public void checkPincode() {
		driver.get("https://chennaiiq.com/chennai/pincode-by-name.php");
		List <WebElement> rows = driver.findElements(By.xpath("/html/body/table/"
				+ "tbody/tr[3]/td[2]/table[1]/tbody/tr")) ;
		
		String beforeXpath = "/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[";
		String afterXpath = "]/td[3]";
		
		for (int i = 4; i < rows.size()-1; i++) {
			String actualXpath1 = beforeXpath+i+afterXpath;
			String pincode1 = driver.findElement(By.xpath(actualXpath1)).getText();
			for (int j = i+1; j < rows.size()-1; j++) {
				String actualXpath2 = beforeXpath+j+afterXpath;
				String pincode2 = driver.findElement(By.xpath(actualXpath2)).getText();
				if(pincode1==pincode2) {
					System.out.println("The pincodes of two Areas are same");
				}
			}
		}
		
	}
}
