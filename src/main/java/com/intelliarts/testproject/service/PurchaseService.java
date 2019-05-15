package com.intelliarts.testproject.service;

import com.intelliarts.testproject.model.Product;
import com.intelliarts.testproject.model.Purchase;

import java.time.LocalDate;
import java.util.*;

public class PurchaseService {

    public void showPurchasesAmountByYear(Map <LocalDate, List <Purchase>> purchases, String[] parameters) {
        int year = Integer.parseInt(parameters[1]);
        String currency = parameters[2];
        double amount = 0;
        for (LocalDate localDate : purchases.keySet()) {
            if (localDate.getYear() == year) {
                List <Purchase> purchaseList = purchases.get(localDate);
                for (Purchase purchase : purchaseList) {
                    amount += convert(purchase.getProduct().getCurrency(), currency, purchase.getProduct().getPrice());
                }
            }
        }
        System.out.println(amount + " " + currency);
    }

    public void showPurchasesSortedByDate(Map <LocalDate, List <Purchase>> purchases) {
        Map <LocalDate, List <Purchase>> sortedMap = new TreeMap <>(LocalDate::compareTo);
        sortedMap.putAll(purchases);
        showAllPurchases(sortedMap);
    }

    public void addPurchase(Map <LocalDate, List <Purchase>> purchases, String[] parameters) {
        LocalDate date = LocalDate.parse(parameters[1]);
        double price = Double.parseDouble(parameters[2]);
        String currency = parameters[3];
        String nameOfTheProduct = parameters[4];
        if (purchases.get(date) == null) {
            List <Purchase> purchasesList = new ArrayList <>();
            purchasesList.add(new Purchase(new Product(nameOfTheProduct, price, currency), date));
            purchases.put(date, purchasesList);
        } else {
            purchases.get(date).add(new Purchase(new Product(nameOfTheProduct, price, currency), date));
        }
        showAllPurchases(purchases);
        if (purchases.isEmpty()) {
            System.out.println("We don't have any purchases");
        }
    }

    public void clearPurchasesByDate(Map <LocalDate, List <Purchase>> purchases, String parameter) {
        LocalDate date = LocalDate.parse(parameter);
        purchases.remove(date);
        showAllPurchases(purchases);
    }

    private void showAllPurchases(Map <LocalDate, List <Purchase>> purchases) {
        for (LocalDate localDate : purchases.keySet()) {
            System.out.println(localDate);
            List <Purchase> purchasesList = purchases.get(localDate);
            for (Purchase purchase : purchasesList) {
                System.out.println(purchase.getProduct().getName() + " " + purchase.getProduct().getPrice() + " " + purchase.getProduct().getCurrency());
            }
        }
    }

    private double convert(String fromCurrency, String toCurrency, double amount) {
        // call to fixed.io API and get rates for currencies
        return amount;
    }

}
