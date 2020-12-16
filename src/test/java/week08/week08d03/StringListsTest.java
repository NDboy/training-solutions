package week08.week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {
    @Test
    public void testStringListsUnion() {
        assertEquals(Arrays.asList("alma", "körte", "banán", "szőlő", "kókusz", "narancs", "dinnye"), StringLists.stringListsUnion(Arrays.asList("alma", "körte", "banán", "szőlő", "alma"), Arrays.asList("kókusz", "körte", "narancs", "dinnye", "alma")));
    }


}