package com.selenium;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class Scenario9 {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Assignments\\src\\main\\resources"
				+ "\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		
		System.out.println(prop.getProperty("url"));
		
		System.out.println(prop.getProperty("username"));
		
		System.out.println(prop.getProperty("password"));

	} 

}
