package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogCreator {

    public void writer(String transactionType, BigDecimal startBalance, BigDecimal endBalance) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (PrintWriter logCreator = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {
            String printDateAndTime = dateFormatter.format(LocalDateTime.now());
            String printTransactionType = transactionType;
            String printStartBalance = startBalance.toString();
            String printEndBalance = endBalance.toString();

            logCreator.println(printDateAndTime + " " +
                    printTransactionType + " $" + printStartBalance + " $" + printEndBalance);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void salesReportWriter(Product product, int salesReportQuantity, BigDecimal finalTransactionAmount) {
        try (PrintWriter salesReport = new PrintWriter(new PrintWriter(new FileOutputStream("./salesReport.txt")))) {
            VendingMachine vm = new VendingMachine();
            int printSalesReportQuantity = salesReportQuantity;
            BigDecimal printFinalTransactionAmount = finalTransactionAmount;
            for(Product newProduct : vm.getDisplayItems() ) {
                String productName = newProduct.getName();
                salesReport.println(productName + "|" + printSalesReportQuantity);
            }
            salesReport.println("TOTAL SALES: " + printFinalTransactionAmount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

