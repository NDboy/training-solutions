package week11.week11d01;

import exceptionclass.course.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void testFindDivisors() {
        assertEquals(1, new DivisorFinder().findDivisors(425));
    }


}