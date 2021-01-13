package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {
    public Temperatures readTemperatures(String pathString) {
        Path path = Path.of(pathString);
        byte [] content;
        try {
            content = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
        return new Temperatures(content);
    }
}
