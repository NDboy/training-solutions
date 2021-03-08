package week04.week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void findNumber () {
        Random rnd = new Random();
        int result = rnd.nextInt(100) + 1;
        int guess = 0;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        while (result != guess && counter <= 6) {
            counter++;
            System.out.println("Enter your guess!");
            guess = sc.nextInt();
            if (guess > result) {
                System.out.println(counter + ". The number is smaller");
            } else if (guess < result) {
                System.out.println(counter + ". The number is higher");
            } else {
                System.out.println(counter + ". You are right, the result: " + guess);
            }
        }
    }

    public static void main(String[] args) {
        GuessTheNumber.findNumber();
    }

}
