package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogCreator {

    public void writer(String transactionType, BigDecimal startBalance, BigDecimal endBalance) {

        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();

        try (PrintWriter logCreator = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {
            String printCurrentTime = currentTime.toString().substring(0, currentTime.toString().length() - 4);
            String printCurrentDate = currentDate.toString();
            String printTransactionType = transactionType;
            String printStartBalance = startBalance.toString();
            String printEndBalance = endBalance.toString();

            logCreator.println(printCurrentDate + " " + printCurrentTime + " " +
                    printTransactionType + " $" + printStartBalance + " $" + printEndBalance);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

