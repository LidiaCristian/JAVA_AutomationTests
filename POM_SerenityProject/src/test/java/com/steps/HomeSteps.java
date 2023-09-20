package com.steps;

import com.pages.HomePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class HomeSteps{
//extends UIInteractionSteps {
	private HomePage homePage;

	@Step()
	public void navigateToHomePage() {
		//openPageNamed("homePage");
		homePage.open();
	}
	
	@Step()
	public void verifyUserIsOnTheCorrectPage(String pageName, String text) {
		/*Serenity.reportThat("User is not on the "+ pageName + " page",
				() -> assertThat(homePage.verifyPageLanding()).isEqualTo(text));*/

		Assert.assertTrue("User is not on the "+ pageName + " page", homePage.verifyPageLanding().equals(text));
	}
	
}
