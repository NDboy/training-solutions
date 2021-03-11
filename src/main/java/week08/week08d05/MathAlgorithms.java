package week08.week08d05;

import java.util.stream.IntStream;

public class MathAlgorithms {

    public static int greatestCommonDivisor(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Invalid argument");
        }
        int greatest = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                greatest = i;
            }
        }
        return greatest;
    }

    public static int greatestCommonDivisorWithStream(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Invalid argument");
        }
        return IntStream.rangeClosed(1, Math.min(a,b))
                .filter(i -> a % i == 0 && b % i ==0)
                .max()
                .getAsInt();
    }
}
