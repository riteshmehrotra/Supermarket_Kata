package org.example;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemInventory implements ItemInventory {

    List<Item> items;

    public InMemoryItemInventory(){
        items = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public Item fetchItem(String inputItem) {
        return items.stream().filter(item->item.getName().equals(inputItem)).findAny()
                .orElseThrow(()->new ItemNotFoundException(String.format("%s not found",inputItem)));
    }
}
