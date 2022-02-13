package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;


public class VendingMachine {

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private List<Products> products = new ArrayList<>();
    private Menu menuVm = new Menu(System.in, System.out);
    private BigDecimal balance = new BigDecimal(0.00);
    private BigDecimal newBalance = new BigDecimal(0.00);
    Scanner scanner = new Scanner(System.in);

    public VendingMachine() {
        File items = new File("C:\\Users\\Student\\workspace\\capstone-1-team-9\\capstone\\vendingmachine.csv");
        Scanner display = null;
        try {
            display = new Scanner(items);
            while (display.hasNextLine()) {
                String productLine = display.nextLine();
                String[] parts = productLine.split("\\|");
                Products splitProducts = new Products(parts[0], parts[1], new BigDecimal(parts[2]), parts[3]);
                products.add(splitProducts);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Getters
    public List<Products> getProducts() {
        return products;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    //Methods
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


    public void purchaseOption() {

        while (true) {
            System.out.println("Current money provided " + "$" + getBalance());
            String purchaseChoices = (String) menuVm.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            if (purchaseChoices.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                feedMoneyOption();
            } else if (purchaseChoices.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                selectProduct();
            }

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






        }

}
