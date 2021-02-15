package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {

    private final static String CONSONANTS = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";

    public static String filterVowels(BufferedReader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null){
                for (int i = 0; i < line.length(); i++) {
                    if (CONSONANTS.contains(String.valueOf(line.charAt(i)))) {
                        stringBuilder.append(line.charAt(i));
                    }
                }
                stringBuilder.append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        VowelFilter vowelFilter = new VowelFilter();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("mcsk.txt"))){
            System.out.println(VowelFilter.filterVowels(reader));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }
}

//    Írj egy VowelFilter.filterFowels(BufferedReader reader) metódust, mely beolvas egy
//        fájlt soronként, kiszűri belőle a magánhangzókat, és visszaadja egy String-ként.
//        Tehát a bemeneti fájl tartalma:
//        Aprócska
//        Kalapocska
//        Benne
//        Csacska
//        Macska
//        Mocska
//        Kimenet Stringként:
//        prcsk
//        Klpcsk
//        Bnn
//        Cscsk
//        Mcsk
//        Mcsk

