package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class VendingMachine {

    private Product products;
    private LogCreator log;
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

//    public BigDecimal feedMoney(BigDecimal input) {
//
//        BigDecimal tempBalance = new BigDecimal("0.00");
//        tempBalance = tempBalance.add(input);
//        return tempBalance;
//    }

    public void feedMoneyOption(BigDecimal money) {
        String transactionType = "FEED MONEY";
        BigDecimal startBalance = getBalance();
        if (money.compareTo(BigDecimal.ZERO) >= 0) {
            change.addMoney(money);
            log.writer(transactionType, startBalance, getBalance());
        } else {
            System.out.println("Invalid money input");
        }
    }

    public void selectProduct(String productCode) {

        BigDecimal startingBalance = getBalance();
        Product selectedProduct = null;
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
                    log.writer(selectedProduct.getName(), startingBalance, getBalance());
                    System.out.println("Item dispensed: " + selectedProduct.getName());
                    System.out.println("Total cost: $" + selectedProduct.getPrice());
                    System.out.println("Money remaining: $" + change.getBalance());
                    System.out.println("Quantity Left: " + selectedProduct.getQuantity());
                    System.out.println(selectedProduct.getNoise());
                    System.out.println();
                } else {
                    System.out.println("You do not have enough money for this product");
                }
            } else {
                System.out.println("This product is sold out");
            }
        } else {
            System.out.println("This is not a valid product code");
        }
    }

    public void finishTransaction() {
        change.returnChange(getBalance());
        change.resetBalance();
    }

    public BigDecimal getBalance() {
        return change.getBalance();
    }

}
