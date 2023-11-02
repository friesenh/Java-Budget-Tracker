package com.javabudgettracker;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    public int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private void setPrincipal(int principal) {
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private void setYears(byte years) {
        this.years = years;
    }
}
