package com.ss.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverDriver {
	private static DriverService service;
	static {
		service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("/Users/liusheng/Desktop/application/geckodriver"))
				.build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		return driver;	
	}
	
	public static void stopService() {
		service.stop();
	}
}
