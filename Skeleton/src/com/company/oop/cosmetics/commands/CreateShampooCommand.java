package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateShampooCommand implements Command {
    private static final String SHAMPOO_CREATED = "Shampoo with name %s was created!";
    private static final String SHAMPOO_ALREADY_EXISTS = "Shampoo with name %s already exists!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String shampooName = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int milliliters = Integer.parseInt(parameters.get(4));
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));

        return createShampoo(shampooName, brand, price, genderType, milliliters, usageType);
    }

    private String createShampoo(String shampooName, String brand, double price, GenderType genderType,
                                 int milliliters, UsageType usageType) {
        if (cosmeticsRepository.productExist(shampooName)) {
            throw new IllegalArgumentException(String.format(SHAMPOO_ALREADY_EXISTS, shampooName));
        }

        cosmeticsRepository.createShampoo(shampooName, brand, price, genderType, milliliters, usageType);

        return String.format(SHAMPOO_CREATED, shampooName);
    }
}