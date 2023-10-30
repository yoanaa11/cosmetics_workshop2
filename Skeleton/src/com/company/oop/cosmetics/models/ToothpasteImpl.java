package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {
    private final List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);

        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
                "%s" +
                        " #Ingredients: ", super.print()));

//        for (int i = 0; i < this.ingredients.size(); i++) {
//            if (i == 0) {
//                sb.append("[");
//            }
//
//            if (i != this.ingredients.size() - 1) {
//                sb.append(this.ingredients.get(i)).append(",");
//            } else {
//                sb.append(this.ingredients.get(i));
//            }
//
//            if (i == this.ingredients.size() - 1) {
//                sb.append("]");
//                break;
//            }
//        }

        sb.append("[");
        sb.append(String.join(", ", this.ingredients));
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}