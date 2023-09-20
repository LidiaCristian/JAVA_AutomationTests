package com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com")
public class HomePage extends PageObject {

	// Getting elements on the Page

	@FindBy(css = "div.features_items>h2")
	WebElement getPageText;

	// actions with elements on the page

	public String verifyPageLanding() {
		element(getPageText).waitUntilVisible();
		return getPageText.getText();
	}
}
