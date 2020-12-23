package week09.week09d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testCreate() {
        assertEquals("John Doe (28)", new Person("John Doe", 28).toString());
        assertEquals("John Doe", new Person("John Doe", 28).getName());
        assertEquals(28, new Person("John Doe", 28).getAge());
    }

    @Test
    public void testSetPresent() {
        Person p1 = new Person("John Doe", 28);
        Person p2 = new Person("Johnny Doe", 8);
        p1.setPresent(5);
        p2.setPresent(5);
        assertEquals(Present.DECORATION, p1.getPresent());
        assertEquals(Present.HOUSEKEEPING, p2.getPresent());
    }


}