package com.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
	
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nehal.kadapatti\\"
				+ "Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void bootstrapDropdown() throws InterruptedException {
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/"
				+ "td[3]/div/span/div/button/span")).click();
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]"
				+ "/div/span/div/ul/li[3]/a/label/input")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void dragandDrop() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement fromElement = driver.findElement(By.xpath("/html/body/div[1]"));
		WebElement toElement = driver.findElement(By.xpath("/html/body/div[2]"));
		Actions action = new Actions(driver);
		action.dragAndDrop(fromElement, toElement).build().perform();
		Thread.sleep(5000);
	}
	
	
	
	@After
	public void teardown() {
		driver.quit();
	}

}
