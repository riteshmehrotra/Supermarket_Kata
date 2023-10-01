package org.example;

public interface ItemInventory {
    void add(Item item);

    Item fetchItem(String item);
}
