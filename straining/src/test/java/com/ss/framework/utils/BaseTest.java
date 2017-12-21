package com.ss.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
public WebDriver driver;
	
	@AfterSuite
	public void closeService() {
		DriverDriver.stopService();
	}
	
	@BeforeMethod
	public void initDriver() {
		//System.setProperty("", "firefox");
		Config config = new Config("config.properties");
		driver = DriverDriver.getDriver();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
}
