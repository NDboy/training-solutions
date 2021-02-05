package week14.week14d05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void testCountWords() {
        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> result = wordCounter.countWords("hachiko.srt", "Hachiko", "haza", "pályaudvar", "jó", "hogy");
        assertEquals(4, result.get("Hachiko"));
        assertEquals(15, result.get("haza"));
        assertEquals(15, result.get("jó"));
        assertEquals(5, result.get("pályaudvar"));
        assertEquals(44, result.get("hogy"));
    }

    @Test
    void testWrongPathShouldThrowException() {
        WordCounter wordCounter = new WordCounter();
        Exception ex = assertThrows(IllegalStateException.class, () -> wordCounter.countWords("zacsika.rt"));
        assertEquals("Can not read file", ex.getMessage());
    }
}