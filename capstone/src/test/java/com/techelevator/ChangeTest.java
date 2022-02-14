package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChangeTest {

    //Initializing Change for testing
    Change change = new Change();

    @Test
    public void addMoney_works_as_intended() {
        //Arrange
        BigDecimal payment = new BigDecimal("5000");
        change.addMoney(payment);
        BigDecimal expected = change.getBalance(); //Case 1

        BigDecimal dockedPay = new BigDecimal("4000");
        change.addMoney(dockedPay);
        BigDecimal expected2 = change.getBalance(); //Case 2

        //Act
        BigDecimal actual = new BigDecimal("5000");
        BigDecimal actual2 = new BigDecimal("9000");

        //Assert
        Assert.assertEquals("Did not get expected balance", expected, actual);
        Assert.assertEquals("Did not get expected balance", expected2, actual2);
    }

    @Test
    public void subtractMoney_works_as_intended() {
        //Arrange
        BigDecimal balance = new BigDecimal("50000");
        change.addMoney(balance);
        BigDecimal speedboatPayment = new BigDecimal("20000");
        change.subtractMoney(speedboatPayment);
        BigDecimal expected = change.getBalance(); //Case 1

        BigDecimal overdraft = new BigDecimal("40000");
        change.subtractMoney(overdraft);
        BigDecimal expected2 = change.getBalance(); //Case 2

        //Act
        BigDecimal actual = new BigDecimal("30000");
        BigDecimal actual2 = new BigDecimal("-10000");

        //Assert
        Assert.assertEquals("Did not get expected balance", expected, actual);
        Assert.assertEquals("Did not get expected balance", expected2, actual2);

    }

    @Test
    public void resetMoney_works_as_intended() {
        //Arrange
        BigDecimal balance = new BigDecimal("2000");
        change.addMoney(balance);
        change.resetBalance();
        BigDecimal expected = change.getBalance(); //Case 1
        change.subtractMoney(balance);
        change.resetBalance();
        BigDecimal expected2 = change.getBalance(); //Case 2

        //Act
        BigDecimal actual = new BigDecimal("0");

        //Assert
        Assert.assertEquals("Did not get correct balance", expected, actual);
        Assert.assertEquals("Did not get correct balance", expected2, actual);
    }

    @Test
    public void returnChange_works_as_intended() {
        //Case 1
        BigDecimal balance = new BigDecimal("1.45");
        change.addMoney(balance);
        String expected = "Change that you are receiving: " + 5 + " quarters, " + 2 + " dimes, " + 0 + " nickels.";
        String actual = change.returnChange();

        //Case 2
        BigDecimal withdraw = new BigDecimal("1.30");
        change.subtractMoney(withdraw);
        String expected2 = "Change that you are receiving: " + 0 + " quarters, " + 1 + " dimes, " + 1 + " nickels.";
        String actual2 = change.returnChange();

        //Assert
        Assert.assertEquals("Did not get expected count of coins", expected, actual);
        Assert.assertEquals("Did not get expected count of coins", expected2, actual2);
    }
}
