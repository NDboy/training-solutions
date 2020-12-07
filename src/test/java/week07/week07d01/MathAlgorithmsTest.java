package week07.week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {

    @Test
    public void testIsPrime() {
    assertFalse(MathAlgorithms.isPrime(1));
    assertFalse(MathAlgorithms.isPrime(25));
    assertTrue(MathAlgorithms.isPrime(29));
    }

    @Test
    public void incorrectArgumentShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(0));
        assertEquals("Wrong parameter!", ex.getMessage());
    }
}
