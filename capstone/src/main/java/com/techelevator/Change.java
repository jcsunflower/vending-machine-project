package com.techelevator;

import java.math.BigDecimal;

public class Change {

    private BigDecimal balance = new BigDecimal("0");

    private BigDecimal salesReportBalance = new BigDecimal("0");

    public Change() {
        this.balance = balance;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public BigDecimal getSalesReportBalance(){ return salesReportBalance; }

    public void addMoney(BigDecimal addAmount ){
        balance = balance.add(addAmount);
    }

    public void subtractMoney(BigDecimal subtractAmount){
        balance = balance.subtract(subtractAmount);
    }

    public void addMoneyToSalesReportBalance(BigDecimal addMoneySr){salesReportBalance.add(addMoneySr);}

    public void resetBalance() {
        balance = BigDecimal.ZERO;
    }


    public String returnChange(){
        BigDecimal totalChange = balance;
        BigDecimal nickel = new BigDecimal("0.05");
        BigDecimal dime = new BigDecimal("0.1");
        BigDecimal quarter = new BigDecimal("0.25");
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;

        while(totalChange.compareTo(BigDecimal.ZERO) != 0){
            if ( totalChange.compareTo(quarter) >= 0 ){
                totalChange = totalChange.subtract(quarter);
                quarters++;
            } else if (totalChange.compareTo(dime) >= 0){
                totalChange = totalChange.subtract(dime);
                dimes++;
            } else if(totalChange.compareTo(nickel) >= 0){
                totalChange = totalChange.subtract(nickel);
                nickels++;
            }
        }
        return "Change that you are receiving: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.";
    }


}
