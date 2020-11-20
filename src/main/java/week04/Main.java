package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> getIndexesOfChar (String str, char c) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                result.add(i);
            }
        }
        return result;

    }




    public static void main(String[] args) {
        System.out.println(new Main().getIndexesOfChar("almafa", 'a'));
        System.out.println(new Main().getIndexesOfChar("almafa", 'b'));


    }
}
