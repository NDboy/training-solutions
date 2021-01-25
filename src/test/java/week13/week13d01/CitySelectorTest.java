package week13.week13d01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CitySelectorTest {

    @TempDir
    File folder;



    @Test
    void testSelectLongestCityName() {
        String testString = "1212;Pest;ddddddddddddddddddd\n1212;Szeged\n5454;Debrecen\n5454;                 Baks\n45454;Jászkaraszörcsög\n5454; Baja   \n";
        CitySelector cs = new CitySelector();
        Path path = folder.toPath().resolve("test.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(testString);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write test file", ioe);
        }

        assertEquals("Jászkaraszörcsög", cs.selectLongestCityName(path));

    }

}