package week04;

import algorithmsmax.IntegerMaxCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTest {

    @Test
    public void testNameChanger () {
//        NameChanger nameChanger = new NameChanger("John Doe");
        assertEquals("Jason Doe", new NameChanger("John Doe").changeFirstName("Jason"));

    }

}
