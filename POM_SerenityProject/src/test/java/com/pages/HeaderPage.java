package com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com")
public class HeaderPage extends PageObject {

    // Getting elements on the Page
    @FindBy(css = "a[href=\"/products\"]")
    WebElement productsMenuOption;

    @FindBy(css = "a[href=\"/login\"]")
    WebElement signupLoginMenuOption;

    @FindBy(css = "a[href=\"/view_cart\"]")
    WebElement cartMenuOption;

    @FindBy(css = "a[href=\"/logout\"]")
    WebElement logoutMenuItem;


    // actions with elements on the page
    public void clickProductsMenuOption() {
        element(productsMenuOption).waitUntilClickable();
        productsMenuOption.click();
    }

    public boolean isSignupLoginMenuOptionDisplayed(){
        element(signupLoginMenuOption).isDisplayed();
        return signupLoginMenuOption.isDisplayed();
    }

    public boolean isLogoutMenuOptionDisplayed() {
        element(logoutMenuItem).isDisplayed();
        return logoutMenuItem.isDisplayed();
    }
    public void clickCartMenuOption() {
        element(cartMenuOption).waitUntilClickable();
        cartMenuOption.click();
    }
    public void clickSignupLoginMenuOption() {
        element(signupLoginMenuOption).waitUntilClickable();
        signupLoginMenuOption.click();
    }



    public void clickLogoutMenuOption(){
        element(logoutMenuItem).waitUntilClickable();
        logoutMenuItem.click();
    }
}
