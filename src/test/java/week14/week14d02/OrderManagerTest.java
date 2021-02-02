package week14.week14d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {


    @Test
    void testLoadFileToMap() {
        OrderManager orderManager = new OrderManager();
        orderManager.loadFileToMap("orders.txt");
        assertEquals(9, orderManager.getOrders().size());
    }

    @Test
    void testFindSortedProductListByRegNumber() {
        OrderManager orderManager = new OrderManager();
        orderManager.loadFileToMap("orders.txt");
        assertEquals(Arrays.asList("oregano", "passata", "pepper", "pizza_dough", "rosmary", "salt"), orderManager.findSortedProductListByRegNumber("C123"));
    }

    @Test
    void testCountSoldProductByName() {
        OrderManager orderManager = new OrderManager();
        orderManager.loadFileToMap("orders.txt");
        assertEquals(3, orderManager.countSoldProductByName("sugar"));
    }

    @Test
    void testCountProductsInOrder() {
        OrderManager orderManager = new OrderManager();
        orderManager.loadFileToMap("orders.txt");
        assertEquals(6, orderManager.countProductsInOrder("C123"));
    }

    @Test
    void testMakeStatisticsInMap() {
        OrderManager orderManager = new OrderManager();
        orderManager.loadFileToMap("orders.txt");
        assertEquals(27, orderManager.makeStatisticsInMap().size());
        assertEquals(3, orderManager.makeStatisticsInMap().get("sugar"));
        assertEquals(2, orderManager.makeStatisticsInMap().get("rosmary"));
    }
}