package week06.week06d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    ListSelector listSelector = new ListSelector();

    @Test
    public void testToString() {
        assertEquals("[almakörte]", listSelector.selectList(Arrays.asList("alma", "barack", "körte")));
    }

    @Test
    public void nullTestToString() {
        assertThrows(NullPointerException.class, () -> listSelector.selectList(Arrays.asList(null)));
    }

    @Test
    public void emptyTestToString() {
        assertEquals("[]", listSelector.selectList(Arrays.asList("")));
    }

}
