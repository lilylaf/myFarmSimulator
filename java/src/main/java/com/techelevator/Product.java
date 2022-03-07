package com.techelevator;

public class Product {

    private String productName;
    public String getProductName(){
        return productName;
    }

    private double investmentCost;
    public double getInvestmentCost(){
        return investmentCost;
    }

    private double sellPrice;
    public double getSellPrice(){
        return sellPrice;
    }

    //constructor
    public Product(String productName, double investmentCost, double sellPrice){
        this.productName = productName;
        this.investmentCost = investmentCost;
        this.sellPrice = sellPrice;
    }

    //methods
    //for now I don't need any methods

    @Override
    public String toString(){
        return "Product Name: " + productName + "\nInvestment Cost: " + investmentCost + "\nSell price: " + sellPrice;
    }
}
