package com.company.oop.cosmetics.core.contracts;

import com.company.oop.cosmetics.models.CreamImpl;
import com.company.oop.cosmetics.models.ShampooImpl;
import com.company.oop.cosmetics.models.ToothpasteImpl;
import com.company.oop.cosmetics.models.contracts.*;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.models.enums.UsageType;

import java.util.List;

public interface CosmeticsRepository {

    ShoppingCart getShoppingCart();

    List<Category> getCategories();

    List<Product> getProducts();

    Product findProductByName(String productName);

    Category findCategoryByName(String categoryName);

    Category createCategory(String categoryToAdd);

    Shampoo createShampoo(String name, String brandName, double price, GenderType genderType,
                              int millilitres, UsageType usageType);

    Toothpaste createToothpaste(String name, String brandName, double price, GenderType genderType, List<String> ingredients);

    Cream createCream(String name, String brandName, double price, GenderType genderType, ScentType scent);

    boolean categoryExist(String categoryName);

    boolean productExist(String productName);

    void removeProductFromCart(Product product);

    void addProductToShoppingCart(Product product);

}
