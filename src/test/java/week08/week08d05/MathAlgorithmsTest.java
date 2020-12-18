package week08.week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {


    @Test
    public void testGreatestCommonDivisor() {
        assertEquals(13, MathAlgorithms.greatestCommonDivisor(26,39));
    }

    @Test
    public void testNegativeShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.greatestCommonDivisor(-1, 8));
        assertEquals("Invalid argument", ex.getMessage());
    }

}