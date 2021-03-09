package week05.week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongSeniorTest {

    @Test
    void testThrowExceptionWrongArgument() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new SongSenior(null, 1234, "Bon Jovi :)"));
        assertEquals("Name must not be empty", ex.getMessage());
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new SongSenior("Happy day", 1234, ""));
        assertEquals("Artist must not be empty", ex1.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new SongSenior("Happy day", 0, "Bon Jovi :)"));
        assertEquals("The length must be positive", ex2.getMessage());
    }

}