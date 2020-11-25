package stringbasic;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VetTest {

    @Test
    public void testAddDifferent() {
        Vet vet = new Vet();

//        vet.add(new Pet("Blöki", LocalDate.of(2017, 10, 23), , "000145"));
//        vet.add(new Pet("Szerénke", LocalDate.of(2012, 4, 9), Gender.FEMALE, "000129"));
        vet.add(new Pet("kutya",2018,4, 9, Sex.FEMALE, "123456"));
        vet.add(new Pet("kutyuli",2017,4, 9, Sex.FEMALE, "123459"));

        assertEquals(2, vet.getPets().size());
    }

    @Test
    public void testAddSame() {
        Vet vet = new Vet();

        vet.add(new Pet("kutyuli",2017,4, 9, Sex.FEMALE, "123459"));
        vet.add(new Pet("Matuzsálem",1980,4, 9, Sex.UNKNOWN, "123459"));

//        vet.add(new Pet("Blöki", LocalDate.of(2017, 10, 23), Gender.MALE, "000145"));
//        vet.add(new Pet("Szerénke", LocalDate.of(2012, 4, 9), Gender.FEMALE, "000145"));

        assertEquals(1, vet.getPets().size());
    }
}