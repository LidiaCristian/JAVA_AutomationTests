package com.tests;

import com.steps.HeaderSteps;
import com.steps.HomeSteps;
import com.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src\\test\\resources\\csv\\LoginInvalidCredentialDataDriven.csv")
public class InvalidLoginTest{

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomeSteps homeSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public HeaderSteps headerSteps;

    private String username, password;

    @Test
    public void WhenLoginWithInvalidCredentials_ThenLoginErrorMessageShouldBeDisplayed() {
        homeSteps.navigateToHomePage();
        headerSteps.navigateToSignupLoginPage();
        loginSteps.doLogin(username, password);
        loginSteps.verifyLoginErrorMessageForInvalidCredentials();
    }
}
