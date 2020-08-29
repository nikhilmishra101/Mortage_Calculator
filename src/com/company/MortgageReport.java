package com.company;


import java.text.NumberFormat;

public class MortgageReport {

    public MortgageReport(MortgageCalculator calculator)
    {
        this.calculator = calculator;
    }

    private  MortgageCalculator calculator;

    public  void printMortgage() {
        double Mortgage = calculator.calculateMortage();
        String mortgageCurrency = NumberFormat.getCurrencyInstance().format(Mortgage);
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
           System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }
}
