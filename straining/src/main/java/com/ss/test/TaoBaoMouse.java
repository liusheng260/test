package com.ss.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TaoBaoMouse {

	public static void main(String[] args) {
		WebDriver driver = DriverDriver.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("J_SiteNavSeller")))
			.pause(Duration.ofSeconds(2L))
			.moveToElement(driver.findElement(By.id("J_SiteNavService")))
			.pause(Duration.ofSeconds(2L))
			//.moveToElement(driver.findElement(By.id("J_SiteNavSitemap")))
			.perform();
			Thread.sleep(2000);
		}catch(Exception e) {
			driver.quit();
			e.printStackTrace();
		}finally {
			DriverDriver.stopService();
		}
	}

}
