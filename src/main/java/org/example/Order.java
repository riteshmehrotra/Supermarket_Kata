package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

    private final ItemInventory inventory;
    List<String> items;

    public Order(ItemInventory itemInventory) {
        this.inventory = itemInventory;
        items = new ArrayList<>();
    }

    public void add(String itemToFind) {
        Item item = this.inventory.fetchItem(itemToFind);
        //Change: Changed collection type from Item to String to record name only
        //TODO: Record item reference instead of name
        items.add(item.getName());
    }

    public BigDecimal total() {
        BigDecimal total = BigDecimal.ZERO;
        //TODO: The Order still calculates the price for each item (Forcing Unit pricing). The logic needs to be encapsulated away in Item class
        for (String item : items) {
            total = total.add(this.inventory.fetchPrice(item,1)); //TODO: Hardcoded 1 to comply with Order's current behaviour
        }
        return total;
    }
}
