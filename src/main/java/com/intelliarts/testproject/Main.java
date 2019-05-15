package com.intelliarts.testproject;

import com.intelliarts.testproject.model.Purchase;
import com.intelliarts.testproject.service.PurchaseService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.intelliarts.testproject.util.TestProjectUtil.*;

public class Main {

    public static void main(String[] args) {
        PurchaseService purchaseService = new PurchaseService();
        Map <LocalDate, List <Purchase>> purchases = new HashMap <>();

        boolean work = true;
        while (work) {
            menu();
            String data = getUserData();
            String[] parameters = data.split(" ");
            String operation = parameters[0];
            switch (getOperation(operation)) {
                case PURCHASE: {
                    purchaseService.addPurchase(purchases, parameters);
                    break;
                }
                case ALL: {
                    purchaseService.showPurchasesSortedByDate(purchases);
                    break;
                }
                case CLEAR: {
                    purchaseService.clearPurchasesByDate(purchases, parameters[1]);
                    break;
                }
                case REPORT: {
                    purchaseService.showPurchasesAmountByYear(purchases, parameters);
                    break;
                }
                case EXIT: {
                    work = false;
                    break;
                }
                default: {
                    System.out.println("input error");
                }
            }
        }
    }
}
