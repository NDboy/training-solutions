package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Befektetés összege?");
        double fund = scanner.nextDouble();

        System.out.println("Kamatláb?");
        double interestRate = scanner.nextDouble();

        System.out.println("Napok száma");
        int days = scanner.nextInt();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("Tőke: "+ fund);
        System.out.println("Hozam " + days + " napra: " + investment.getYield(days));
        System.out.println("Kivett összeg " + days + " nap után: " + investment.close(days));
        System.out.println("Kivett összeg " + 400 + " nap után: " + investment.close(400));


    }
}
