package week05.week05d03;

import java.util.List;

public class ListCounter {

    public int wordCounterByA(List<String> words) {
        if (words.isEmpty()) {
            return 0;
        }
        int counter = 0;
        for (String word : words) {
            if (word.toLowerCase().indexOf("a") == 0) {
                counter++;
            }
        }
        return counter;


    }

}
//    Írj egy olyan metódust az week05d03.ListCounter osztályban, mely egy kapott Listából (String) összeszámolja azokat amik 'a' vagy 'A' betűvel kezdődnek,
//    Ha nulla elemű a tömb,vagy nincs benne ilyen elem, akkor 0-t adjon vissza. (edited)

