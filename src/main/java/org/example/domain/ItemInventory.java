package org.example.domain;

import java.math.BigDecimal;

public interface ItemInventory {
    void add(Item item);

    Item fetchItem(String item);

    BigDecimal fetchPrice(String item, int quantity);
}
