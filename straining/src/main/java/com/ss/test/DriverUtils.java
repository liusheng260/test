package com.ss.test;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
/**
 * DriverUtils类用于提供service的单例启动，并提供匹配不同浏览器的driver对象
 * @author 六道先生
 *
 */
public class DriverUtils {
	/**
	 * service对象，用于保存根据用户设置的系统属性来创建的不同浏览器的driverservice
	 */
	private static DriverService service;
	/**
	 * browser字符串，用于获取并保持用户设置在系统属性bwf.test.browser中的值
	 */
	private static String browser;
	/**
	 * 静态加载（单例的饿汉模式）service对象，并启动
	 */
	static {
		browser = System.getProperty("bwf.test.browser", "firefox"); // 获取bwf.test.browser系统属性，如果未设置，则默认为firefox
		/*
		 * 根据browser保存的浏览器类型，分别创建DriverService对象，目前chrome和ie尚未完工
		 */
		if("firefox".equalsIgnoreCase(browser)) {
			service = new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin"))) // 指定火狐浏览器执行文件
				.usingAnyFreePort() // 指定使用任一闲置端口
				.usingDriverExecutable(new File("/Users/liusheng/Desktop/application/geckodriver")) // 指定driver驱动程序的位置
				.build(); // 将Builder对象打造成DriverService对象
		}else if("chrome".equalsIgnoreCase(browser)) {
			// not yet implemenent
			service = null;
		}else if("ie".equalsIgnoreCase(browser)){
			// not yet implemenent
			service = null;
		}else {
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性bwf.test.browser");
		}
		try {
			service.start(); // 启动service
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getDriver静态方法用于向使用者提供方便的获取不同类型浏览器driver对象
	 * @return driver
	 */
	public static WebDriver getDriver() {
		
		WebDriver driver = null;
		DesiredCapabilities caps = null;
		/*
		 * 根据browser的值判断启动的browser类型
		 */
		if("firefox".equalsIgnoreCase(browser)) {
			caps = DesiredCapabilities.firefox();
		}else if("chrome".equalsIgnoreCase(browser)) {
			// not yet implemenent
			caps = null;
		}else if("ie".equalsIgnoreCase(browser)){
			// not yet implemenent
			caps = null;
		}else {
			throw new RuntimeException("未支持的浏览器类型，请检查系统属性bwf.test.browser");
		}
		driver = new RemoteWebDriver(service.getUrl(), caps);
		return driver;
	}
	/**
	 * 停止服务
	 */
	public static void stopService() {
		service.stop();
	}
}
