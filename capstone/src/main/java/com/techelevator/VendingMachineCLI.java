package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_OPTION_WRITE_SALES_REPORT = "";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,MAIN_MENU_OPTION_WRITE_SALES_REPORT};

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;
    private VendingMachine vendingMachine;
    private Scanner scanner = new Scanner(System.in);


    //Constructor
    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
        vendingMachine = new VendingMachine();
    }

    //Methods

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseOption();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                break;

            } else if(choice.equals(MAIN_MENU_OPTION_WRITE_SALES_REPORT)){
                printSalesReport();
            }
        }
    }

    public void purchaseOption() {

        while (true) {
            System.out.println("Current money provided: " + "$" + vendingMachine.getBalance());
            String purchaseChoices = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            if (purchaseChoices.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                System.out.println("Please choose whole amount ($1, $2, $5 or $10):");
                try {
                    BigDecimal moneyInput = new BigDecimal(scanner.nextLine());
                    if (moneyInput.compareTo(BigDecimal.ZERO) >= 0) {
                        vendingMachine.feedMoneyOption(moneyInput);
                    } else {
                        System.out.println("Cannot feed a negative amount of money");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input is not a valid number");
                }

            } else if (purchaseChoices.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                displayItems();
                System.out.println();
                System.out.println("Please enter the product code: ");
                String productCode = scanner.nextLine();
                System.out.println(vendingMachine.selectProduct(productCode));
            } else if(purchaseChoices.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
                System.out.println(vendingMachine.finishTransaction());
                break;
            }

        }

    }

    public void displayItems() {
        for (Product product : vendingMachine.getDisplayItems()) {
            System.out.print(product.getSlot() + " | ");
            System.out.print(product.getName() + " | ");
            System.out.print(product.getPrice() + " | ");
            System.out.print(product.getType() + " | ");
            System.out.println(product.getQuantity());
        }
    }

    public void printSalesReport(){
        vendingMachine.createSalesReport();
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
