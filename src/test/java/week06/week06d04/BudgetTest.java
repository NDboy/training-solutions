package week06.week06d04;
import inheritanceconstructor.cars.Jeep;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {

    List<Item> its = Arrays.asList(
            new Item(1000,1,"alma"),
            new Item(2000,2,"körte"),
            new Item(3000,3,"barack"),
            new Item(4000,4,"banán"),
            new Item(5000,5,"narancs"),
            new Item(6000,1,"meggy"),
            new Item(7000,2,"citrom"),
            new Item(8000,3,"avokádó"),
            new Item(9000,4,"alma")
    );


    @Test
    public void testGetItemsByMonth() {
        assertEquals("[2000 2 körte, 7000 2 citrom]", new Budget(its).getItemsByMonth(2).toString());
        assertEquals("[1000 1 alma, 6000 1 meggy]", new Budget(its).getItemsByMonthWithStream(1).toString());
        assertEquals("[]", new Budget(its).getItemsByMonth(6).toString());
    }

    @Test
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Budget(its).getItemsByMonth(13));
        assertEquals("Invalid argument!", ex.getMessage());
    }

}
