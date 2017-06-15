package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.main.objects.AbstractMainPage;

public class GoogleResultPage extends AbstractMainPage {

	@FindBy(xpath = "//div[@id='searchform']//input[@name='q']")
	private WebElement searchField;
	@FindBy(xpath = "(//h3[@class='r'])[1]/a")
	private WebElement firstSearchResult;

	public GoogleResultPage searchSomeText(String text) {
		searchField.clear();
		searchField.sendKeys(text);
		searchField.submit();
		return new GoogleResultPage();
	}

	public String getTextFromFirstSearchResult() {
		return waitAndGetText(firstSearchResult).toLowerCase();
	}

}
