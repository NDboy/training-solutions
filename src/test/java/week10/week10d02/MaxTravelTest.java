package week10.week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        assertEquals(12, new MaxTravel().getMaxIndex(List.of(12,12,0,0,3,4,12)));
    }
}