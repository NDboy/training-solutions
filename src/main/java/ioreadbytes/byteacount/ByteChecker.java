package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String pathString) {
        int counter = 0;
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Path.of(pathString)))) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = bis.read(buffer)) > 0) {
                for (int i = 0; i < size; i++){
                    if (buffer[i] == 97) {
                        counter++;
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return counter;
    }

}
