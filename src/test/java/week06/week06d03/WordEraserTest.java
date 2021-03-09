package week06.week06d03;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {

    @Test
    public void testEraseWord() {
        assertEquals("körte barack birsalma", new WordEraser().eraseWord("alma körte barack alma birsalma", "alma"));
        assertEquals("alma barack alma birsalma", new WordEraser().eraseWord("alma körte barack alma birsalma", "körte"));
        assertEquals("alma barack alma birskörte", new WordEraser().eraseWord("   alma körte barack alma birskörte  ", "körte"));
    }

    @Test
    public void testEraseWordWithStream() {
        assertEquals("körte barack birsalma", new WordEraser().eraseWordWithStream("alma körte barack alma birsalma", "alma"));
        assertEquals("alma barack alma birsalma", new WordEraser().eraseWordWithStream("alma körte barack alma birsalma", "körte"));
        assertEquals("   alma barack alma birskörte", new WordEraser().eraseWordWithStream("   alma körte barack alma birskörte   ", "körte"));
    }
}
