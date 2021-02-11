package week15.week15d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CovidManagerTest {

    @Test
    void testSelectThreeWorstWeek() {
        CovidManager cm = new CovidManager();
        cm.loadFileToList();

        assertEquals(3, cm.selectThreeWorstWeek().size());
        assertEquals(39170, cm.selectThreeWorstWeek().get(0).getCasesWeekly());
        assertEquals(37026, cm.selectThreeWorstWeek().get(1).getCasesWeekly());
        assertEquals(32678, cm.selectThreeWorstWeek().get(2).getCasesWeekly());
        assertEquals("Hungary", cm.selectThreeWorstWeek().get(0).getCountryAndTerritory());

    }
}