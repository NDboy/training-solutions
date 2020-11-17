package algorithmsmax;

import java.util.List;

public class IntegerMaxCalculator {

    private int number;
    private List<Integer> numbers;

    public IntegerMaxCalculator() {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int integerMaxCalculator(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for(int n: numbers) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

}
