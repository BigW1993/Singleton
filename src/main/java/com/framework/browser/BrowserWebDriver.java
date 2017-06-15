package com.framework.browser;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BrowserWebDriver {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private BrowserWebDriver() {

	}

	public static WebDriver getInstance() {
		return driver.get();
	}

	public static WebDriver startChrome() {
		if (driver.get() == null) {
			ChromeDriverManager.getInstance().setup();
			driver.set(new ChromeDriver());
			driver.get().manage().window().maximize();
		}
		return driver.get();
	}

	public static WebDriver startFirefox() {
		if (driver.get() == null) {
			FirefoxDriverManager.getInstance().setup();
			driver.set(new FirefoxDriver());
			driver.get().manage().window().maximize();
		}
		return driver.get();
	}

	public static void setUrl(String url) {
		driver.get().get(url);
	}

	public static void changeCurrentTab(int tab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.get().getWindowHandles());
		driver.get().switchTo().window(tabs.get(tab));
	}

	public static void closeCurrentTab() {
		driver.get().close();
	}

	public static void closeBrowser() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}

	}

}
