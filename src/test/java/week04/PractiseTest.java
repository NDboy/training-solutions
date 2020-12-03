package week04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PractiseTest {
    @Test
    public void testStringBuilder() {
//        StringBuilder sb = new StringBuilder(100);
//        sb.append("John");
//        sb.append(12.12);
//
//        assertEquals(sb.toString(), "John12.12");
//        sb.insert(4, " " + LocalDate.now() + " ");
//        System.out.println(sb);
//        System.out.println(sb.reverse());
//        String s = sb.toString();
//
//        int i = 15;
//        int j = 25;
//        int k = Math.min(i,j);
//        System.out.print(k);
//        System.out.print(Math.max(i,j));
//        System.out.print(String.format("\nA kisebb szám %6d, a nagyobb %6d", Math.min(i,j), Math.max(i,j)));
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(nums);
        System.out.println(Arrays.toString(nums.toArray()));


    }
}
