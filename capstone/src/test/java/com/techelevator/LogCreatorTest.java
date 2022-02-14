package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LogCreatorTest {
    LogCreator testWriter = new LogCreator();
    Scanner testScanner = new Scanner("./log.txt");

    @Before
    public void setUp() throws Exception {
        testWriter.writer("Hello World", new BigDecimal("0"), new BigDecimal("100"));
    }

    @Test
    public void test() {
        assertEquals(true, testScanner.hasNextLine());
        testScanner.nextLine();
        assertEquals(false, testScanner.hasNextLine());
    }
}
