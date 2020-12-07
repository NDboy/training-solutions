package week07.week07d01;

public class MathAlgorithms {

    public static boolean isPrime(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("Wrong parameter!");
        }

        int limit = (int) Math.sqrt((double) x);
//        int i = 2;
//        while (i <= limit) {
//            if (x % i == 0) {
//                return false;
//            }
//            i++;
//        }
//        return true;


        for (int i = 2; i <= limit+1; i++) {
            if (x == 1 || x % i == 0) {
                return false;
            }
        }
        return true;
    }

}


