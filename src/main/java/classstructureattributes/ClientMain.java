package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        System.out.println("Adja meg a nevét!");
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        client.name = scanner.nextLine();

        System.out.println("Adja meg a születési évét!");
        client.yearOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Adja meg a címét!");
        client.address = scanner.nextLine();

        System.out.println("Ön az alábbi adatokkal regisztrált:");
        System.out.println("név: " + client.name);
        System.out.println("születési év: " + client.yearOfBirth);
        System.out.println("cím: " + client.address);
    }
}
