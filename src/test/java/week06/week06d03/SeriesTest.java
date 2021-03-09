package week06.week06d03;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void calculateSeriesType() {
        assertEquals(ListType.ASCENDING, new Series().calculateSeriesType(List.of(1,2,3,4)));
        assertEquals(ListType.DESCENDING, new Series().calculateSeriesType(List.of(4,3,2,1)));
        assertEquals(ListType.RANDOM, new Series().calculateSeriesType(List.of(8,1,2,3,4)));
    }

    @Test
    void emptyListShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(null));
        assertEquals("Wrong argument", ex.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Series().calculateSeriesType(Collections.emptyList()));
        assertEquals("Wrong argument", ex2.getMessage());
    }

}