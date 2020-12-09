package week07.week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {
    public boolean isIncreasing(List<Integer> numbers) {
        int puffer = numbers.get(0);
        int i = 0;
        while (i < numbers.size()) {
            if(0 > numbers.get(i) - puffer) {
                return false;
            }
            puffer = numbers.get(i);
            i++;
        }
        return true;
    }
}
