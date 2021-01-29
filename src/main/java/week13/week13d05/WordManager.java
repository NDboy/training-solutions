package week13.week13d05;

import java.util.*;

public class WordManager {

    public int letterCounter(String word) {
        Set<Character> letters = new HashSet<>();
        char[] charArray = word.toLowerCase().toCharArray();
        for (char c : charArray) {
            if ('a' <= c && c <= 'z') {
                letters.add(c);
            }
        }
        return letters.size();
    }

}
//    Junior (adatszerkezetes) feladat:
//        Írj egy metódust, amely megszámolja, hogy hány különböző betű van
//        egy szóban. A kis és nagybetűk közötti különbség nem számít!
//        A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
//        angol ábécé betűit!
