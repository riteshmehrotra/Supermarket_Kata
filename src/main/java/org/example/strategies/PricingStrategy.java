package org.example.strategies;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice(int quantity);
}
