package com.tests;

import com.helper.constants.Constants;
import com.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartVerificationTest {

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
	public void WhenAddingProductsToCartFromHomePage_ThenAllProductsShouldAppearInCart() {
		homeSteps.navigateToHomePage();
		homeSteps.verifyUserIsOnTheCorrectPage("Home Page", Constants.HOME_PAGE_TEXT_CONFIRMATION);
		productsSteps.addRandomProductsToCart();
		headerSteps.navigateToCartPage();
		cartSteps.verifyCartSizeProductsPriceQuantityAndTotalPriceAreCorrect();


		/*cartSteps.goToCheckoutPage();
		checkoutSteps.verifyUserLandedOnTheCheckoutPage(Constants.CHECKOUT_PAGE_TEXT_CONFIRMATION);
		checkoutSteps.verifyCartTotalAmount();*/
	}

	@Ignore
	public void  WhenAddingProductsToCartFromProductsPage_ThenProductsShouldAppearInCart() {
		homeSteps.navigateToHomePage();
		homeSteps.verifyUserIsOnTheCorrectPage("Home Page", Constants.HOME_PAGE_TEXT_CONFIRMATION);
		headerSteps.goToProductsPage();
		homeSteps.verifyUserIsOnTheCorrectPage("Products Page", Constants.PRODUCTS_PAGE_TEXT_CONFIRMATION);
		productsSteps.addRandomProductsToCart();
		headerSteps.navigateToCartPage();
		cartSteps.verifyCartSizeProductsPriceQuantityAndTotalPriceAreCorrect();
	}
}
