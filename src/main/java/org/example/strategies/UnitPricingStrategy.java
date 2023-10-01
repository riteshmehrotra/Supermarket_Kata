package org.example.strategies;

import java.math.BigDecimal;

public class UnitPricingStrategy implements PricingStrategy {

    private final BigDecimal price;
    public UnitPricingStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice(int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
