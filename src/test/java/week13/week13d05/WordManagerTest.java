package week13.week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordManagerTest {

    @Test
    void testLetterCounter() {
        assertEquals(3, new WordManager().letterCounter("     bla-bla-bla  \n "));
    }
}