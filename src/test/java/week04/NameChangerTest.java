package week04;

import org.junit.jupiter.api.Test;
import week04.week04d02.NameChanger;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTest {

    @Test
    public void testNameChanger () {
        assertEquals("Jason Doe", new NameChanger("John Doe").changeFirstName("Jason"));

    }

}
