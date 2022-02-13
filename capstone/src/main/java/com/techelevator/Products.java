package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class Products {
    //Instance variables
    private String name, type, slot;
    private int quantity = 5;
    private BigDecimal price;

    //Constructor
    public Products(String slot, String name,BigDecimal price,String type) {
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

    //Methods
    public void decreaseQuantity(Products newProduct) {
        int newQuantity = newProduct.getQuantity() - 1;
    }







}
