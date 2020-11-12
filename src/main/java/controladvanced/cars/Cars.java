package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<String> lines;


    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {
                continue;
            } else if (!parts[0].contains("-")){
                continue;
            } else if (parts[0].length() != 7) {
                continue;
            } else if (Integer.parseInt(parts[1]) >= 2019 && Integer.parseInt(parts[1]) <= 1970) {
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }
}
