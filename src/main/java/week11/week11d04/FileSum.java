package week11.week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSum {

    private List<String> listMaker() {
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
           fileNames.add(String.format("number%02d.txt", i));
        }
        return fileNames;
    }

    public int fileReaderAndParser(String pathString) {
        int result = 0;
        if (Files.isRegularFile(Path.of(pathString))) {
            String content;
            try {
                content = Files.readString(Path.of(pathString));
                result = Integer.parseInt(content);
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file", ioe);
            }
        }
        return result;
    }

    public int sumNumbers(){
        int sum = 0;
        List<String> fileNames = listMaker();
        for (String fileName: fileNames) {
            sum += fileReaderAndParser(fileName);

        }
        return sum;
    }

}

//    Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
//        Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
//        számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
//        Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály sumNumbers(InputStream) metódusába dolgozz!
