package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine {

    private LogCreator log = new LogCreator();
    private Change change = new Change();
    private List<Product> productsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public VendingMachine() {
        File items = new File("C:\\Users\\Student\\workspace\\capstone-1-team-9\\capstone\\vendingmachine.csv");
        Scanner display = null;
        try {
            display = new Scanner(items);
            while (display.hasNextLine()) {
                String productLine = display.nextLine();
                String[] parts = productLine.split("\\|");
                Product splitProducts = new Product(parts[0], parts[1], new BigDecimal(parts[2]), parts[3]);
                productsList.add(splitProducts);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Getters
    public List<Product> getDisplayItems() {
        return this.productsList;
    }

    //Methods
    public void feedMoneyOption(BigDecimal money) {
        String transactionType = "FEED MONEY: ";
        BigDecimal startBalance = getBalance();
        change.addMoney(money);
        log.writer(transactionType, startBalance, getBalance());
    }

    public String selectProduct(String productCode) {

        BigDecimal startingBalance = getBalance();
        Product selectedProduct = null;
        String itemDispensed, getNoise, printResult;
        int quantityLeft;
        BigDecimal totalCost, moneyRemaining;

        for (Product product : this.productsList) {
            String slot = product.getSlot();
            if (productCode.equalsIgnoreCase(slot)) {
                selectedProduct = product;
                break; //We found our slot code
            }
        }
        if (selectedProduct != null) {
            if (selectedProduct.getQuantity() > 0) {
                if (selectedProduct.getPrice().compareTo(change.getBalance()) <= 0) {
                    change.subtractMoney(selectedProduct.getPrice());
                    selectedProduct.decreaseQuantity();
                    log.writer(selectedProduct.getName() + " " + selectedProduct.getSlot()
                            , startingBalance, getBalance());
                    itemDispensed = selectedProduct.getName();
                    totalCost = selectedProduct.getPrice();
                    moneyRemaining = getBalance();
                    quantityLeft = selectedProduct.getQuantity();
                    getNoise = selectedProduct.getNoise();

                    printResult = String.format("Item dispensed: %s\n" +
                                    "Total cost: $%s\n" +
                                    "Money remaining: $%s\n" +
                                    "Quantity left: %s\n" +
                                    "%s\n", itemDispensed, totalCost, moneyRemaining,
                            quantityLeft, getNoise);
                } else {
                    printResult = "You do not have enough money for this product";
                }
            } else {
                printResult = "This product is sold out";
            }
        } else {
            printResult = "This is not a valid product code";
        }
        return printResult;
    }

    public String finishTransaction() {

        String transactionType = "GIVE CHANGE: ";
        BigDecimal startingBalance = getBalance();
        String result = change.returnChange();
        change.resetBalance();
        log.writer(transactionType, startingBalance, getBalance());
        return result;
    }

    public BigDecimal getBalance() {
        return change.getBalance();
    }

}
