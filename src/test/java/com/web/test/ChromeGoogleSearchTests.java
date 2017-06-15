package com.web.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.browser.BrowserWebDriver;
import com.google.pages.GoogleHomePage;
import com.google.pages.GoogleMainPage;
import com.google.pages.GoogleResultPage;
import com.test.data.GoogleSearchTestsData;

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
	
	@Test(priority = 2)
	public void test123() {
		googleResultPage = googleResultPage.searchSomeText("qqq");
		Assert.assertEquals(googleResultPage.getTextFromFirstSearchResult(), "qqq", "failed!");
	}

	@Test(priority = 3, dataProviderClass = GoogleSearchTestsData.class, dataProvider = "dataForTests")
	public void test(String text, String expected) {
		googleResultPage = googleResultPage.searchSomeText(text);
		Assert.assertEquals(googleResultPage.getTextFromFirstSearchResult(), expected, "failed!");
	}

	@AfterClass
	public void afterClass() {
		BrowserWebDriver.closeBrowser();
	}

}
