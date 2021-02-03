package week14.week14d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void sortNoteBook() {
        List<Student> students = Arrays.asList(
                new Student("John Doe"),
                new Student("Jane Doe"),
                new Student("Jack Doe"));
        ClassNoteBook cnb = new ClassNoteBook(students);
        assertEquals("Jack Doe", cnb.sortNoteBook().get(0).getName());
    }
}