package week02.week02d04;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Adj egy nevet!");
            names[i] = scanner.nextLine();
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ". " + names[i - 1]);
        }

    }
}
