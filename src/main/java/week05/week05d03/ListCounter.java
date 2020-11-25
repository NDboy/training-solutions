package week05.week05d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCounter {

    public int wordCounterByA(List<String> words) {

        int counter = 0;
        for (String word : words) {
            if (word.toLowerCase().indexOf("a") == 0) {
                counter++;
            }
        }
        return counter;


    }

    public static void main(String[] args) {
        ListCounter listCounter = new ListCounter();
        List<String> words = Arrays.asList("alma", "körte", "ananász");
//        List<String> words = new ArrayList<>();

        System.out.println(listCounter.wordCounterByA(words));

    }

}

