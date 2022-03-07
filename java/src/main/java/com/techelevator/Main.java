package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		Farmer f = new Farmer();

		//call file reader method
		//f.setFarmerName(inputScanner.nextLine()); //this is on line 2 of file
		//call file reader method
		//f.setFarmName(inputScanner.nextLine()); //this is on line 4 of file
		//call file reader method
		//String firstCropSelection = inputScanner.nextLine();//this is on line 5 of the file
		//call evaluate user selection
		//get our product from the convertToProductMethod

		System.out.println(evaluateUserSelection("Strawberries", convertToProductList("Strawberries|10.00|100.00 Blueberries|10.00|100.00 Blackberries|10.00|100.00")));


		//System.out.println("Welcome " + f.getFarmerName()); //todo --> this is from old version of code, will probably delete later
		//System.out.println(f);
	}
	//evaluate user selection
	public static Product evaluateUserSelection(String userCropSelection, List<Product> allProducts){ //todo DO THIS STEP NEXT :)
		//todo --> convert userCropSelection from string/int into arrayList location of allProducts

		for (Product p : allProducts) {
			if (userCropSelection.equals(p.getProductName())){
				return p;
			}
		}
		return new Product("invalid",0.00,0.00);
	}

	//convert our string array into a product array
	public static List<Product> convertToProductList(String fromFile) {
		List<Product> allProducts = new ArrayList<>();
		String[] stringOfProducts = fromFile.split(" ");
		for(String p : stringOfProducts){
			String[] splitProducts = p.split("\\|");
			allProducts.add(new Product(splitProducts[0], Double.parseDouble(splitProducts[1]), Double.parseDouble(splitProducts[2])));
		}
		return allProducts;
	}



	//read the file and display the output to the user
	public static void fileReader(){ //todo --> this needs to convert userInput for products from a string ->  number location in our allProducts array
		//this will loop through the entire file
		//at each line, it will determine what method to call in order to perform the needed action
	}
}
//todo once I get this working, I need to create my crisis class with the random number generator!
