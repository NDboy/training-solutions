package week09.week09d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {


    @Test
    public void testCreate() {
        SantaClaus sc = new SantaClaus(List.of(new Person("John Doe", 28), new Person("Johnny Doe", 8)));
        assertEquals("personList: [John Doe (28), Johnny Doe (8)]", sc.toString());
        assertEquals("John Doe", sc.getPersonList().get(0).getName());
        assertEquals(8, sc.getPersonList().get(1).getAge());
    }

    @Test
    public void testGetThroughChimneys() {
        SantaClaus sc = new SantaClaus(List.of(new Person("John Doe", 28), new Person("Johnny Doe", 8)));
        sc.getThroughChimneys();
        assertEquals(Present.DECORATION, sc.getPersonList().get(0).getPresent());
        assertEquals(Present.HOUSEKEEPING, sc.getPersonList().get(1).getPresent());
    }

}