package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class VendingMachine {

    private Products products;
    private LogCreator log;
    private Change change;

    public VendingMachine() {

    }



    //Methods
    public void readAndSplitItems(){
        File items = new File("C:\\Users\\Student\\workspace\\capstone-1-team-9\\capstone\\vendingmachine.csv");
        Scanner display = null;
        try {
            List<Products> productsList = new ArrayList<>();
            display = new Scanner(items);
            while (display.hasNextLine()) {
                String productLine = display.nextLine();
                String[] parts = productLine.split("\\|");
                Products splitProducts = new Products(parts[0], parts[1], new BigDecimal(parts[2]), parts[3]);
                productsList.add(splitProducts);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public BigDecimal feedMoney(BigDecimal input) {

        BigDecimal tempBalance = new BigDecimal("0.00");
        tempBalance = tempBalance.add(input);
        return tempBalance;
    }

    public void displayItems() {
        for (Products product : getProducts()) {
            System.out.print(product.getSlot() + " | ");
            System.out.print(product.getName() + " | ");
            System.out.print(product.getPrice() + " | ");
            System.out.print(product.getType() + " | ");
            System.out.println(product.getQuantity());

        }

    }

    public void feedMoneyOption() {
        System.out.println("Please choose whole amount ($1, $2, $5 or $10):");
        BigDecimal moneyInput = new BigDecimal(scanner.nextLine());
        balance = balance.add(feedMoney(moneyInput));
    }

    public void selectProduct() {
        if (getBalance().equals("0.00")) {
            System.out.println("Your current balance: 0, please add money for purchase");
        }
        displayItems();
        System.out.println();
        System.out.println("Please enter the product code: ");
        String productCode = scanner.nextLine();

        String slot;

        for (Products product : getProducts()) {
            slot = product.getSlot();
            if (!slot.equalsIgnoreCase(productCode)) {
                System.out.println("Please enter a valid code.");
                break;
            } else if (slot.equalsIgnoreCase(productCode)) {
                String name = product.getName();
                BigDecimal price = new BigDecimal(String.valueOf(product.getPrice()));
                balance = balance.subtract(product.getPrice());
                if (slot.equalsIgnoreCase("A1") || slot.equalsIgnoreCase("A2") ||
                        slot.equalsIgnoreCase("A3") || slot.equalsIgnoreCase("A4")) {
                    System.out.println(name + " " + price + " " + getBalance());
                    System.out.println("Crunch Crunch, Yum!");
                } else if (slot.equalsIgnoreCase("B1") || slot.equalsIgnoreCase("B2") ||
                        slot.equalsIgnoreCase("B3") || slot.equalsIgnoreCase("B4")) {
                    System.out.println(name + " " + price + " " + getBalance());
                    System.out.println("Munch Munch, Yum!");
                }else if (slot.equalsIgnoreCase("C1") || slot.equalsIgnoreCase("C2") ||
                        slot.equalsIgnoreCase("C3") || slot.equalsIgnoreCase("C4")) {
                    System.out.println(name + " " + price + " " + getBalance());
                    System.out.println("Gluk Gluk, Yum!");
                }else if (slot.equalsIgnoreCase("D1") || slot.equalsIgnoreCase("D2") ||
                        slot.equalsIgnoreCase("D3") || slot.equalsIgnoreCase("D4")) {
                    System.out.println(name + " " + price + " " + getBalance());
                    System.out.println("Chew Chew, Yum!");
                }
                break;
            }



        }
    }

    public void finishTransaction(){
        File logFile = new File("log.txt");

        String dateAndTime = new SimpleDateFormat("MM/dd/yy hh:mm:ss a").format(new Date());

    }

}
