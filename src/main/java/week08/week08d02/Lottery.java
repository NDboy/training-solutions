package week08.week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public static List<Integer> getNumbersWithStream(int interval, int numbers, int seed) {
        return new Random()
                .ints(1, interval + 1)
                .distinct()
                .limit(numbers)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

    }

}







