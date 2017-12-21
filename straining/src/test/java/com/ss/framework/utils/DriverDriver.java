package com.ss.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverDriver {
	private static DriverService service;
	/**
	 * 定义日志对象
	 */
	private static final Logger logger = LogManager.getLogger();
	static {
		Config config = new Config("Config.properties");
		String driverFile = config.getConfig("driver");
		logger.info("获取配置文件中driver所在路径和文件名，值为："+driverFile);//使用日志记录获取的参数值
		service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File(config.getConfig("driver")))
				.build();
		try {
			service.start();//启动service
			logger.info("driver服务启动");
		} catch (IOException e) {
			logger.error("未能成功启动service，原因为："+e.getMessage());
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
