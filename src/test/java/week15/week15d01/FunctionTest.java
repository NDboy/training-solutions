package week15.week15d01;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void testFindMax() {
        Map<Double, Double> nums = new HashMap<>();
        nums.put(1.0,2.0);
        nums.put(2.0,2.0);
        nums.put(3.0,3.0);
        nums.put(4.0,5.0);
        nums.put(5.0,2.0);
        nums.put(-8.0,-12.0);
        Function function = new Function();
        assertEquals("key: 4.0 , value: 5.0", function.findMax(nums).toString());
    }

    @Test
    void testFindMaxValueEntry() {
        Map<Double, Double> nums = new HashMap<>();
        nums.put(1.0,2.0);
        nums.put(2.0,2.0);
        nums.put(3.0,3.0);
        nums.put(4.0,5.0);
        nums.put(5.0,2.0);
        nums.put(-8.0,-12.0);
        Function function = new Function();
        assertEquals("4.0=5.0", function.findMaxValueEntry(nums).toString());
    }
}