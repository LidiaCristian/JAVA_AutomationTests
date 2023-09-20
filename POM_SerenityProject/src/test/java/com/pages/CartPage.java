package com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://automationexercise.com")
public class CartPage extends PageObject {

	// Getting elements on the Page
	@FindBy(css="[class=\"table table-condensed\"]>tbody>tr")
	List<WebElement> cartTotalProducts;
	@FindBy(css = "[class=\"cart_description\"]>h4>a")
	List<WebElement> cartProductDescriptionList;
	@FindBy(css = "[class=\"cart_price\"]>p")
	List<WebElement> cartProductPriceItemList;
	@FindBy(css = "[class=\"cart_quantity\"]>button")
	List<WebElement> cartProductQuantityList;
	@FindBy(css = "[class=\"cart_total\"]>p")
	List<WebElement> cartProductTotalPriceList;
	
	@FindBy(css = ".btn.btn-default.check_out")
	WebElement checkoutButton;

	
	// actions with elements on the page
	public int getCartTotalProducts(){
		return cartTotalProducts.size();
	}

	public String getCartProductDescription(int index){
		String productDestription = cartProductDescriptionList.get(index).getText();
		return productDestription;
	}

	public int getCartProductPrice(int index){
		int price = Integer.valueOf((cartProductPriceItemList.get(index).getText()).replaceAll("[^0-9]", ""));
		return price;
	}

	public int getCartProductQuantity(int index){
		int quantity = Integer.valueOf(cartProductQuantityList.get(index).getText());
		return quantity;
	}

	public int getCartProductTotalPrice(int index){
		int totalPrice = Integer.valueOf((cartProductTotalPriceList.get(index).getText()).replaceAll("[^0-9]", ""));
		return totalPrice;
	}

	public void clickProceedToCheckoutButton(){
		checkoutButton.click();
	}
}
