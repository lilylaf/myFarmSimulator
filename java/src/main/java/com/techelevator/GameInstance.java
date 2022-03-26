package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameInstance {

    private Scanner in;
    private Farmer f;
    private Season s;


    //constructor
    public GameInstance (InputStream input) {
        this.in = new Scanner(input);
        this.f = new Farmer();
        this.s = new Season();
    }

    public void run(){
        startup();
        seasonLoop();
    }

    //start up the game, prompt user for farmer name and farm name.
    public void startup(){
        File s = new File("files/startup.txt");
        try(Scanner scanFile = new Scanner(s)) {
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                if(line.charAt(0) == '*'){
                    System.out.println(line.substring(1));
                    f.setFarmerName(in.nextLine());
                } else if (line.charAt(0) == '~'){
                    System.out.println(line.substring(1));
                    f.setFarmName(in.nextLine());
                } else {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //season reader
    public void seasonReader(){
        File script = new File("files/script_" + s.getCurrentSeason() + ".txt");
        try(Scanner scanFile = new Scanner(script)) {
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                if(line.charAt(0) == '*'){
                   convertInput(convertToProductList(line));
                } else if (line.charAt(0) == '~'){
                    crisisMode(s.getRandomCrisis());
                } else {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Product> convertToProductList(String lineFromFile) {
		List<Product> allProducts = new ArrayList<>();
		String[] stringOfProducts = lineFromFile.split(" ");
		for(String p : stringOfProducts){
			String[] splitProducts = p.split("\\|");
			allProducts.add(new Product(splitProducts[0], Double.parseDouble(splitProducts[1]), Double.parseDouble(splitProducts[2])));
		}
		return allProducts;
	}

    public void convertInput(List<Product> allProducts){ //todo -> loop through the options until the choice is correct
        Product p = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.parseInt(userInput);
            if (selectedOption > 0 && selectedOption <= allProducts.size()) {
                p = allProducts.get(selectedOption - 1);
            }
        } catch (NumberFormatException e) {
            //an error message will be displayed below since p will be null
        }
        if (p == null) {
            System.out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
        }
        f.addProductList(p);
    }

    private void setCurrentCrisisList() {
        s.clearCrisis();
        File crisisFile = new File("files/crisis.txt");
        try(Scanner scanFile = new Scanner(crisisFile)) {
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                String[] splitCrisis = line.split("\\|");
                if(splitCrisis[0].contains(s.getSeasonIndicator())){
                    s.addCrisis(new Crisis(splitCrisis[1], Double.parseDouble(splitCrisis[2])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void crisisMode(Crisis c) {
        System.out.println(c);
        f.addDebts(c.getCost());
    }

    private void seasonLoop(){
        while(!Objects.equals(s.getCurrentSeason(), "end")){ //while currentSeason != "end
            setCurrentCrisisList();
            seasonReader();
            //todo -> display season stats after each season (maybe different for win/lose?)
            if(f.gameOver()){ //if gameOver == true
                s.advanceSeasonEnd();
            } else{
                s.advanceSeason();
            }
        }
    }

    //user stats after each season ends
}
