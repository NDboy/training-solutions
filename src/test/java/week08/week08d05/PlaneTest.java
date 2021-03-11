package week08.week08d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void findMostZeroWithStream() {
        assertEquals(16, new Plane().findMostZeroWithStream(Path.of("map.txt")));
    }
}