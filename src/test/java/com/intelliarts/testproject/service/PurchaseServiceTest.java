package com.intelliarts.testproject.service;

import com.intelliarts.testproject.model.Product;
import com.intelliarts.testproject.model.Purchase;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PurchaseServiceTest {
    private  Map<LocalDate, List<Purchase>> map;
    private PurchaseService purchaseService;

    @Before
    public void setUp(){
        map = new HashMap<>();
        purchaseService = new PurchaseService();
        List<Purchase> purchases = new ArrayList <>();
        purchases.add(new Purchase(new Product("T-shirt", 55, "UAH"), LocalDate.parse("2019-04-25")));
        purchases.add(new Purchase(new Product("jeans", 55, "USD"), LocalDate.parse("2019-04-25")));
        purchases.add(new Purchase(new Product("coat", 55, "EUR"), LocalDate.parse("2019-04-25")));

        map.put(LocalDate.parse("2019-04-25"), purchases);
    }

    @Test
    public void addPurchasesToExistedDateTest(){
        purchaseService.addPurchase(map, new String[]{"purchase", "2019-04-25", "95", "UAH", "sweeter"});
        assertEquals(4, map.get(LocalDate.parse("2019-04-25")).size());
    }

    @Test
    public void addPurchasesToNewDate(){
        purchaseService.addPurchase(map, new String[]{"purchase", "2019-04-26", "95", "UAH", "sweeter"});
        assertEquals(1, map.get(LocalDate.parse("2019-04-26")).size());
    }


}