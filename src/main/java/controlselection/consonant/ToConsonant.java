package controlselection.consonant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToConsonant {
    private char letter;
    private List<Character> abc = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    private List<Character> vowels = Arrays.asList('a','e','i','o','u');

    public ToConsonant() {
        this.letter = letter;
    }

    public char getLetter(char letter) {
        if (vowels.indexOf(letter) >= 0) {
            return abc.get(abc.indexOf(letter)+1);
        } else {
            return letter;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ToConsonant().getLetter('a'));
    }

}
