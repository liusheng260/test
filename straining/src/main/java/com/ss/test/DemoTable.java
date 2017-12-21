package com.ss.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoTable {

	public static void main(String[] args) {
		WebDriver driver = DriverDriver.getDriver();
		try {
		driver.get("http://localhost:8080/TestingProject1129/table.html");
		int price1,price2;
		Thread.sleep(2000);
		price1 = choice(driver,2);
		price2 = choice(driver,3);
		System.out.println("总价为："+(price1+price2));
		Thread.sleep(2000);
		driver.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverDriver.stopService();
		}	
	}

	public static int choice(WebDriver driver,int index) {
		int price;
//		driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input")).click();
//		price = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[3]")).getText());
		WebElement check = driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input"));
		check.click();
		price = Integer.parseInt(check.findElement(By.xpath("../../td[3]")).getText());
		return price;	
	}
}
