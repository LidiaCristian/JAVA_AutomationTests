package com.steps;

import com.pages.HeaderPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class HeaderSteps{
    //extends UIInteractionSteps {
    private HeaderPage headerPage;

    @Step()
    public void verifySignupLoginMenuItemIsDisplayed(){
        Assert.assertTrue("When user is loged in no logout button is displayed", headerPage.isSignupLoginMenuOptionDisplayed());
    }

    @Step()
    public void verifyLogoutMenuItemIsDisplayed(){
        Assert.assertTrue("When user is loged in no logout button is displayed", headerPage.isLogoutMenuOptionDisplayed());
    }

    @Step()
    public void goToProductsPage() {
        headerPage.clickProductsMenuOption();
    }

    @Step()
    public void navigateToCartPage() {
        headerPage.clickCartMenuOption();
    }

    @Step()
    public void navigateToSignupLoginPage() {
        headerPage.clickSignupLoginMenuOption();
    }

    @Step()
    public void logoutFromAnAccount(){
        headerPage.clickLogoutMenuOption();
    }
}
