package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.main.objects.AbstractMainPage;

public class GoogleHomePage extends AbstractMainPage {

	@FindBy(xpath = "//div[@id='searchform']//input[@name='q']")
	private WebElement searchField;

	public GoogleResultPage searchSomeText(String text) {
		searchField.clear();
		searchField.sendKeys(text);
		searchField.submit();
		return new GoogleResultPage();
	}

}
