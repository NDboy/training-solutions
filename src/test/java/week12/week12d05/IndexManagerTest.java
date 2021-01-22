package week12.week12d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class IndexManagerTest {

    @TempDir
    public File folder;

    @Test
    void testCovidLineCounter () {
        String testString = "koronavírus\nkoronavíruskjhjkkoronavírus\nkhjzuuzhkoronavírus\ndjghfihgfu\nKoronavírus\nlhjiofdheofih\nkjhkjKORONAVÍRUS";
        IndexManager im = new IndexManager();
        Path path = folder.toPath().resolve("test.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(testString);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write test file", ioe);
        }

        assertEquals(5, im.covidLineCounter(path));
    }

    @Test
    void wrongPathShouldThrowException() {

        String testString = "koronavírus\nkoronavíruskjhjkkoronavírus\nkhjzuuzhkoronavírus\ndjghfihgfu\nKoronavírus\nlhjiofdheofih\nkjhkjKORONAVÍRUS";
        IndexManager im = new IndexManager();
        Path path = folder.toPath().resolve("test.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(testString);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write test file", ioe);
        }
        Path path2 = folder.toPath().resolve("te_st.txt");

        Exception exception = assertThrows(IllegalStateException.class, () -> new IndexManager().covidLineCounter(path2));
        assertEquals("Can not read file", exception.getMessage());

    }
}