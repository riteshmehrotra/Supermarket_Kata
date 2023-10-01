package org.example;

import java.math.BigDecimal;

public class BulkPricingStrategy implements PricingStrategy {

    private final int applicableQuantity;
    private final BigDecimal price;
    public BulkPricingStrategy(int applicableQuantity, BigDecimal price) {
        this.applicableQuantity=applicableQuantity;
        this.price = price;
    }

    @Override
    public BigDecimal getPrice(int quantity) {
        return this.price;
    }
}
