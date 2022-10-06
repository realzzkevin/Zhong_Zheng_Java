package com.company.Factory;

import java.util.List;

public class IceCream {
    private List<String> ingredientsList;
    private int batchNumber;
    private String flavor;
    private String UPC;
    private double productionCost;
    private double salePrice;

    public IceCream() {}
    public IceCream(List<String> Ingredients, int batchNumber, String upc) {
        this.ingredientsList = Ingredients;
        this.flavor = createFlavor();
        this.UPC = upc;
        this.productionCost = calculateCost();
        this.salePrice = this.productionCost * 1.5;
    }
    //
    public String createFlavor() {
        String returnVal = "";
        for(String ingredient: ingredientsList ) {
            returnVal += ingredient;
        }
        return returnVal;
    }
    //calculate production cost by the numbers of ingredients
    public double calculateCost() {
        return ingredientsList.size() * 6;
    }
    // change ingredient list and change everything property associate to it.
    public void changeIngredient(List<String> newIngredient){
        this.ingredientsList = newIngredient;
        this.flavor = createFlavor();
        this.productionCost = calculateCost();
        this.salePrice = this.productionCost * 1.5;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public double getSalePrice() {
        return salePrice;
    }
}
