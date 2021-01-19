package iofilestest.cheese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeses) {
        try (OutputStreamWriter osw = new OutputStreamWriter(Files.newOutputStream(path))){
            for (Cheese cheese: cheeses) {
                osw.write(cheese.toString() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public Cheese findCheese(Path path, String cheeseName) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(path)))){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(cheeseName)) {
                    String name = line.split("-")[0];
                    double lactoseContent = Double.parseDouble(line.split("-")[1]);
                    return new Cheese(name, lactoseContent);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
        return null;
    }


}
