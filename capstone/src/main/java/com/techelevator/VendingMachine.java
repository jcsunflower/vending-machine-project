package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachine {

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String ONE_DOLLAR = "$1", TWO_DOLLARS = "$2", FIVE_DOLLARS = "$5", TEN_DOLLARS = "$10";
    private static final String[] FEED_MONEY_OPTIONS = {ONE_DOLLAR, TWO_DOLLARS, FIVE_DOLLARS,TEN_DOLLARS};
    private List<Products> products = new ArrayList<>();
    private Menu menuVm = new Menu(System.in,System.out);
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
    public BigDecimal feedMoney(){
        BigDecimal balance = new BigDecimal(0.00);
        String feedingChoices = (String) menuVm.getChoiceFromOptions(FEED_MONEY_OPTIONS);
        switch(feedingChoices){
            case(ONE_DOLLAR):
                BigDecimal OneDollar = new BigDecimal(1.00);
                balance.add(OneDollar);
            case(TWO_DOLLARS):
                BigDecimal TwoDollars = new BigDecimal(2.00);
                balance.add(TwoDollars);
            case(FIVE_DOLLARS):
                BigDecimal FiveDollars = new BigDecimal(5.00);
                balance.add(FiveDollars);
            case(TEN_DOLLARS):
                BigDecimal TenDollars = new BigDecimal(10.00);
                balance.add(TenDollars);
        }
        return balance;
    }

    public void displayItems(){
        for( Products product : getProducts()){
            System.out.print(product.getSlot()+ " | ");
            System.out.print(product.getName() + " | ");
            System.out.print(product.getPrice() + " | ");
            System.out.println(product.getType() + " | " + Products.productSoldOut());

        }

    }


    public void purchaseOption(){

        while(true) {
            System.out.println("Current money provided " + "$" + balance);
            String purchaseChoices = (String) menuVm.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            if (purchaseChoices.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                feedMoneyOptions();
            }

        }

    }
    public void feedMoneyOptions(){
        System.out.println("Please choose the amount;");
        feedMoney();

    }
}
