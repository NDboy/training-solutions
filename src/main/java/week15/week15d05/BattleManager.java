package week15.week15d05;

import week15.week15d04.WeeklyData;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.*;

public class BattleManager {

    public String findMostFightingFamily() {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("battles.csv"))){
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Set<String> familiesSet = splitStringToSet(line);
                putFamiliesToMapFromSet(result, familiesSet);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return findKeyWithMaxValue(result);
    }

    private Set<String> splitStringToSet(String lineString) {
        String [] lineArray = lineString.split(",");
        String [] onlyFamiliesArray = Arrays.copyOfRange(lineArray, 5, 13);
        return new HashSet<>(Arrays.asList(onlyFamiliesArray));
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private void putFamiliesToMapFromSet(Map<String, Integer> mapReference, Set<String> familySet) {
        for (String family: familySet) {
            if (!isEmpty(family)) {
                if (!mapReference.containsKey(family)) {
                    mapReference.put(family, 1);
                } else {
                    int newValue = mapReference.get(family) + 1;
                    mapReference.put(family, newValue);
                }
            }
        }
    }

    private String findKeyWithMaxValue(Map<String, Integer> mapReference) {
        String mostAggressiveFamily = null;
        int max = 0;
        for (String key: mapReference.keySet()) {
            if (mapReference.get(key) > max) {
                mostAggressiveFamily = key;
                max = mapReference.get(key);
            }
        }
        return mostAggressiveFamily;
    }

}
