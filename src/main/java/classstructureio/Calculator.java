package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        System.out.println("Adj egy számot!");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();

        System.out.println("Adj egy másik számot!");
        int num2 = scanner.nextInt();

        int num3 = num1 + num2;

        System.out.println(num1 + "+" + num2);
        System.out.println(num3);
    }
}
