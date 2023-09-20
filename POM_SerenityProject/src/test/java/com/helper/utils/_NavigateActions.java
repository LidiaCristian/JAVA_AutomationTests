package com.helper.utils;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class _NavigateActions extends UIInteractionSteps {

	@Step("GIVEN the User Navigates to the Home Page")
	public void goToHomePage(String page) {
		openPageNamed("homePage");
	}

	@Step("GIVEN the User Navigates to the Login Page")
	public void goToLoginPage() {
		openPageNamed("loginPage");
	}

}