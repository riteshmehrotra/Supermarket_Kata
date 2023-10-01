package org.example;

import java.math.BigDecimal;
import java.util.UUID;

public interface ItemInventory {
    void add(Item item);

    Item fetchItem(String item);

    BigDecimal fetchPrice(String item, int quantity);
}
