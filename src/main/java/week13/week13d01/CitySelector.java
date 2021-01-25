package week13.week13d01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CitySelector {

    public String selectLongestCityName(Path path) {
        String longestName = null;
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(";");
                if (longestName == null || lineArray[1].trim().length() > longestName.length()) {
                    longestName = lineArray[1].trim();
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return longestName;
    }

}