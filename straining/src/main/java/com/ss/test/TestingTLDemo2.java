package com.ss.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestingTLDemo2 {

	public static void main(String[] args) {
		WebDriver driver = DriverDriver.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");
			TestingLTPageIndex indexPage = new TestingLTPageIndex();
		}catch(Exception e) {
			driver.quit();
			e.printStackTrace();
		}finally {
			DriverDriver.stopService();
		}
	}

}
