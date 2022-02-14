package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void decreaseQuantity_works_as_intended() {

        //Arrange
        BigDecimal sunChipsPrice = new BigDecimal("2");
        Product sunChips = new Product("A1", "Sun Chips", sunChipsPrice, "Chip");
        sunChips.decreaseQuantity();
        int expected = 4;

        //Act
        int actual = sunChips.getQuantity();

        //Assert
        Assert.assertEquals("Did not get expected quantity amount", expected, actual);
    }

    @Test
    public void getNoise_works_as_intended() {
        //Case 1
        Product chipsTest = new Product("A1", "Potato Chips", new BigDecimal("1.50"), "Chip");
        String expected = "Crunch Crunch, Yum!";
        String actual = chipsTest.getNoise();

        //Case 2
        Product candyTest = new Product("B1", "Chocolate Bar", new BigDecimal("1.50"), "Candy");
        String expected2 = "Munch Munch, Yum!";
        String actual2 = candyTest.getNoise();

        //Case 3
        Product drinkTest = new Product("C1", "Orange Soda", new BigDecimal("1.50"), "Drink");
        String expected3 = "Glug Glug, Yum!";
        String actual3 = drinkTest.getNoise();

        //Case 4
        Product gumTest = new Product("D1", "Bubble Gum", new BigDecimal("1.50"), "Gum");
        String expected4 = "Chew Chew, Yum!";
        String actual4 = gumTest.getNoise();

        //Case 5
        Product edgeCaseTest = new Product("Who Knows", "Random", new BigDecimal("1.50"), "Invalid");
        String expected5 = "";
        String actual5 = edgeCaseTest.getNoise();

        //Assert
        Assert.assertEquals("Did not get the correct noise", expected, actual);
        Assert.assertEquals("Did not get the correct noise", expected2, actual2);
        Assert.assertEquals("Did not get the correct noise", expected3, actual3);
        Assert.assertEquals("Did not get the correct noise", expected4, actual4);
        Assert.assertEquals("Did not get the correct noise", expected5, actual5);
    }
}
