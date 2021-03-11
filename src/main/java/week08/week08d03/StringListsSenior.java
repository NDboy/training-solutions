package week08.week08d03;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StringListsSenior {

    public static List<String> selectShortestWordsWithStream(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList())).firstEntry().getValue();
    }

}
