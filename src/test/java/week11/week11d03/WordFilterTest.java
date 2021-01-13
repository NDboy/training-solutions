package week11.week11d03;

import exceptions.polinom.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    public void testWordsWithChar() {
        assertEquals(List.of("barack"), new WordFilter().wordsWithChar(List.of("alma", "barack", "eper"), 'c') );
        assertEquals(List.of("alma", "barack"), new WordFilter().wordsWithChar(List.of("alma", "barack", "eper"), 'a') );
    }

    @Test
    public void nullListShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new WordFilter().wordsWithChar(null, 'c'));
        assertEquals("List is missing", ex.getMessage());

    }

}