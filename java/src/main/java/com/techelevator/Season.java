package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Season {

    //variables
    private String seasonIndicator;
    public String getSeasonIndicator(){
        return seasonIndicator;
    }

    private String currentSeason;
    public String getCurrentSeason(){
        return currentSeason;
    }

    private List<Crisis> crisisList = new ArrayList<>();
    public void addCrisis(Crisis c){
        crisisList.add(c);
    }
    public void clearCrisis(){
        crisisList.clear();
    }


    //constructor
    public Season(){
        this.currentSeason = "summer";
        this.seasonIndicator = "S";
    }


    //methods:
    //moves through the season
    public void advanceSeason(){
        switch (currentSeason) { //switch statement takes in currentSeason as a parameter, and compares it to the cases.
            case "summer":
                currentSeason = "fall";
                seasonIndicator = "F";
                break;
            case "fall":
                currentSeason = "winter";
                seasonIndicator = "W";
                break;
            case "winter":
                currentSeason = "spring";
                seasonIndicator = "P";
                break;
            case "spring":
                currentSeason = "end";
                seasonIndicator = "E";
                break;
        }
    }

    public void advanceSeasonEnd(){
        currentSeason = "end";
    }

    public Crisis getRandomCrisis(){
        int rnd = new Random().nextInt(crisisList.size());
        return crisisList.get(rnd);
    }
}
