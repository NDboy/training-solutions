package week12.week12d05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class IndexManager {

    public int covidLineCounter(Path path) {
        int counter = 0;
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("koronavírus")) {
                    counter++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return counter;
    }


}
