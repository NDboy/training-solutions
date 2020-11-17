package algoritmsmax;

import algorithmsmax.IntegerMaxCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerMaxCalculatorTest {
    @Test
    public void testIntegerMaxCalculator() {
        List<Integer> numbers = Arrays.asList(584,565,21,23,74,85,65,45635,64,364,659,64548,65454,456464);
        assertEquals(456464, new IntegerMaxCalculator().integerMaxCalculator(numbers));

    }
}
