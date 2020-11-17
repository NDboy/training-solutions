package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayInMonthTest {
    @Test
    public void testGetDayInMonth() {
        assertEquals(28, new DayInMonth().getDayInMonth(2003, "FEBruár"));
        assertEquals(28, new DayInMonth().getDayInMonth(2003, "FEBruár"));
    }
    @Test
    public void testIllegalThrow() {
        assertThrows(IllegalArgumentException.class, () -> new DayInMonth().getDayInMonth(2012, "januá"));
    }


}
