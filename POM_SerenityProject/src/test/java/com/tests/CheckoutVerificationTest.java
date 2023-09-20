package com.tests;

import com.helper.constants.Constants;
import com.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutVerificationTest extends BaseTest{
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public HeaderSteps headerSteps;

	@Steps
	public HomeSteps homeSteps;

	@Steps
	public CartSteps cartSteps;

	@Steps
	public ProductsSteps productsSteps;
	
	@Steps
	public CheckoutSteps checkoutSteps;

	@Test
	public void WhenAddingProductsToCart_ThenAllProductsShouldAppearOnCheckoutPage() {
		productsSteps.addRandomProductsToCart();
		headerSteps.navigateToCartPage();
		cartSteps.goToCheckoutPage();
		checkoutSteps.verifyUserLandedOnTheCheckoutPage(Constants.CHECKOUT_PAGE_TEXT_CONFIRMATION);
		checkoutSteps.verifyCartTotalAmount();
	}
}
