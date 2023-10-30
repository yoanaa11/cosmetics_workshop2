package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {
    private static final String TOOTHPASTE_CREATED = "Toothpaste with name %s was created!";
    private static final String TOOTHPASTE_ALREADY_EXISTS = "Toothpaste with name %s already exists!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String toothpasteName = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        List<String> ingredients = Arrays.stream(parameters.get(4).split(",")).toList();

        return createToothpaste(toothpasteName, brand, price, genderType, ingredients);
    }

    private String createToothpaste(String toothpasteName, String brand, double price,
                                    GenderType genderType, List<String> ingredients) {

        if (cosmeticsRepository.productExist(toothpasteName)) {
            throw new IllegalArgumentException(String.format(TOOTHPASTE_ALREADY_EXISTS, toothpasteName));
        }

        cosmeticsRepository.createToothpaste(toothpasteName, brand, price, genderType, ingredients);

        return String.format(TOOTHPASTE_CREATED, toothpasteName);
    }
}