package week05.week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {

    @Test
    void changeVowels() {
        assertEquals("*rv*zt*r*t*k*rf*r*g*p", new ChangeLetter().changeVowels("arvizturotukorfurogep"));
    }
}