package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Scenario5 {
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
	public void screenShot() throws IOException {
		driver.get("https://api.jquery.com/dblclick/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(".dblclick() | jQuery API Documentation", driver.getTitle());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		FileHandler.copy(scrFile, new File("C:\\Users\\nehal.kadapatti\\Pictures\\Saved Pictures"+"image.png"));
	}
	
	public void readExcelfile() throws IOException {
		File file = new File("");
		FileInputStream fileStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
	}
	
	public void validateWebPage() {
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		
	}

}
