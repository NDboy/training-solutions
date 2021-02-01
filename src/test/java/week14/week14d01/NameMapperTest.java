package week14.week14d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameMapperTest {

    @Test
    public void testIndex() {
        List<String> names = Arrays.asList("Balázs", "Ildikó", "Ilona", "Benedek", "Tihamér");
        NameMapper nm = new NameMapper();
        assertEquals(Arrays.asList("Balázs", "Benedek"), nm.index(names).get('B'));
        assertEquals(Arrays.asList("Ildikó", "Ilona"), nm.index(names).get('I'));
    }

}