package com.framework.browser;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BrowserWebDriver {

	private static WebDriver driver;

	private BrowserWebDriver() {

	}

	public static WebDriver getInstance() {
		return driver;
	}

	public static WebDriver startChrome() {
		if (driver == null) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static WebDriver startFirefox() {
		if (driver == null) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void setUrl(String url) {
		driver.get(url);
	}

	public static void changeCurrentTab(int tab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
	}

	public static void closeCurrentTab() {
		driver.close();
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
