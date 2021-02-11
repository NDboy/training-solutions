package week15.week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CovidManager {

    private List<WeeklyData> weeklyDataList = new ArrayList<>();

    public void loadFileToList() {
        Path path = Path.of("covid.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                weeklyDataList.add(parseLine(line));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
    }

    private WeeklyData parseLine(String lineString) {
        String [] lineArray = lineString.split(",");
        String week = lineArray[1];
        int cases = Integer.parseInt(lineArray[2]);
        String country = lineArray[4];
        return new WeeklyData(week, cases, country);
    }

    public List<WeeklyData> selectThreeWorstWeek() {
        return weeklyDataList.stream()
                .filter(a -> a.getCountryAndTerritory().equals("Hungary"))
                .sorted(Comparator.comparing(WeeklyData::getCasesWeekly, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
    }

}

