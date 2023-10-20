package MortgageCalculator;

import java.text.NumberFormat;

public class Mortgage {
    final static int MAX_PRINCIPAL = 1_000_000;
    final static int MIN_PRINCIPAL = 1_000;
    final static byte MAX_ANNUAL_INTEREST = 30;
    final static byte MIN_ANNUAL_INTEREST = 1;
    final static byte MAX_YEARS = 30;
    final static byte MIN_YEARS = 1;
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public Mortgage(int principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public void printMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private void setPrincipal(int principal) {
        if (principal > MAX_PRINCIPAL || principal < MIN_PRINCIPAL)
            throw new IllegalArgumentException("Principal must be at least 1,000 and not more than 1,000,000");
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        if (annualInterest > MAX_ANNUAL_INTEREST || annualInterest < MIN_ANNUAL_INTEREST)
            throw new IllegalArgumentException("Annual interest must be at least 1 and not more than 30");
        this.annualInterest = annualInterest;
    }

    private void setYears(byte years) {
        if (years > MAX_YEARS || years < MIN_YEARS)
            throw new IllegalArgumentException("Years must be at least 1 and not more than 30");
        this.years = years;
    }
}
