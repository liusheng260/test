package com.ss.test;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest11 {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.gecko.driver","/Users/liusheng/Desktop/application/geckodriver");
		WebDriver driver=new FirefoxDriver();*/
		GeckoDriverService service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("/Users/liusheng/Desktop/application/geckodriver"))
				.build();
		try {
			service.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		driver.get("https://www.baidu.com");
		driver.close();
		//RemoteWebDriver启用父类的方法避免多次启用服务
		driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		driver.get("http://www.51testing.com");
		driver.close();
		
		service.stop();
		/*
		GeckoDriverService service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("/Users/liusheng/Desktop/application/geckodriver"))
				.build();
		WebDriver driver = new FirefoxDriver(service);
		driver.get("https://www.baidu.com");
		*/
	}

}
