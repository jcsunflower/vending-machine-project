package com.techelevator;

import java.math.BigDecimal;

public enum FeedingMoney {

    ONE(new BigDecimal(1.00)), TWO(new BigDecimal(2.00)), FIVE(new BigDecimal(5.00)), TEN(new BigDecimal(10.00));

    private BigDecimal moneyForFeeding;

    FeedingMoney(BigDecimal moneyForFeeding){
        this.moneyForFeeding = moneyForFeeding;
    }

    public BigDecimal getMoneyForFeeding() {
        return moneyForFeeding;
    }
}
