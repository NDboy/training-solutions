package week06.week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void testOf() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        assertEquals(BottleType.PET_BOTTLE, bottle.getBottleType());
    }

    @Test
    void testFill() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(10);
        assertEquals(10, bottle.getFilledUntil());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> bottle.fill(10));
        assertEquals("Too much liquid", ex.getMessage());
    }
}