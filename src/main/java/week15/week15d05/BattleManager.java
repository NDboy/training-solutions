package week15.week15d05;

import week15.week15d04.WeeklyData;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;

import java.util.Map;

public class BattleManager {

    public String findMostFightingFamily() {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("battles.csv"))){
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String [] lineArray = line.split(",");

                boolean singleFound = false;
                for (int i = 5; i < 13; i++) {
                    if (!isEmpty(lineArray[i]) && !result.containsKey(lineArray[i])) {
                        result.put(lineArray[i], 1);
                        singleFound = true;
                    } else if (!isEmpty(lineArray[i]) && !singleFound){
                        int newValue = result.get(lineArray[i]) + 1;
                        result.put(lineArray[i], newValue);
                    }
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        String family = null;
        int max = 0;
        for (String key: result.keySet()) {
            if (result.get(key) > max) {
                family = key;
                max = result.get(key);
            }
        }
        return family;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }


}
