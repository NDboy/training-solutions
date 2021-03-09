package week06.week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class StoreSeniorTest {

    @Test
    void testGetProductByCategory() {
        List<Product> products = Arrays.asList(new Product("apple", Category.DAIRY, 200),
                new Product("banana", Category.DAIRY, 300),
                new Product("croissant", Category.BAKEDGOODS, 100),
                new Product("meat", Category.DAIRY, 600),
                new Product("cleaning tool", Category.OTHER, 100),
                new Product("cosmetics", Category.OTHER, 200),
                new Product("toy", Category.OTHER, 200));
        assertEquals("{DAIRY=3, OTHER=3, BAKEDGOODS=1}", new StoreSenior(products).getProductByCategory().toString());
    }
}