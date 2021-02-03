package week14.week14d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void testPutMark() {
        Student student = new Student("John Doe");
        student.putMark(Subjects.MATHEMATICS, 1);
        student.putMark(Subjects.PHYSICS, 2);
        student.putMark(Subjects.LITERATURE, 3);
        student.putMark(Subjects.HISTORY, 4);
        assertEquals(List.of(3), student.getMarks().get(Subjects.LITERATURE));
    }
}