package com.steps;

import org.junit.Assert;
import com.pages.CheckoutPage;

import net.thucydides.core.annotations.Step;

public class CheckoutSteps {
	private CheckoutPage checkoutPage;

	@Step()
	public void verifyUserLandedOnTheCheckoutPage(String text) {
		Assert.assertTrue("User is not on the Checkout Page",
				 checkoutPage.getCheckoutPageVerificationText().equals(text));
	}
	
	@Step()
	public void verifyCartTotalAmount() {
		int totalAmount = 0;
		for (int i=0; i<=checkoutPage.getCheckoutTotalProducts().size()-1; i++)
			totalAmount = totalAmount + checkoutPage.getCheckoutProductTotalPrice(i);

		System.out.println("total checkout-----------"+checkoutPage.getCheckoutTotalAmount());
		System.out.println("total calculat-----------"+totalAmount);
		
		Assert.assertTrue("Cart total amount is not correct",
				 checkoutPage.getCheckoutTotalAmount() == totalAmount);
	}

}
