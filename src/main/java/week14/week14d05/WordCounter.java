package week14.week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public Map<String, Integer> countWords (String pathString, String... words) {
        Map<String, Integer> result = initMap(words);
        int counter;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(pathString))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word: words){
                    if (line.contains(word)){
                        counter = result.get(word) + 1;
                        result.put(word, counter);
                    }
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return result;
    }

    private Map<String, Integer> initMap(String... words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word: words) {
            result.put(word, 0);
        }
        return result;
    }

}

//    A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
//        countWords() metódust, mely paraméterül várja a fájlt, varargsban
//        szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a
//        szövegben. Legyenek mondjuk a beadott szavak: "Hachiko", "haza",
//        "pályaudvar", "jó"
