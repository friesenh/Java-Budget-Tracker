import java.util.Scanner;
import java.text.NumberFormat;

class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat() / PERCENT;
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        
        System.out.print("Period (years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal 
                    * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) 
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);
    }
}