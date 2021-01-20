package week12.week12d03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void testLoadList() {
        NumberStat ns = new NumberStat();
        Path path = Path.of("numbers.txt");
        ns.loadList(path);
        assertEquals("[1, 1, 4, 2, 3, 5, 2, 2, 5, 5, 6, 12, 2, 1, 0]", ns.getNumbers().toString());
    }

    @Test
    void testNumberOnlyOne() {
        NumberStat ns = new NumberStat();
        Path path = Path.of("numbers.txt");
        ns.loadList(path);
        assertEquals(0, ns.numberOnlyOne());
    }
}