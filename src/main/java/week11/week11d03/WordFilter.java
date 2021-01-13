package week11.week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        if (words == null) {
            throw new IllegalArgumentException("List is missing");
        }
        List<String> foundWords = new ArrayList<>();
        for (String word: words) {
            if (word.contains(Character.toString(c))) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }


}

//    Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
//    A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter, majd ezeket visszaadja egy listában. (edited)
