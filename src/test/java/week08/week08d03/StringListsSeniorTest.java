package week08.week08d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsSeniorTest {

    @Test
    void selectShortestWords() {
        List<String> words = List.of("ccc","ddd","cc","dd","a","z");
        assertEquals(List.of("a", "z"), StringListsSenior.selectShortestWordsWithStream(words));
    }
}