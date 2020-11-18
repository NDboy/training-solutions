package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int randomIntTo101 = rnd.nextInt(101);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tippeld meg a számot 0 és 100 között!");
        int guess = scanner.nextInt();

        while (randomIntTo101 != guess) {
            if (guess < randomIntTo101) {
                System.out.println("Nagyobb számra gondoltam.");
            } else {
                System.out.println("Kisebb számra gondoltam.");
            }
            System.out.println("Adj meg egy másik számot!");
            int newGuess = scanner.nextInt();
            guess = newGuess;
        }

        System.out.println("Eltaláltad!");


    }




}
