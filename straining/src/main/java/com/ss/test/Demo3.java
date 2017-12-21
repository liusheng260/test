package com.ss.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo3 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver();
		driver.get("http://localhost:8080/TestingProject1129/link.html");
		WebElement link = driver.findElement(By.partialLinkText("吃了嘛"));
		System.out.println(link.getText());
		driver.close();
		DriverUtils.stopService();
	}

}
