package com.steps;

import com.helper.constants.SerenityKeyConstants;
import com.helper.factory.CartFactory;
import com.helper.models.Cart;
import com.helper.utils.MethodsHelper;
import com.helper.utils.SerenitySessionUtils;
import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class ProductsSteps {
    private ProductsPage productsPage;
    private int totalProductsAddedToCart;

    @Step()
    public void addRandomProductsToCart() {
        int randomNumber = MethodsHelper.getRandomNumber(1, 10);
        List<Cart> productList = new ArrayList<>();
        CartFactory productsList2;

        for (int i = 0; i <= randomNumber - 1; i++) {
            boolean elementExists = false;
            int randomProductIndex = MethodsHelper.getRandomNumber(1, 5); //Max: 34
            productsPage.clickAddToCartButton(randomProductIndex);
            productsPage.clickContinueShoppingButton();
            if (productList.isEmpty()){
                productList.add(CartFactory.getCartProducts(productsPage.getProductDescription(randomProductIndex),
                        productsPage.getProductPrice(randomProductIndex)));
                elementExists = true;
            }
            else
                for (Cart productToModify : productList) {
                    if (productToModify.getDescription().equals(productsPage.getProductDescription(randomProductIndex))) {
                        productToModify.setQuantity(productToModify.getQuantity() + 1);
                        productToModify.setTotalPricePerProduct(productToModify.getPrice() * productToModify.getQuantity());
                        elementExists = true;
                        break;
                    }
                }
            if (elementExists == false)
                productList.add(CartFactory.getCartProducts(productsPage.getProductDescription(randomProductIndex),
                        productsPage.getProductPrice(randomProductIndex)));
        }

        SerenitySessionUtils.putOnSession(SerenityKeyConstants.Cart, productList);
    }
}