package classstructureio;

import java.util.Scanner;

public class CalculatorAndRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg egy számot!");
        int n1 = scanner.nextInt();
        System.out.println("Adj meg még egy számot!");
        int n2 = scanner.nextInt();
        System.out.println(n1 + " + " + n2 + "\n" + (n1 + n2));
        scanner.nextLine();


        System.out.println("Adj meg egy nevét!");
        String  name = scanner.nextLine();
        System.out.println("Adj meg az email címét!");
        String  email = scanner.nextLine();
        System.out.println("Az alábbi adatokkal regisztrált:" + "\n" + "név: " + name + "\n" + "email cím: " + email);


    }
}
