package week08.week08d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    void getTitlesOfExamplesWithStream() {
        assertEquals(List.of("Első feladat", "Második feladat"), new ExamplesStore().getTitlesOfExamplesWithStream("/examples.md"));
    }
}