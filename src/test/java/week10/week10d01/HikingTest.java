package week10.week10d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    public void testGetPlusElevation() {
        List<Double> heights = Arrays.asList(10.0,15.0,20.0,5.0);
        assertEquals(10.0, Hiking.getPlusElevation(heights));
    }


}