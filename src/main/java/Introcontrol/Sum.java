package Introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Írj be 5 számot!");

        int amount = 0;

        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            amount += number;
        }

        System.out.println(amount);

    }
}
