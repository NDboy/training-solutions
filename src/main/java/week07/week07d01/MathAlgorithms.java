package week07.week07d01;

import java.util.stream.IntStream;

public class MathAlgorithms {

    public static boolean isPrime(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Wrong parameter!");
        }

        int limit = (int) Math.sqrt((double) x);
        for (int i = 2; i <= limit+1; i++) {
            if (x == 1 || x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWithStream(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(i -> number % i == 0);
    }

}


