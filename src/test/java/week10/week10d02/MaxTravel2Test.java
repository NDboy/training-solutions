package week10.week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravel2Test {

    @Test
    void getMaxIndexTest() {
        assertEquals(12, new MaxTravel2().getMaxIndex(List.of(12,12,12,3,0,0,3)));
    }
}