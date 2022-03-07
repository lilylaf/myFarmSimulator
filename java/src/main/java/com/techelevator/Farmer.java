package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Farmer {

    private String farmerName;
    public String getFarmerName(){
        return farmerName;
    }
    public void setFarmerName(String farmerName){
        this.farmerName = farmerName;
    }

    private String farmName;
    public String getFarmName(){
        return farmName;
    }
    public void setFarmName(String farmName){
        this.farmName = farmName;
    }

    private double debt;
    public double getDebt(){
        return debt;
    }
    public void setDebt(double debt){
        this.debt = debt;
    }

    private double profit;
    public double getProfit(){
        return profit;
    }
    public void setProfit(double profit){
        this.profit = profit;
    }

    public double getBalance(){ //derived from debt and profit
        return profit - debt;
    }

    private List<Product> listOfProducts = new ArrayList<>();
    private void addProductList(Product p){
        listOfProducts.add(p);
    } //this acts like a setter

    //constructor
    public Farmer(){
        this.farmerName = "";
        this.farmName = "";
        this.debt = 0;
        this.profit = 1000.00;
    }

    //method --> because addProductList is private, it can only be called in this class. This method calls addProductList and also adjusts our money variables
    public void addProducts(Product p){
        this.addProductList(p);
        this.debt += p.getInvestmentCost();
        this.profit += p.getSellPrice();
    }

    @Override
    public String toString(){
        return "Farmer Name: " + farmerName + "\nFarmName: " + farmName + "\nCurrent Balance: " + getBalance()
                + "\n(Debts: " + debt + " + Profits: " + profit + ")";
    }
}
