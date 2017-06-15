package com.google.pages;

import com.framework.browser.BrowserWebDriver;
import com.main.objects.AbstractMainPage;

public class GoogleMainPage extends AbstractMainPage {

	public GoogleHomePage openGoogleHomePage() {
		BrowserWebDriver.setUrl("https://www.google.com.ua/");
		return new GoogleHomePage();
	}

}
