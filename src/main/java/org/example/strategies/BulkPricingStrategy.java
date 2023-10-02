package org.example.strategies;

import java.math.BigDecimal;

public class BulkPricingStrategy extends UnitPricingStrategy {

    private final int applicableQuantity;
    private final BigDecimal price;

    public BulkPricingStrategy(int applicableQuantity, BigDecimal price, BigDecimal unitPrice) {
        super(unitPrice);
        this.applicableQuantity = applicableQuantity;
        this.price = price;
    }

    @Override
    public BigDecimal getPrice(int quantity) {
        int bulkPriceEligibleQty = Math.floorDiv(quantity, applicableQuantity);
        int unitPriceEligibleQty = quantity - applicableQuantity * bulkPriceEligibleQty;
        BigDecimal total = super.getPrice(unitPriceEligibleQty);
        return total.add(this.price.multiply(BigDecimal.valueOf(bulkPriceEligibleQty)));
    }
}
