package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com")
public class LoginPage extends PageObject{
		
	//Getting elements on the Page
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(className="btn-default")
	WebElement loginButton;
	
    @FindBy(css ="p[style]")
	WebElement errorMessage;

	@FindBy(css="div[class=login-form] > h2")
	WebElement loginFormTitle;

	@FindBy(css="div[class=signup-form] > h2")
	WebElement signupFormTitle;
    
    //actions with elements on the page
    public void setEmailField(String value) {
		typeInto(emailField, value);
	}
	
	public void setPasswordField(String value) {
		typeInto(passwordField, value);
	}
	
	public void clickLoginButton() {
		element(loginButton).waitUntilClickable();
		loginButton.click();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public boolean isLoginFormTitleDisplayed(){
		return loginFormTitle.isDisplayed();
	}

	public boolean isSignupFormTitleDiplayed(){
		return signupFormTitle.isDisplayed();
	}
}
