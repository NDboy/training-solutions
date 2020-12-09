package week07.week07d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberListTest {

    @Test
    public void testSumOfDigits() {
        assertTrue(new NumberList().isIncreasing(Arrays.asList(1,2,3,4,5,6,7,88,99)));
        assertTrue(new NumberList().isIncreasing(Arrays.asList(-98,1,2,3,54,88,99,222)));
        assertFalse(new NumberList().isIncreasing(Arrays.asList(1,2,3,54,51,88,99,222)));
    }
}
