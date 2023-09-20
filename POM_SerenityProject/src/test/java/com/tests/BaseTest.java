package com.tests;

import com.helper.constants.Constants;
import com.steps.HeaderSteps;
import com.steps.HomeSteps;
import com.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;

public class BaseTest {
	@Steps
	public HeaderSteps headerSteps;

	@Steps
    public HomeSteps homeSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Before
	public void loginStep() {
		homeSteps.navigateToHomePage();
		headerSteps.navigateToSignupLoginPage();
		loginSteps.doLogin(Constants.LOGIN_USERNAME, Constants.LOGIN_PASSWORD);
		headerSteps.verifyLogoutMenuItemIsDisplayed();
	}
}
