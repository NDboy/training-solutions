package week05.week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    private  static final char[] VOWELS_CHAR = {'a', 'e', 'i', 'o', 'u'};

    private String changeVowels2(String str) {
        for (char c : VOWELS_CHAR) {
            str = str.replace(c, '*');

        }
        return str;
    }

//    public static final String VOWELS = "aeiou";
//
//    private String changeVowels(String str) {
//        str = str.toLowerCase();
//        StringBuilder sb = new StringBuilder(str.length());
//        for (int i = 0; i < str.length(); i++) {
//            String s = str.substring(i, i + 1);
//            if (VOWELS.contains(s)) {
//                sb.append("*");
//            } else {
//                sb.append(s);
//            }
//        }
//        return sb.toString();
//    }
}