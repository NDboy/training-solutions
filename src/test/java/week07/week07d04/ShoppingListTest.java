package week07.week07d04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @TempDir
    public File folder;

    @Test
    void testCalculateSum() {
        ShoppingList sl = new ShoppingList();
        sl.createShoppingListToFile(folder.toPath().resolve("shoppinglist.dat"));

        assertEquals(59250, sl.calculateSum(folder.toPath().resolve("shoppinglist.dat")));

    }
}