import java.util.Scanner;
import java.text.NumberFormat;

class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int MIN_PRINCIPAL = 1_000;
        final int MAX_PRINCIPAL = 1_000_000;
        final float MIN_RATE = 0;
        final float MAX_RATE = 30;
        final byte MIN_YEARS = 1;
        final byte MAX_YEARS = 30;
        int principal = 0;
        float monthlyInterestRate = 0; 
        byte years = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if (principal > MIN_PRINCIPAL && principal < MAX_PRINCIPAL)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }
        
        while (true) {
            System.out.print("Annual Interest Rate (0 - 30): ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > MIN_RATE && annualInterestRate <= MAX_RATE) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30"); 
        }

        while (true) {
            System.out.print("Period (years) (1 - 30): ");
            years = scanner.nextByte();
            if (years >= MIN_YEARS && years <= MAX_YEARS) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal 
                    * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) 
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);
    }
}