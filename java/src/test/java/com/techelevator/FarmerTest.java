package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmerTest {

    @Test
    //farmer balance initialized as 1,000
    public void test_add_products_happy_path(){
        Farmer test = new Farmer();
        Boolean expected = test.gameOver();
        Assert.assertEquals(expected, false);
    }
}
