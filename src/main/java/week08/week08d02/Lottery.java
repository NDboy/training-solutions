package week08.week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public static List<Integer> getNumbers(int interval, int numbers, int n) {
        Random rnd = new Random(n);
        List<Integer> result = new ArrayList<>();
        int puffer = 0;
        while (result.size() < numbers) {
            puffer = rnd.nextInt(interval) + 1;
            if (!result.contains(puffer)) {
                result.add(puffer);
            }
        }
        return result;
    }

}









