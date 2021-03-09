package week06.week06d02;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {


    @Test
    public void testGetProductByCategoryName1() {
        assertEquals(1, new Store(Arrays.asList(new Product("alma", Category.DAIRY, 125), new Product("májkrém", Category.OTHER, 305))).getProductByCategoryName(Category.DAIRY));
    }

    @Test
    public void testGetProductByCategoryName2() {
        assertEquals(1, new Store(Arrays.asList(new Product("alma", Category.DAIRY, 125), new Product("májkrém", Category.OTHER, 305))).getProductByCategoryName(Category.OTHER));
    }

    @Test
    public void testGetProductByCategoryName3() {
        assertEquals(0, new Store(Arrays.asList(new Product("alma", Category.DAIRY, 125), new Product("májkrém", Category.OTHER, 305))).getProductByCategoryName(Category.FROZEN));
    }

    @Test
    public void testGetProductByCategoryNameWithStream() {
        assertEquals(0, new Store(Arrays.asList(new Product("alma", Category.DAIRY, 125), new Product("májkrém", Category.OTHER, 305))).getProductByCategoryNameWithStream(Category.FROZEN));
        assertEquals(1, new Store(Arrays.asList(new Product("alma", Category.DAIRY, 125), new Product("májkrém", Category.OTHER, 305))).getProductByCategoryNameWithStream(Category.DAIRY));
    }

}
