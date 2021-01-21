package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> numList = new ArrayList<>();
        for (int i: numbers) {
            numList.add(i);
        }
        return numList;
    }

    public int sumIntegerList(List<Integer> nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (int i: integers) {
            sum += i;
        }
        return sum;
    }

}
