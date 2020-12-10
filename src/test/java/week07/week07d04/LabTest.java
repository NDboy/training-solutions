package week07.week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    public void testCreate() {
        assertEquals("Methods", new Lab("Methods").getTitle());
        assertEquals("Methods", new Lab("Methods", 2020, 11, 10).getTitle());
        assertEquals(true, new Lab("Methods", 2020, 11, 10).isCompleted());
        assertEquals(LocalDate.of(2020, 11, 10), new Lab("Methods", 2020, 11, 10).getCompletedAt());

    }

    @Test
    public void testComplete() {
        Lab l = new Lab("Methods");
        l.complete();
        assertTrue(l.isCompleted());
        assertEquals(LocalDate.now(), l.getCompletedAt());

    }

    @Test
    public void testToString() {
        assertEquals("title=Methods, completed=true, completedAt=2020-11-10", new Lab("Methods", 2020, 11, 10).toString());
    }
}