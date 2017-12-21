package com.ss.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PODemo {
	public static void main(String[] args) {
		WebDriver driver = DriverDriver.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com");
			//实例化类
			TestingLTPageIndex indexPage = PageFactory.initElements(driver, TestingLTPageIndex.class);
			indexPage.forum_1_link.click();
			Thread.sleep(2000);
			driver.quit();
		}catch(Exception e) {
			driver.quit();
			e.printStackTrace();
		}finally {
			DriverDriver.stopService();
		}
	
	}
}
