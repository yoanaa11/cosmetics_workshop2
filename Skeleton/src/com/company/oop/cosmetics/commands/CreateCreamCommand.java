package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCreamCommand implements Command {
    private static final String CREAM_CREATED = "Cream with name %s was created!";
    private static final String CREAM_ALREADY_EXISTS = "Cream with name %s already exists!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String creamName = parameters.get(0);
        String brand = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        ScentType scent = ParsingHelpers.tryParseScent(parameters.get(4));

        return createCream(creamName, brand, price, genderType, scent);
    }

    private String createCream(String creamName, String brand, double price,
                                 GenderType genderType, ScentType scent) {

        if (cosmeticsRepository.productExist(creamName)) {
            throw new IllegalArgumentException(String.format(CREAM_ALREADY_EXISTS, creamName));
        }

        cosmeticsRepository.createCream(creamName, brand, price, genderType, scent);

        return String.format(CREAM_CREATED, creamName);
    }
}