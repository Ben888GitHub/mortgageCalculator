package com.appmortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int MONTH_IN_YEARS = 12;
        int PERCENT = 100;

        System.out.println("Mortgage Calculator by Benedict Ryan");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        while (true) {
            System.out.print("Principal($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal > 1000 && principal <= 1000000) {
                break;
            }
            System.out.println("Enter value between 1000 and 1000000");
        }

        double annualInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextDouble();
            if (annualInterest > 0 && annualInterest <= 30) {
                break;
            }
            System.out.println("Enter value between 0 and 30");
        }
        double monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEARS;

        int years = 0;
        while (true) {
            System.out.print("Period(Years): ");
            years = scanner.nextInt();
            if (years > 0 && years <= 30) {
                break;
            }
            System.out.println("Enter value between 0 and 30");
        }

        int numberOfPayments = years * MONTH_IN_YEARS;

        double mortgage = principal
                          * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.println("Mortgage: " + currency.format(mortgage));
    }
}
