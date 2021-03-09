package week06.week06d03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordEraser {
    public String eraseWord(String words, String word) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(words.trim());
        while (sc.hasNext()) {
            String nextWord = sc.next();
            if (!word.equals(nextWord)) {
                sb.append(nextWord + " ");
            }
        }
        return sb.toString().trim();
    }

    public String eraseWordWithStream(String words, String word) {
        return Arrays.stream(words.split(" "))
                .filter(a -> !a.equals(word))
                .map(String::trim)
                .collect(Collectors.joining(" "));
    }

}



//   A week06d03.WordEraser osztályban legyen
//   egy eraseWord(String words, String word) metódus,
//   mely az első paraméter szöveget úgy változtatja meg,
//   hogy a második paraméter összes előforulását kitörli belőle.
//   A words paraméterben a szavak szóközzel vannak elválasztva.
//   A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel.
//   (Mellőzzük a replace és replaceAll használatát)