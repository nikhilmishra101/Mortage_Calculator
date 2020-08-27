package com.company;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static int month_In_Years = 12;
    final static int Percent = 100;

    public static void main(String[] args) {
       int Principal = (int)readNumber("Principal:",1_000,1_000_000);
       float Interest = (float)readNumber("Annual Interest Rate:",1,30);
       int Period = (int)readNumber("Period(in Years):",0,30);

        printMortgage(Principal, Interest, Period);
        printPaymentSchedule(Principal, Interest, Period);
    }

    private static void printMortgage(int principal, float interest, int period) {
        double Mortgage = calculateMortage(principal, interest, period);
        String mortgageCurrency = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + mortgageCurrency);
    }

    private static void printPaymentSchedule(int principal, float interest, int period) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for(short month = 1; month <= period * month_In_Years; month++)
        {
            double balance = calculateBalance(principal, interest, period,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt,double min,double max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.println(prompt);

            value = scanner.nextFloat();
            if (value > min && value <= max) {
                break;
            } else
                System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;

    }

    public static double calculateMortage(int Principal,
                                          float Interest,
                                          int Period) {

        float monthlyInterest = (Interest / Percent) / month_In_Years;
        float numberOfPayments = (short)(Period*month_In_Years);
        double Mortage = Principal * (
                monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));


        return Mortage;

    }
    public static double calculateBalance(int Principal,
                                          float Interest,
                                          int Period,
                                          short numberOfPayementsMade)
    {

        float monthlyInterest = (Interest / Percent) / month_In_Years;
        float numberOfPayments = (short)(Period*month_In_Years);

        double Balance = Principal
                *(Math.pow(1 + monthlyInterest,numberOfPayments) -
                Math.pow(1 + monthlyInterest,numberOfPayementsMade)
         )/(Math.pow(1 + monthlyInterest,numberOfPayments) - 1);

        return Balance;
    }
}
