package org.example.domain;

import java.math.BigDecimal;
import java.util.*;

public class Order {

    private final ItemInventory inventory;
    Map<String, Integer> items;

    public Order(ItemInventory itemInventory) {
        this.inventory = itemInventory;
        items = new HashMap<>();
    }

    public void add(String itemToAdd) {
        if (items.containsKey(itemToAdd)) {
            int currentCounter = items.get(itemToAdd);
            items.put(itemToAdd, currentCounter + 1);
        } else {
            Item item = this.inventory.fetchItem(itemToAdd);
            items.put(item.getName(), 1);
        }
    }

    public BigDecimal total() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            total = total.add(this.inventory.fetchPrice(item.getKey(), item.getValue()));
        }
        return total;
    }
}
