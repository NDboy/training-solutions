package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException(String.format("drawCount must be less then %d!", maxNumber));
        }
        List<Integer> selectedNumbers = new LinkedList<>();
        Random rnd = new Random();
        while (selectedNumbers.size() < drawCount) {
            int number = rnd.nextInt(maxNumber) + 1;
            if (!selectedNumbers.contains(number)) {
                selectedNumbers.add(number);
            }
        }
        System.out.println(selectedNumbers);
        return new TreeSet<>(selectedNumbers);
    }

}
