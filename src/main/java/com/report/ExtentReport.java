package com.report;

import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	@Test
	public void loginTest() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./extentReport.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("LoginTest");
		
		logger.log(Status.INFO, "Login to google");
		logger.log(Status.PASS, "Login to google");
		
		extent.flush();
		
	}

}
