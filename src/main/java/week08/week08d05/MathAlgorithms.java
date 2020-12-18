package week08.week08d05;

public class MathAlgorithms {

    public static int greatestCommonDivisor(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Invalid argument");
        }
        int greatest = 0;
        for (int i = 1; i <= Math.min(a,b) ; i++) {
            if (a % i == 0 && b % i ==0) {
                greatest = i;
            }
        }
        return greatest;
    }

}

