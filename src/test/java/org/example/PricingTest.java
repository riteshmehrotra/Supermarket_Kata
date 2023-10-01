package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PricingTest {

    Order myOrder;
    ItemInventory itemInventory;

    @Before
    public void setup(){
        itemInventory = new InMemoryItemInventory();
        PricingStrategy unitPriceFiveMoney = new UnitPricingStrategy(new BigDecimal(5));
        PricingStrategy unitPriceThreeMoney = new UnitPricingStrategy(new BigDecimal(3));
        int noOfChocolates = 3;
        PricingStrategy bulkPricingTenMoney = new BulkPricingStrategy(noOfChocolates,new BigDecimal(10));
        itemInventory.add(new Item("Milk",unitPriceFiveMoney));
        itemInventory.add(new Item("Bread",unitPriceThreeMoney));
        itemInventory.add(new Item("Chocolates",bulkPricingTenMoney));
        myOrder = new Order(itemInventory);
    }
    @Test
    public void test_SingleItemPurchase_At_UnitPrice() {
        myOrder.add("Milk");
        assertEquals(new BigDecimal(5), myOrder.total());
    }

    @Test
    public void test_MultipleItemPurchase_At_UnitPrice() {
        myOrder.add("Milk");
        myOrder.add("Milk");
        assertEquals(new BigDecimal(10), myOrder.total());
    }

    @Test
    public void test_EmptyOrder_Total(){
        assertEquals(BigDecimal.ZERO, myOrder.total());
    }

    @Test(expected =  ItemNotFoundException.class)
    public void test_InvalidItemPurchase_Exception(){
            myOrder.add("iPhone");
    }

    @Test
    public void test_Different_And_MultipleItemPurchase_At_UnitPrice() {
        myOrder.add("Milk");
        myOrder.add("Milk");
        myOrder.add("Bread");
        assertEquals(new BigDecimal(13), myOrder.total());
    }


//    @Test
//    public void test_MultipleItemPurchase_At_BulkPrice(){
//        myOrder.add("Chocolates");
//        myOrder.add("Chocolates");
//        myOrder.add("Chocolates");
//        assertEquals(new BigDecimal(10), myOrder.total());
//    }

}
