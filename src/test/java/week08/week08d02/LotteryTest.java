package week08.week08d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    public void testGetNumbers() {
        assertEquals(5, Lottery.getNumbers(90, 5, 6).size());
        assertEquals(6, Lottery.getNumbers(90, 6, 6).size());
        assertEquals(Arrays.asList(62,7,27,19,2,54), Lottery.getNumbers(90, 6, 6));

    }


}