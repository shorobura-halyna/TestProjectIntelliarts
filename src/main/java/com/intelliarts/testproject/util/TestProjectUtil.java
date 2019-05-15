package com.intelliarts.testproject.util;

import com.intelliarts.testproject.model.Operation;

import java.util.Scanner;

public class TestProjectUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Enter PURCHASE - add purchases");
        System.out.println("Enter ALL - shows all purchases");
        System.out.println("Enter CLEAR - removes all purchases for specified date");
        System.out.println("Enter REPORT - to see purchases by year");
        System.out.println("Enter EXIT fot exit");
    }

    public static Operation getOperation(String operation) {
        return Operation.valueOf(operation.toUpperCase());
    }

    public static String getUserData() {
        return scanner.nextLine();
    }

}
