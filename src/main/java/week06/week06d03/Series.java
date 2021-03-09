package week06.week06d03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Series {

    public ListType calculateSeriesType(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Wrong argument");
        }
        List<Integer> numbersToSort = new ArrayList<>(numbers);
        numbersToSort.sort(Comparator.naturalOrder());
        if (numbers.equals(numbersToSort)) {
            return ListType.ASCENDING;
        } else {
            numbersToSort.sort(Comparator.reverseOrder());
            if (numbers.equals(numbersToSort)) {
                return ListType.DESCENDING;
            }
        }
        return ListType.RANDOM;
    }
}
