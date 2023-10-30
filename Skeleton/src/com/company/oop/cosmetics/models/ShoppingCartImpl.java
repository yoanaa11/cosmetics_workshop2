package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    private static final String PRODUCT_NOT_IN_SHOPPING_CART = "Shopping cart does not contain product with name %s!";

    private final List<Product> products;

    public ShoppingCartImpl() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (!containsProduct(product)) {
            throw new IllegalArgumentException(String.format(PRODUCT_NOT_IN_SHOPPING_CART, product.getName()));
        }

        this.products.remove(product);
    }

    public boolean containsProduct(Product product) {
        return this.products.contains(product);
    }

    public double totalPrice() {
        double totalPrice = 0;

        for (Product product : this.products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }
}