package com.techelevator;

import java.math.BigDecimal;

public class Products {
    //Instance variables
    private String name, type, slot;
    private static int quantity = 5;
    private BigDecimal price;

    //Constructor
    public Products(String slot, String name,BigDecimal price,String type) {
        this.slot = slot;
        this.name = name;
        this.type = type;
        this.price = price;
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

    //Methods
    public void decreaseQuantity() {
        quantity--;
    }

    public static String productSoldOut() {
        if (quantity == 0) {
            return "SOLD OUT";
        } else {
            return Integer.toString(quantity);
        }
    }


}
