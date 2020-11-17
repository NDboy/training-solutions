package algoritmsmax;

import algorithmsmax.SalesPerson;
import algorithmsmax.SalesPersonSelector;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesPersonSelectorTest {
    @Test
    public void testSelectSpMax() {
        List<SalesPerson> salesPersonList = Arrays.asList(
                new SalesPerson("Jack", 1_108_000, 500_000),
                new SalesPerson("John", 408_000, 500_000),
                new SalesPerson("Jason", 1_808_000, 1_000_000),
                new SalesPerson("Jacob", 708_000, 500_000),
                new SalesPerson("Joe", 2_108_000, 1_000_000)
        );
        assertEquals(4, salesPersonList.indexOf(new SalesPersonSelector().selectSpMax(salesPersonList)));
    }

    @Test
    public void testSelectSpOverMax() {
        List<SalesPerson> salesPersonList = Arrays.asList(
                new SalesPerson("Jack", 1_108_000, 500_000),
                new SalesPerson("John", 408_000, 500_000),
                new SalesPerson("Jason", 1_808_000, 1_000_000),
                new SalesPerson("Jacob", 708_000, 500_000),
                new SalesPerson("Joe", 2_108_000, 2_000_000)
        );
        assertEquals(2, salesPersonList.indexOf(new SalesPersonSelector().selectSpOverMax(salesPersonList)));
    }

    @Test
    public void testSelectSpLessMax() {
        List<SalesPerson> salesPersonList = Arrays.asList(
                new SalesPerson("Jack", 1_108_000, 500_000),
                new SalesPerson("John", 408_000, 500_000),
                new SalesPerson("Jason", 1_808_000, 1_000_000),
                new SalesPerson("Jacob", 708_000, 500_000),
                new SalesPerson("Joe", 2_108_000, 2_000_000)
        );
        assertEquals(1, salesPersonList.indexOf(new SalesPersonSelector().selectSpLessMax(salesPersonList)));
    }

}
