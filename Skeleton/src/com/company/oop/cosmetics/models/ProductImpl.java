package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements com.company.oop.cosmetics.models.contracts.Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private final GenderType genderType;

    public ProductImpl(String name, String brand, double price, GenderType genderType) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.genderType = genderType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        validateName(name);

        this.name = name;
    }

    @Override
    public String getBrandName() {
        return this.brand;
    }

    private void setBrand(String brand) {
        validateBrand(brand);

        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be non negative.");
        }

        this.price = price;
    }

    @Override
    public GenderType getGenderType() {
        return this.genderType;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s\n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s\n",
                getName(), getBrandName(), getPrice(), getGenderType());
    }

    protected void validateName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
    }

    protected void validateBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "Brand");
    }
}