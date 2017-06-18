package com.web.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.browser.BrowserWebDriver;
import com.google.pages.GoogleHomePage;
import com.google.pages.GoogleMainPage;
import com.google.pages.GoogleResultPage;

public class ChromeGoogleSearchTests {

	private GoogleMainPage googleMainPage = new GoogleMainPage();
	private GoogleHomePage googleHomePage;
	private GoogleResultPage googleResultPage;

	@BeforeClass
	public void beforeClass() {
		BrowserWebDriver.startChrome();
	}

	@Test(priority = 1)
	public void testTextFromFirstSearchResult() {
		googleHomePage = googleMainPage.openGoogleHomePage();
		googleResultPage = googleHomePage.searchSomeText("google");
		Assert.assertEquals(googleResultPage.getTextFromFirstSearchResult(), "google", "failed!");
	}

	@AfterClass
	public void afterClass() {
		BrowserWebDriver.closeBrowser();
	}

}
