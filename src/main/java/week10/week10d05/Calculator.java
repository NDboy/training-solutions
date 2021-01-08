package week10.week10d05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public int findMinSum(int[] arr) {
        int sum = 0;
        List<Integer> buffer = new ArrayList<>();
        for (int i : arr) {
            buffer.add(i);
        }
        Collections.sort(buffer);
        for (int i = 0; i < 4; i++) {
            sum += buffer.get(i);
        }
        return sum;
    }



}

//    Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa.
//    A metódus feladata, hogy kiírja a legkisebb összegeket 4 számból,
//    amiket lehetséges összerakni az arr tömb elemeiből.
//    Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16. (edited)