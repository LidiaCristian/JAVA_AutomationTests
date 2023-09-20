package com.pages;

import com.helper.utils.MethodsHelper;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://automationexercise.com")
public class ProductsPage extends PageObject {

	// Getting elements on the Page
	@FindBy(css = "[class=\"features_items\"]>div>[class=\"product-image-wrapper\"]>div>div>p")
	List<WebElement> productsListDescription;
	@FindBy(css="[class=\"features_items\"]>div>[class=\"product-image-wrapper\"]>div>div>h2")
	List<WebElement> productPrice;

	@FindBy(css = "[class=\"features_items\"]>div>[class=\"product-image-wrapper\"]>div>div>[class=\"btn btn-default add-to-cart\"]")
	List<WebElement> addToChartButton2;

	@FindBy(css = "[class=\"btn btn-success close-modal btn-block\"]")
	WebElement continueShoppingButton;

	public String getProductDescription(int index) {
		return productsListDescription.get(index).getText();
	}

	public int getProductPrice(int index){
		int price = Integer.valueOf((productPrice.get(index).getText()).replaceAll("[^0-9]", ""));
		return price;
	}

	public void clickAddToCartButton(int index) {
		element(addToChartButton2.get(index)).waitUntilVisible();
		System.out.println("Product add to cart ----------"+ getProductDescription(index));
		//withAction().moveToElement(addToChartButton2.get(index)).perform();
		MethodsHelper.hoverOverAndClick(addToChartButton2.get(index));
	}

	public void clickContinueShoppingButton() {
		element(continueShoppingButton).waitUntilClickable();
		continueShoppingButton.click();
	}


}