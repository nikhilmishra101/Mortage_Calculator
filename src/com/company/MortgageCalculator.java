package com.company;

public class MortgageCalculator {
    private final static int month_In_Years = 12;
    private final static int Percent = 100;
    private int Principal;
    private float Interest;
    private int Period;

    public MortgageCalculator(int Principal,float Interest,int Period)
    {
        this.Principal = Principal;
        this.Interest = Interest;
        this.Period = Period;
    }

    public double calculateMortage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double Mortage = Principal * (
                monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));


        return Mortage;

    }


    public double calculateBalance(short numberOfPayementsMade)
    {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double Balance = Principal
                *(Math.pow(1 + monthlyInterest,numberOfPayments) -
                Math.pow(1 + monthlyInterest,numberOfPayementsMade)
         )/(Math.pow(1 + monthlyInterest,numberOfPayments) - 1);

        return Balance;
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return balances;
    }


    private float getMonthlyInterest() {
        return (Interest / Percent) / month_In_Years;
    }

    private short getNumberOfPayments() {
        return (short) (Period * month_In_Years);
    }
}
