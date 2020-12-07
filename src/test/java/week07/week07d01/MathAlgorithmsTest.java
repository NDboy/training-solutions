package week07.week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {

    @Test
    public void testIsPrime() {
    assertTrue(MathAlgorithms.isPrime(22221299));
    assertFalse(MathAlgorithms.isPrime(25));
    }

    @Test
    public void incorrectArgumentShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(0));
        assertEquals("The number must be positive!", ex.getMessage());
    }
}
