package org.example;

import java.math.BigDecimal;

public class UnitPricingStrategy implements PricingStrategy {

    private final BigDecimal price;
    public UnitPricingStrategy(BigDecimal price) {
        this.price = price;
    }


    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
