package com.company;


import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator)
    {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }



    public  void printMortgage() {
        double Mortgage = calculator.calculateMortage();
        String mortgageCurrency = currency.format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + mortgageCurrency);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
       for(double balance: calculator.getRemainingBalances())
           System.out.println(currency.format(balance));
    }
}
