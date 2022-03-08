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


    //constructor
    public Farmer(){
        this.farmerName = "";
        this.farmName = "";
        this.debt = 0;
        this.profit = 1000.00;
    }

    //if balance hits zero or less, the game is over.
    public boolean gameOver(){
        if (this.getBalance() <= 0.00){
            return true;
        }
        return false;
    }

    //add profits
    public void addProfits(double p){
        this.profit += p;
    }

    //add debts
    public void addDebts(double d){
        this.debt += d;
    }

    //when we add a product, we are adjusting our debts and profits
    public void addProductList(Product p){
        listOfProducts.add(p);
        addProfits(p.getSellPrice());
        addDebts(p.getInvestmentCost());
    } //this acts like a setter

    @Override
    public String toString(){
        return "Farmer Name: " + farmerName + "\nFarmName: " + farmName + "\nCurrent Balance: " + getBalance()
                + "\n(Debts: " + debt + " + Profits: " + profit + ")";
    }
}
