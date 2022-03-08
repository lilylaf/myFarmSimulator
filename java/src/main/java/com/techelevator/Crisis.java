package com.techelevator;

public class Crisis {
    //variables
    private String scenario;
    private double cost;
    public double getCost() {return this.cost;}

    //constructor
    public Crisis(String scenario, double cost){
        this.scenario = scenario;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return scenario;
    }
}
