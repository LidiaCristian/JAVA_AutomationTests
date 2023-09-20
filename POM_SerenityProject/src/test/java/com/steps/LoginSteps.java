package com.steps;

import org.junit.Assert;
import com.pages.LoginPage;
import com.helper.constants.Constants;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
//extends UIInteractionSteps {
	private LoginPage loginPage;

	/*
	 * @Step("Navigate to the Login Page") public void goToLoginPage() {
	 * openPageNamed("loginPage"); }
	 */

	@Step()
	public void enterEmail(String email) {
		loginPage.setEmailField(email);
	}

	@Step()
	public void enterPassword(String password) {
		loginPage.setPasswordField((password));
	}

	@Step()
	public void clickOnLoginButton() {
		loginPage.clickLoginButton();
	}

	@Step()
	public void doLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void verifyLoginFormTitleIsDisplayed(){
		Assert.assertTrue("Login Form Title is not displayed", loginPage.isLoginFormTitleDisplayed());
	}

	public void verifySigupFormTitleIsDisplayed(){
		Assert.assertTrue("Signup Form Title is not displayed", loginPage.isSignupFormTitleDiplayed());
	}

	@Step()
	public void verifyLoginErrorMessageForInvalidCredentials() {
		Assert.assertTrue("Passing invalid credentials doesn't generate an error message",
				loginPage.getErrorMessage().contains(Constants.LOGIN_ERROR_MESSAGE));
	}
}
