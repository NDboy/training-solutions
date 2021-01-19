package iofilestest.cheese;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {

    @TempDir
    public File folder;

    @Test
    void testSaveToFileAndFindCheeseByName() throws IOException {
        List<Cheese> cheeses = List.of(
                new Cheese("Trappista", 0.12),
                new Cheese("Mozzarella", 0.98),
                new Cheese("Roquefort", 0.05));
        CheeseManager cheeseManager = new CheeseManager();
        cheeseManager.saveToFile(folder.toPath().resolve("cheesetest.dat"), cheeses);
        List<Cheese> readCheeses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Files.newInputStream(folder.toPath().resolve("cheesetest.dat"))))){
            String line;
            while ((line = br.readLine()) != null) {
                String name = line.split("-")[0];
                double lactoseContent = Double.parseDouble(line.split("-")[1]);
                readCheeses.add(new Cheese(name, lactoseContent));
            }
        }
        assertEquals(3, readCheeses.size());
        assertEquals(0.05, readCheeses.get(2).getLactoseContent());

        Cheese foundCheese = cheeseManager.findCheese(folder.toPath().resolve("cheesetest.dat"), "Roquefort");
        assertEquals(0.05, foundCheese.getLactoseContent());
        assertEquals("Roquefort-0.05", foundCheese.toString());
    }


}