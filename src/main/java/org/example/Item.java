package org.example;

import java.math.BigDecimal;

public class Item {
    private PricingStrategy pricingStrategy;
    private String name;
    public Item(String name, PricingStrategy strategy) {
        this.pricingStrategy = strategy;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return pricingStrategy.getPrice();
    }

    public String getName() {
        return name;
    }
}
