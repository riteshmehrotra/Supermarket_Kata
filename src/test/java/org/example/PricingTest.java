package org.example;

import org.example.domain.InMemoryItemInventory;
import org.example.domain.Item;
import org.example.domain.ItemInventory;
import org.example.domain.Order;
import org.example.exceptions.ItemNotFoundException;
import org.example.strategies.BulkPricingStrategy;
import org.example.strategies.PricingStrategy;
import org.example.strategies.UnitPricingStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        PricingStrategy bulkPricingFourMoney = new BulkPricingStrategy(5,new BigDecimal(4), new BigDecimal(1));
        PricingStrategy bulkPricingTenMoney = new BulkPricingStrategy(noOfChocolates,new BigDecimal(10), new BigDecimal(4));
        itemInventory.add(new Item("Milk",unitPriceFiveMoney));
        itemInventory.add(new Item("Bread",unitPriceThreeMoney));
        itemInventory.add(new Item("Chocolates",bulkPricingTenMoney));
        itemInventory.add(new Item("Apple",bulkPricingFourMoney));

        myOrder = new Order(itemInventory);
    }



    @After
    public void tearDown(){
        myOrder = null;
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
    public void test_InvalidItemPurchase_Exception_ThrowsException(){
            myOrder.add("iPhone");
    }

    @Test
    public void test_Different_And_MultipleItemPurchase_At_UnitPrice() {
        myOrder.add("Milk");
        myOrder.add("Milk");
        myOrder.add("Bread");
        assertEquals(new BigDecimal(13), myOrder.total());
    }

    @Test
    public void test_MultipleItemPurchase_At_BulkPrice(){
        myOrder.add("Chocolates");
        myOrder.add("Chocolates");
        myOrder.add("Chocolates");
        assertEquals(new BigDecimal(10), myOrder.total());
    }

    @Test
    public void test_MultipleItemPurchase_At_BulkPrice_WithLessQuantity(){
        myOrder.add("Chocolates");
        myOrder.add("Chocolates");
        assertEquals(new BigDecimal(8), myOrder.total());
    }

    @Test
    public void test_MultipleItemPurchase_At_BulkPrice_WithMoreQuantity(){
        int numberOfChocolates = 16;
        for(int i=0;i<numberOfChocolates;i++){
            myOrder.add("Chocolates");
        }
        assertEquals(new BigDecimal(54), myOrder.total());
    }
    @Test
    public void test_MixedBasketOfMultiplePurchases_At_Unit_And_BulkPricing(){
        myOrder.add("Milk");
        myOrder.add("Milk");
        myOrder.add("Bread");
        myOrder.add("Chocolates");
        myOrder.add("Chocolates");
        myOrder.add("Chocolates");
        myOrder.add("Apple");
        myOrder.add("Apple");
        myOrder.add("Apple");
        myOrder.add("Apple");
        myOrder.add("Apple");
        assertEquals(new BigDecimal(27), myOrder.total());
    }


}
