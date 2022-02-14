package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {
    VendingMachine vendingMachine = new VendingMachine();
    Change change = new Change();

    @Test
    public void feedMoney_works_as_intended() {
        //Case 1
        vendingMachine.feedMoneyOption(new BigDecimal("5"));
        Assert.assertEquals("Balance does not equal the money applied through feedMoney",
                new BigDecimal("5"), vendingMachine.getBalance());

        //Case 2
        vendingMachine.feedMoneyOption(new BigDecimal("10"));
        Assert.assertEquals("Balance does not equal the money applied through feedMoney",
                new BigDecimal("15"), vendingMachine.getBalance());
    }

    @Test
    public void selectProduct_works_as_intended() {
        //Case 1
        vendingMachine.feedMoneyOption(new BigDecimal("10"));
        String actual = vendingMachine.selectProduct("B3");
        String expected = String.format("Item dispensed: %s\n" +
                        "Total cost: $%s\n" +
                        "Money remaining: $%s\n" +
                        "Quantity left: %s\n" +
                        "%s\n", "Wonka Bar", new BigDecimal("1.50"), new BigDecimal("8.50"),
                4, "Munch Munch, Yum!");
        Assert.assertEquals("Did not produce the correct string of information", expected, actual);

        //Case 2
        vendingMachine.finishTransaction();
        String actual2 = vendingMachine.selectProduct("B3");
        String expected2 = "You do not have enough money for this product";
        Assert.assertEquals("Did not produce the correct string of information", expected2, actual2);

        //Case 3
        vendingMachine.feedMoneyOption(new BigDecimal("10"));
        vendingMachine.selectProduct("B3");
        vendingMachine.selectProduct("B3");
        vendingMachine.selectProduct("B3");
        vendingMachine.selectProduct("B3");
        String actual3 = vendingMachine.selectProduct("B3");
        String expected3 = "This product is sold out";
        Assert.assertEquals("Did not produce the correct string of information", expected3, actual3);

        //Case 4
        String expected4 = "This is not a valid product code";
        String actual4 = vendingMachine.selectProduct("whoops");
        Assert.assertEquals("Did not produce the correct string of information", expected4, actual4);
    }

    @Test
    public void finishTransaction_works_as_intended() {
        vendingMachine.feedMoneyOption(new BigDecimal("1"));
        String expected = "Change that you are receiving: " + 4 + " quarters, " + 0 + " dimes, " + 0 + " nickels.";
        String actual = vendingMachine.finishTransaction();
        Assert.assertEquals("Did not produce the correct output string", expected, actual);
        Assert.assertEquals("Did not produce the correct balance", new BigDecimal("0"),
                vendingMachine.getBalance());

    }
}
