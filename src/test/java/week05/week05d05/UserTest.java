package week05.week05d05;

import org.junit.jupiter.api.Test;
import stringscanner.StringScanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void testGetFullName() {
        assertEquals("John Black", new User("John", "Black", "fgdf@etr.hu").getFullName());



        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("John", "Black", "fgdfetr.hu").getFullName());
        assertEquals("Email must contain @ and . !", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Whiters", "White", "fgdf@etrhu").getFullName());
        assertEquals("Email must contain @ and . !", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("", "White", "fgdf@etr.hu").getFullName());
        assertEquals("Invalid argument!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Whiters", null, "fgdf@etrhu").getFullName());
        assertEquals("Invalid argument!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new User("Mister", "Pink", "").getFullName());
        assertEquals("Invalid argument!", ex.getMessage());



    }
}
