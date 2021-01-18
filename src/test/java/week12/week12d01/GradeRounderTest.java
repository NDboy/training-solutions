package week12.week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void testRoundGrades() {
        int [] testArray = {27, 41,42,43,44,45,46,47,48, 57, 58};
        assertEquals("[27, 41, 42, 45, 45, 45, 46, 47, 50, 57, 60]", Arrays.toString(new GradeRounder().roundGrades(testArray)));
    }
}