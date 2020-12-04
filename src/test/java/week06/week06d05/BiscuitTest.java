package week06.week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiscuitTest {

    @Test
    public void testConstruct() {
        assertEquals(200, new Biscuit(BiscuitType.MANNER, 200).getGramAmount());
    }

    @Test
    public void testOf() {
        assertTrue(Biscuit.of(BiscuitType.GYORIEDES, 150).getType() == BiscuitType.GYORIEDES);
    }



}
