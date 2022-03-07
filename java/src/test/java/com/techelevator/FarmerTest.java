package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmerTest {

    //tests for my farmer class

    //method: addProducts
        //test happy path
        //test null?
    @Test
    public void test_template_for_addProductList_method(){          //todo -->name this test for testing the happy path
        //arrange
        Farmer f = new Farmer(); //creating instance of the class
        List<Product> listOfProducts = new ArrayList<>(); //do I need this bc it is in my class
        Product apple = new Product("apple", 20.00, 50.00);
        Product test = new Product("test", 10.00, 30.00);
        //act
        f.addProducts(apple);
        f.addProducts(test);
        //assert --> should have a message as well
        Assert.assertEquals("if addProducts works, debts expected and actual will be equal:", 30.00 , f.getDebt(), .001);
        Assert.assertEquals("if addProducts works, profits expected and actual will be equal: ", 80.00, f.getProfit(), .001);
    }
}
