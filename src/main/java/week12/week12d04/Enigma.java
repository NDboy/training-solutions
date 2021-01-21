package week12.week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Enigma {

    public void bytesToChar(String str){
        Path path = Path.of(str);
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = bis.readAllBytes();/*Files.readAllBytes(path);*/
            for (byte b : bytes) {
                System.out.print((char) (b + 10));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

}
