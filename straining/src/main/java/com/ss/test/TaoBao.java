package com.ss.test;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaoBao {

	public static void main(String[] args) {
		WebDriver driver = DriverDriver.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com/");
			Thread.sleep(2000);
			driver.manage().window().maximize();
			
			WebElement div = driver.findElement(By.cssSelector(".layer.clearfix > div"));
			/*
			org.openqa.selenium.Point point = div.getLocation();
			System.out.println(point);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollTo(0,1500)");
			//jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,1500);
			jse.executeScript("window.scrollTo(arguments[0],arguments[1])",0,point.y);
			*/
			ScrollToElement(driver,div);
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//div[2]/div[1]/div/ul/a[4]/div[1]/img"));
			System.out.println(element.getText());
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			DriverDriver.stopService();
		}
	}
	//滚动方法进行封装
	public static void ScrollToElement(WebDriver driver,WebElement element) {
		org.openqa.selenium.Point point = element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollTo(arguments[0],arguments[1])", point.x,point.y);
	}
}
