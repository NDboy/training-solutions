package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> selectedNumbers = new ArrayList<>();
        Random rnd = new Random();
        while (selectedNumbers.size() < lotteryType) {
            int number = rnd.nextInt(90) + 1;
            if (!selectedNumbers.contains(number)) {
                selectedNumbers.add(number);
            }
        }
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
