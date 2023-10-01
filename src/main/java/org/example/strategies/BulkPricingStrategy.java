package org.example.strategies;

import org.example.exceptions.InvalidPurchaseException;

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
        if(quantity!=applicableQuantity)
            throw new InvalidPurchaseException(String.format("This item can only be purchased in quantities of %d",applicableQuantity));
        return this.price;
    }
}
