package com.company;

public class Main {

    public static void main(String[] args) {
       int Principal = (int) Console.readNumber("Principal:",1_000,1_000_000);
       float Interest = (float) Console.readNumber("Annual Interest Rate:",1,30);
       int Period = (int) Console.readNumber("Period(in Years):",0,30);


       MortgageCalculator calculator = new MortgageCalculator(Principal,Interest,Period);
        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
