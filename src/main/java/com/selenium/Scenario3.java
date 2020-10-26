package com.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario3 {
	
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nehal.kadapatti\\"
				+ "Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void medicalRecords() throws InterruptedException {
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		driver.findElement(By.linkText("Medical Records")).sendKeys(Keys.CONTROL,Keys.ENTER);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		driver.findElement(By.linkText("Search Patient")).click();
		WebElement options = driver.findElement(By.id("search_type"));
		Select selectFrom = new Select(options);
		Thread.sleep(2000);
		selectFrom.selectByVisibleText("First Name");
		driver.findElement(By.id("search_patient")).click();
		Thread.sleep(5000);
		
			
	}
	
	@Test
	public void popup() throws InterruptedException {
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Thread.sleep(2000);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent Window:" + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child Window" + childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("ChildWindowpopupTitle" + driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("Parent Window Title:" + driver.getTitle());
		
	}
	@After
	public void teardown() {
		driver.quit();
	}

}
