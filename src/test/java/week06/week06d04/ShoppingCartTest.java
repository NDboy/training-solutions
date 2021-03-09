package week06.week06d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    void init() {
        List<ItemSenior> items = new ArrayList<>();
        items.add(new ItemSenior("alma", 10));
        items.add(new ItemSenior("körte", 20));
        items.add(new ItemSenior("banán", 30));
        items.add(new ItemSenior("narancs", 40));
        items.add(new ItemSenior("barack", 50));
        items.add(new ItemSenior("dinnye", 60));
        shoppingCart = new ShoppingCart(items);
    }

    @Test
    void addItem() {

        shoppingCart.addItem("szőlő", 70);
        shoppingCart.addItem("alma", 20);
        assertEquals(30, shoppingCart.getItem("alma"));
        assertEquals(70, shoppingCart.getItem("szőlő"));
        assertEquals(7, shoppingCart.getItems().size());
    }

}