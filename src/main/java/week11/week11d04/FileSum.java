package week11.week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSum {

    public int sumNumbers(){
        int sum = 0;
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                fileNames.add(String.format("number0%d.txt", i));
            } else if (i >= 10) {
                fileNames.add(String.format("number%2d.txt", i));
            }
        }
        for (String fileName: fileNames) {
            if (Files.isRegularFile(Path.of(fileName))) {
                String content;
                try {
                    content = Files.readString(Path.of(fileName));
                    sum += Integer.parseInt(content);
                } catch (IOException ioe) {
                    throw new IllegalStateException("Can not read file", ioe);
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new FileSum().sumNumbers());

    }

}

//    Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
//        Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
//        számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
//        Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály sumNumbers(InputStream) metódusába dolgozz!
