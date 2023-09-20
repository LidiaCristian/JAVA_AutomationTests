package com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://automationexercise.com")
public class CheckoutPage extends PageObject {
	
	@FindBy(css = "[class=\"active\"]")
	WebElement checkoutPageVerificationText;
	
	@FindBy(css = "tbody>tr:last-child")
	WebElement checkoutTotalAmount;
	
	@FindBy(css = "[class=\"cart_total\"]>p")
	List<WebElement> checkoutProductTotalPricelList;

	public String getCheckoutPageVerificationText() {
		element(checkoutPageVerificationText).waitUntilPresent();
		return checkoutPageVerificationText.getText();
	}

	public List<WebElement> getCheckoutTotalProducts(){
		return checkoutProductTotalPricelList;
	}
	
	public int getCheckoutProductTotalPrice(int index) {
		int productTotalPrice = Integer.valueOf((checkoutProductTotalPricelList.get(index).getText()).replaceAll("[^0-9]", ""));
		return productTotalPrice;
	}

	public int getCheckoutTotalAmount() {
		element(checkoutTotalAmount).waitUntilPresent();
		int totalAmount = Integer.valueOf((checkoutTotalAmount.getText()).replaceAll("[^0-9]", ""));
		return totalAmount;
	}	
	

}
