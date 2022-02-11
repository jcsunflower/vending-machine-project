package com.techelevator;

public class Products {
    //Instance variables
    private String name, type, slot;
    private static int quantity = 5;
//    private Change price;

    //Constructor
//    public Products(String slot, String name, String type, Change price) {
//        this.slot = slot;
//        this.name = name;
//        this.type = type;
//        this.change = change;
//    }

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

//    public Change getPrice() {
//        return this.price;
//    }

    //Methods
    public void decreaseQuantity() {
        quantity--;
    }

    public static String productSoldOut() {
        if (quantity == 0) {
            return "SOLD OUT";
        }
        else {
            return Integer.toString(quantity);
        }
    }


}
