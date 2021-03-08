package week05.week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testAddProduct() {
        Store store = new Store();
        store.addProduct(new Product("alma", 2020, 11, 28));
        store.addProduct(new Product("körte", 2020, 12, 28));
        store.addProduct(new Product("barack", 2020, 11, 24));
        store.addProduct(new Product("datolya", 2021, 5, 28));
        store.addProduct(new Product("banán", 2020, 11, 21));

        assertEquals(0, store.getNumberOfExpired());
        assertEquals(1, store.getProducts().size());
    }

}
