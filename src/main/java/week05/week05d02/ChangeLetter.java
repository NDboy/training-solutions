package week05.week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    private  static final char[] VOWELS_CHAR = {'a', 'e', 'i', 'o', 'u'};

    public String changeVowels(String word) {
        for (char c : VOWELS_CHAR) {
            word = word.replace(c, '*');

        }
        return word;
    }
}