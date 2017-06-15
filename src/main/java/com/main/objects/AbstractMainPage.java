package com.main.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.browser.BrowserWebDriver;

public abstract class AbstractMainPage {

	public AbstractMainPage() {
		PageFactory.initElements(BrowserWebDriver.getInstance(), this);
	}

	private WebDriverWait waitForElement() {
		return new WebDriverWait(BrowserWebDriver.getInstance(), 5);
	}

	public WebElement waitForElementToBeVisible(WebElement element) {
		return waitForElement().until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return waitForElement().until(ExpectedConditions.elementToBeClickable(element));
	}

	public String waitAndGetText(WebElement element) {
		return waitForElementToBeVisible(element).getText();
	}

	public String waitAndGetTagName(WebElement element) {
		return waitForElementToBeVisible(element).getTagName();
	}

	public String waitAndGetAttribute(WebElement element, String attribute) {
		return waitForElementToBeVisible(element).getAttribute(attribute);
	}

	public void waitAndClick(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

}
