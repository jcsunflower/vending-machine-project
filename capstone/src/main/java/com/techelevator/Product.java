package com.techelevator;

import java.math.BigDecimal;

public class Product {
    //Instance variables
    private String name, type, slot;
    private int quantity = 5;
    private BigDecimal price;
    private int salesReportQuantity = 0;

    //Constructor
    public Product(String slot, String name, BigDecimal price, String type) {
        this.slot = slot;
        this.name = name;
        this.type = type;
        this.price = price;;
    }

    //Getters
    public String getSlot() {
        return this.slot;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getSalesReportQuantity(){ return this.salesReportQuantity;}
    //Methods
    public void decreaseQuantity() {
        quantity--;
    }

    public void increaseSalesReportQuantity() { salesReportQuantity++;}

    public String getNoise() {
        String noise = "";

        if (type.equals("Chip")) {
            noise = "Crunch Crunch, Yum!";
        }
        else if (type.equals("Candy")) {
            noise = "Munch Munch, Yum!";
        }
        else if (type.equals("Drink")) {
            noise = "Glug Glug, Yum!";
        }
        else if (type.equals("Gum")) {
            noise = "Chew Chew, Yum!";
        }
        return noise;
    }







}
