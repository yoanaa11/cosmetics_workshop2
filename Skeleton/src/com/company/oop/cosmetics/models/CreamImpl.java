package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends ProductImpl implements Cream {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 15;

    private final ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType genderType, ScentType scent) {
        super(name, brand, price, genderType);

        this.scent = scent;
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }

    @Override
    public String print() {
        return String.format(
                "%s" +
                        " #Scent: %s\n", super.print(), this.scent);
    }

    @Override
    protected void validateName(String name) {
        ValidationHelpers.validateStringLength(name, MIN_LENGTH, MAX_LENGTH, "Name");
    }

    @Override
    protected void validateBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, MIN_LENGTH, MAX_LENGTH, "Brand");
    }
}