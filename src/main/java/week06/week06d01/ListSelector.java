package week06.week06d01;

import java.util.List;

public class ListSelector {

    public String selectList(List<String> words) {
        if (words == null) {
            throw new NullPointerException("The list must not be empty!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i % 2 == 0) {
                sb.append(words.get(i));
            }
        }
        if ("".equals(sb.toString())) {
            return "";
        }
        return String.format("[%s]",sb.toString());
    }

}

