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
    private static final String[] FEED_MONEY_OPTIONS = {"$1", "$2", "$5","$10"};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
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
        File items = new File("C:\\Users\\Student\\workspace\\capstone-1-team-9\\capstone\\vendingmachine.csv");
        Scanner display = null;
        try {
            display = new Scanner(items);
            while (display.hasNextLine()) {
                System.out.println(display.nextLine() + "|" + Products.productSoldOut());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
