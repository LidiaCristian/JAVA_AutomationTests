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

    @Step()
    public void addRandomProductsToCart() {
        int randomNumber = MethodsHelper.getRandomNumber(1, 10);

        List<Cart> cartList = SerenitySessionUtils.getFromSession(SerenityKeyConstants.Cart);

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        for (int i = 0; i < randomNumber; i++) {
            int randomProductIndex = MethodsHelper.getRandomNumber(1, 5); // Max: 34
            String productDescription = productsPage.getProductDescription(randomProductIndex);
            int productPrice = productsPage.getProductPrice(randomProductIndex);

            // Check if the product is already in the cart
            boolean productExists = false;
            for (Cart existingProduct : cartList) {
                if (existingProduct.getDescription().equals(productDescription)) {
                    existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                    existingProduct.setTotalPricePerProduct(existingProduct.getTotalPricePerProduct() + productPrice);
                    productExists = true;
                    break;
                }
            }
            if (!productExists) {
                // If the product doesn't exist in the cart, add it
                Cart newProduct = CartFactory.getCartProducts(productDescription, productPrice);
                newProduct.setQuantity(1);
                newProduct.setTotalPricePerProduct(productPrice);
                cartList.add(newProduct);
            }

            // Click the buttons as needed (assuming these are outside the loop)
            productsPage.clickAddToCartButton(randomProductIndex);
            productsPage.clickContinueShoppingButton();
        }

        // Store the updated cartList in the Serenity Session
        SerenitySessionUtils.putOnSession(SerenityKeyConstants.Cart, cartList);
    }
}