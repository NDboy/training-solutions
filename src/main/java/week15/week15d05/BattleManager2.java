package week15.week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class BattleManager2 {


    public String findMostFightingFamily() {

        List<String> familyList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("battles.csv"))){
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                splitStringAndAddToList(familyList, line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return findKeyWithMaxValue(familyList).orElseThrow(() -> new IllegalArgumentException("Wrong list")).getKey();
    }


    private void splitStringAndAddToList(List<String> families, String lineString) {
        Arrays.stream(lineString.split(","))
                .skip(5)
                .limit(8)
                .filter(a->!isEmpty(a))
                .distinct()
                .forEach(families::add);
    }


    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }


    private Optional<Map.Entry<String, List<String>>> findKeyWithMaxValue(List<String> families) {
        return families.stream()
//                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .collect(Collectors.groupingBy(a -> a))
//                .collect(Collectors.toMap(a->a, Collectors.mapping(Collectors.counting())))
                .entrySet()
                .stream()
//                .max(Comparator.comparingLong(Map.Entry::getValue));
                .max(Comparator.comparingInt(a->a.getValue().size()));
    }

    public static void main(String[] args) {
        BattleManager2 bm = new BattleManager2();
        System.out.println(bm.findMostFightingFamily());

    }

}
