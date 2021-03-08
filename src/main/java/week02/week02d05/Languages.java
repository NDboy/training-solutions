package week02.week02d05;

import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "JavaScript");

        for (String language: languages) {
            if (language.length() > 5) System.out.println(language);
        }
    }
}
