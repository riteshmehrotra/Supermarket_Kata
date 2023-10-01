package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final ItemInventory inventory;
    List<Item> items;

    public Order(ItemInventory itemInventory) {
        this.inventory = itemInventory;
        items = new ArrayList<>();
    }

    public void add(String itemToFind) {
        Item item = this.inventory.fetchItem(itemToFind);
        items.add(item);
    }

    public BigDecimal total() {
        return items.stream().map(Item::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
