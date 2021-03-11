package week08.week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ExamplesStore {

    public List<String> getTitlesOfExamplesWithStream(String pathString) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream(pathString)))){
            return bufferedReader.lines()
                    .filter(a -> a.startsWith("#"))
                    .map(a -> a.substring(2))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
