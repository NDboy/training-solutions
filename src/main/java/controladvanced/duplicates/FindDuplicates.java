package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
    public static final List<Integer> numbers = Arrays.asList(45,65,45,32,458,958,1454,23,65,78,45,12,21,65,98,32,25,52,85,57,45,12,23,56,89,98,65,32,87,54,21,12,11,22,33,55,44,54,12,78,99,85,25,54,56);




    public List<Integer> findDuplicates(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    result.add(numbers.get(i));
                    break;
                }
            }
        }
        return result;
    }




    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates(numbers));
    }

}

