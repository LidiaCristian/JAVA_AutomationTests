package com.helper.models;

public class Cart {
    private String description;
    private int price;
    private int quantity;
    private int totalPricePerProduct;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPricePerProduct() {
        return totalPricePerProduct;
    }

    public void setTotalPricePerProduct(int totalPricePerProduct) {
        this.totalPricePerProduct = totalPricePerProduct;
    }
}
