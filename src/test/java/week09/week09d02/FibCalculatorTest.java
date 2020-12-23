package week09.week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    public void testSumEvens () {
        assertEquals(44, FibCalculator.sumEvens(56));
    }

    @Test
    public void testNegativeShouldThrowException() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> FibCalculator.sumEvens(-5));
        assertEquals("Invalid argument!", exception.getMessage());
    }


}