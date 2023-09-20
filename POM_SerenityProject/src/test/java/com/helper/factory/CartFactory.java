package com.helper.factory;

import com.helper.models.Cart;

public class CartFactory {
    public static Cart getCartProducts(String description, int price){
        Cart cart = new Cart();
        cart.setDescription(description);
        cart.setPrice(price);
        cart.setQuantity(1);
        cart.setTotalPricePerProduct(price);
        return cart;
    }
}
