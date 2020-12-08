package week07.week07d02;

import org.junit.jupiter.api.Test;
import week07.week07d01.MathAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitSumTest {
    @Test
    public void testSumOfDigits() {
        assertEquals(12, new DigitSum().sumOfDigitsString(66));
        assertEquals(12, new DigitSum().sumOfDigitsByRoundingLoss(66));
        assertEquals(0, new DigitSum().sumOfDigitsByRoundingLoss(0));
    }

    @Test
    public void incorrectArgumentShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DigitSum().sumOfDigitsString(-111));
        assertEquals("Wrong argument!", ex.getMessage());
    }

    @Test
    public void incorrectArgumentShouldThrowExceptionRoundingLoss() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DigitSum().sumOfDigitsByRoundingLoss(-111));
        assertEquals("Wrong argument!", ex.getMessage());
    }





}
