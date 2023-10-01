package org.example.domain;

import org.example.strategies.PricingStrategy;

import java.math.BigDecimal;

public class Item {
    private final PricingStrategy pricingStrategy;
    private final String name;

    public Item(String name, PricingStrategy strategy) {
        this.pricingStrategy = strategy;
        this.name = name;
    }

    public BigDecimal getPrice(int quantity) {
        return pricingStrategy.getPrice(quantity);
    }

    public String getName() {
        return name;
    }


}
