package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String ONE_DOLLAR = "$1", TWO_DOLLARS = "$2", FIVE_DOLLARS = "$5", TEN_DOLLARS = "$10";
    private static final String[] FEED_MONEY_OPTIONS = {ONE_DOLLAR, TWO_DOLLARS, FIVE_DOLLARS,TEN_DOLLARS};
    private Menu menu;
    private VendingMachine vendingMachine;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
        vendingMachine = new VendingMachine();
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseOption();
            }
        }
    }

    public void displayItems(){
        for( Products product : vendingMachine.getProducts()){
            product.getSlot();
            product.getName();
            product.getPrice();
            product.getType();
        }
    }

    public void purchaseOption(){
        System.out.println("Current money provided ");
        String purchaseChoices = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
        if(purchaseChoices.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
            feedMoneyOptions();
        }
    }

    public void feedMoneyOptions(){
        System.out.println("Please choose the amount;");
        menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
