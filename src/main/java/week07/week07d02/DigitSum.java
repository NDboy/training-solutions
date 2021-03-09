package week07.week07d02;

import java.util.stream.IntStream;

public class DigitSum {

    public int sumOfDigitsString(int x){
        if (x < 0) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        String str = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(str.substring(i, i + 1));
        }
        return sum;
    }

    public static int sumOfDigitsWithStream(int x){
        String numberString = Integer.toString(x);
        return IntStream
                .range(0, numberString.length())
                .mapToObj(a -> Integer.parseInt(Character.toString(numberString.charAt(a))))
                .reduce(0, Integer::sum);
    }


    public int sumOfDigitsByRoundingLoss(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        int divMult = x;
        int sum = 0;
        if (x < 10) {
            return x;
        } else {
            while (divMult > 0) {
                divMult = x / 10 * 10;
                sum += x - divMult;
                x /= 10;
            }
            return sum;
        }
    }

}
