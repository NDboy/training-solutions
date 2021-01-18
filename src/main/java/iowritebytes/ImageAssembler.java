package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {
    public void makeImageFile(byte[][] source, Path folder) {
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(folder.resolve("image.png")))){
            for (byte[] byteArr: source) {
                bos.write(byteArr);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
