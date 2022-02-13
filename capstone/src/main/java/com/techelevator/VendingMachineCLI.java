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
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;
    private VendingMachine vendingMachine;


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
                vendingMachine.displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseOption();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println(0);
            }
        }
    }

    public void purchaseOption() {

        while (true) {
            Change change = new Change();
            System.out.println("Current money provided " + "$" + change.getBalance());
            String purchaseChoices = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            if (purchaseChoices.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                vendingMachine.feedMoneyOption();
            } else if (purchaseChoices.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                vendingMachine.selectProduct();
            } else if(purchaseChoices.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
                vendingMachine.finishTransaction();
            }

        }

    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
