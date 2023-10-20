package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var ui = new UI();
        int principal = (int) ui.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) ui.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) ui.readNumber("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterest, years);
        mortgage.printMortgage();
        mortgage.printPaymentSchedule();
    }
}