package com.steps;

import com.helper.constants.SerenityKeyConstants;
import com.helper.models.Cart;
import com.helper.utils.SerenitySessionUtils;
import com.pages.CartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.List;

public class CartSteps extends ScenarioSteps {
    private CartPage cartPage;

 /*   @Step()
    public void verifyCartSizeIsEqualToElementsAddedToCart() {
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);

        //TODO: to remove{
        System.out.println("----------Total products from session: "+productGetSession.size());
        System.out.println("----------Total products from cart : "+cartPage.getCartTotalProducts());
        // }

        Assert.assertTrue("Cart size is not equal to elements added to cart",
                (productGetSession.size() == cartPage.getCartTotalProducts()));
    }

    @Step()
    public void verifyCartContainsAllProductsAddedToCart() {
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);
        for (int i = 0; i <= cartPage.getCartTotalProducts()-1; i++)
            Assert.assertTrue("Cart doesn't contain all the added products",
                    cartPage.getCartProductDescription(i).equals(productGetSession.get(i).getDescription()));
    }

    @Step()
    public void verifyPricePerProductIsCorrect() {
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);
        for (int i = 0; i <= cartPage.getCartTotalProducts() - 1; i++) {
            Assert.assertTrue("Cart Product Total Price is not correct",
                    cartPage.getCartProductPrice(i) == productGetSession.get(i).getPrice());
        }
    }

    @Step()
    public void verifyQuantityPerProductIsCorrect(){
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);
        for (int i = 0; i <= cartPage.getCartTotalProducts() - 1; i++) {
            Assert.assertTrue("Cart Product Total Price is not correct",
                    cartPage.getCartProductQuantity(i) == productGetSession.get(i).getQuantity());
        }
    }

    @Step()
    public void verifyTotalPricePerProductIsCorrect(){
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);
        for (int i = 0; i <= cartPage.getCartTotalProducts() - 1; i++) {
            Assert.assertTrue("Cart Product Total Price is not correct",
                    cartPage.getCartProductTotalPrice(i) == productGetSession.get(i).getTotalPricePerProduct());
        }
    }*/

    @Step()
    public void verifyCartSizeProductsPriceQuantityAndTotalPriceAreCorrect() {
        List<Cart> productGetSession = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);

        Assert.assertTrue("Cart size is not equal to elements added to cart",
                (productGetSession.size() == cartPage.getCartTotalProducts()));
        for (int i = 0; i <= cartPage.getCartTotalProducts()-1; i++) {
            Assert.assertTrue("Cart doesn't contain all the added products",
                    cartPage.getCartProductDescription(i).equals(productGetSession.get(i).getDescription()));
            Assert.assertTrue("Cart Products Price is not correct",
                    cartPage.getCartProductPrice(i) == productGetSession.get(i).getPrice());
            Assert.assertTrue("Cart Products Quantity is not correct",
                    cartPage.getCartProductQuantity(i) == productGetSession.get(i).getQuantity());
            Assert.assertTrue("Cart Total Price per Product is not correct",
                    cartPage.getCartProductTotalPrice(i) == productGetSession.get(i).getTotalPricePerProduct());
        }
        /*verifyCartSizeIsEqualToElementsAddedToCart();
        verifyCartContainsAllProductsAddedToCart();
        verifyPricePerProductIsCorrect();
        verifyQuantityPerProductIsCorrect();
        verifyTotalPricePerProductIsCorrect();*/
    }

    @Step()
    public void goToCheckoutPage() {
        cartPage.clickProceedToCheckoutButton();
    }
}