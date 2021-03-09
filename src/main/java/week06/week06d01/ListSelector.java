package week06.week06d01;

import ch.qos.logback.core.joran.conditional.IfAction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSelector {

//    public String selectList(List<String> words) {
//        if (words == null) {
//            throw new NullPointerException("The list must not be empty!");
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < words.size(); i++) {
//            if (i % 2 == 0) {
//                sb.append(words.get(i));
//            }
//        }
//        if ("".equals(sb.toString())) {
//            return "";
//        }
//        return String.format("[%s]",sb.toString());
//    }

    public String selectList(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException("The list must not be empty!");
        }
        return IntStream
                .range(0, words.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(words::get)
//                .collect(Collectors.joining("", "[", "]"));
                .collect(Collector.of(() -> new StringJoiner("", "[", "]").setEmptyValue(""),
                        StringJoiner::add,
                        StringJoiner::merge,
                        StringJoiner::toString));
    }





    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alma", "banán", "narancs", "kiwi");
        ListSelector ls = new ListSelector();

        System.out.println(ls.selectList(strings));
        System.out.println(ls.selectList(Collections.emptyList()));

    }

}


