package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachine {

    private List<Products> products = new ArrayList<>();
    private BigDecimal balance;

    public VendingMachine(){
        File items = new File("C:\\Users\\Student\\workspace\\capstone-1-team-9\\capstone\\vendingmachine.csv");
        Scanner display = null;
        try {
            display = new Scanner(items);
            while (display.hasNextLine()) {
               String productLine = display.nextLine();
               String[] parts = productLine.split("\\|");
               Products productss = new Products(parts[0], parts[1], new BigDecimal(parts[2]), parts[3]);
               products.add(productss);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Products> getProducts() {
        return products;
    }
    public BigDecimal feedMoney(BigDecimal amount){
        balance = balance.add(amount);
        return balance;
    }
}
