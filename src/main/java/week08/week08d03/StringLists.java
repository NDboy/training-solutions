package week08.week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    static List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> result = new ArrayList<>();
        for (String f: first) {
            if (!result.contains(f)) {
                result.add(f);
            }
        }
        for (String s: second) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
