package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.main.objects.AbstractMainPage;

public class GoogleResultPage extends AbstractMainPage {

	@FindBy(xpath = "(//h3[@class='r'])[1]/a")
	private WebElement firstSearchResult;

	public String getTextFromFirstSearchResult() {
		return waitAndGetText(firstSearchResult).toLowerCase();
	}

}
