package week07.week07d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {

    public long calculateSum(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)){
            return br.lines()
                    .map(this::processLine)
                    .reduce(Long::sum)
                    .orElse(0L);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private long processLine(String lineString) {
        return Long.parseLong(lineString.split(";")[1])
            * Long.parseLong(lineString.split(";")[2]);
    }

    public void createShoppingListToFile(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            for (int i = 1; i < 10; i++) {
                String formatString = String.format("product0%d;%d;%d%n", i, i * 10, 100 + i * 5);
                bw.write(formatString);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
