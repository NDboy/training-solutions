package week10.week10d05;

import org.junit.jupiter.api.Test;
import week08.week08d05.MathAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testFindMinSum() {
        int [] arr = {5,8,1,1,3,9,1,2};
        assertEquals(5, new Calculator().findMinSum(arr));
    }

    @Test
    public void testShouldThrowException() throws IllegalArgumentException {
        int [] arr = {9,1,2};
        int [] arr1 = null;

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(arr));
        assertEquals("Wrong argument!", ex.getMessage());

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(arr1));
        assertEquals("Wrong argument!", ex1.getMessage());
    }

}