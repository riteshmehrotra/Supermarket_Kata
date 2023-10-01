package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        Item fetchedItem =  items.stream().filter(item->item.getName().equals(inputItem)).findAny()
                .orElseThrow(()->new ItemNotFoundException(String.format("%s not found",inputItem)));
        return  fetchedItem;
    }

    @Override
    public BigDecimal fetchPrice(String item, int quantity) {
        return this.fetchItem(item).getPrice(quantity);
    }
}
