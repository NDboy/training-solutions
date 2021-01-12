package ioreadstring.names;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path myFile;
    private List<Human> humans;

    public FileManager(String pathString) {
        myFile = Path.of(pathString);
        humans = new ArrayList<>();
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(myFile);
            for (String line: lines) {
                humans.add(new Human(line.split(" ")[0], line.split(" ")[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }


    }


}
