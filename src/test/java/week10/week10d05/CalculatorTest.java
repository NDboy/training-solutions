package week10.week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testFindMinSum() {
        int [] arr = {5,8,1,1,3,9,1,2};
        assertEquals(5, new Calculator().findMinSum(arr));
    }

}