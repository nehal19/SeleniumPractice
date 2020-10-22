package com.selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Scenario6 {
	
	@Test(dataProvider = "credentials")
	public void checkCredentials(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	
	@DataProvider(name="credentials")
	public Object getData() {
		Object [][] data = new Object[2][2];
		data[0][0] = "username1";
		data[0][1] = "pass1";
		data[1][0] = "username2";
		data[1][1] = "pass2";
		return data;
	}
	

}
