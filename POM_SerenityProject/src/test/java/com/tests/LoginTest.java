package com.tests;

import com.helper.constants.Constants;
import com.steps.HeaderSteps;
import com.steps.HomeSteps;
import com.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest{

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public HomeSteps homeSteps;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public HeaderSteps headerSteps;

	@Test
	public void WhenLoginWithValidCredentials_ThenLogoutMenuShouldBeDisplayed() {
		homeSteps.navigateToHomePage();
		headerSteps.verifySignupLoginMenuItemIsDisplayed();
		headerSteps.navigateToSignupLoginPage();
		loginSteps.doLogin(Constants.LOGIN_USERNAME, Constants.LOGIN_PASSWORD);
		headerSteps.verifyLogoutMenuItemIsDisplayed();
	}

	@Test
	public void  WhenLogoutFromAnAccount_ThenLoginMenuItemAndLoginAndSignupFormTitlesShouldBeDisplayed() {
		//TO DO: api login
		homeSteps.navigateToHomePage();
		headerSteps.navigateToSignupLoginPage();
		loginSteps.doLogin(Constants.LOGIN_USERNAME, Constants.LOGIN_PASSWORD);
		///

		headerSteps.logoutFromAnAccount();
		headerSteps.verifySignupLoginMenuItemIsDisplayed();
		loginSteps.verifyLoginFormTitleIsDisplayed();
		loginSteps.verifySigupFormTitleIsDisplayed();
	}
}
