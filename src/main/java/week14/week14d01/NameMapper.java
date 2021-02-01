package week14.week14d01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameMapper {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String name: names){
            if (!result.containsKey(name.charAt(0))) {
                List<String> listWithLetter = new ArrayList<>();
                listWithLetter.add(name);
                result.put(name.charAt(0), listWithLetter);
            } else {
                result.get(name.charAt(0)).add(name);
            }
        }
        return result;
    }
}
