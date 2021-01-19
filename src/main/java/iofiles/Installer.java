package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {


    public void install(String targetDirectory) {
        Path targetFolder = Path.of(targetDirectory);
        if (!Files.exists(targetFolder) || !Files.isDirectory(targetFolder)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/install/install.txt")))){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(targetFolder.resolve(line));
                } else {
                    String filePath = String.format("/install/%s", line);
                    Files.copy(this.getClass().getResourceAsStream(filePath),
                            targetFolder.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
