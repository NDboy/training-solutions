package week08.week08d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public int findMostZeroWithStream(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            return getMaxLength(bufferedReader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int getMaxLength(BufferedReader bufferedReader) throws IOException {
        int maxLength = 0;
        int counter = 0;
        int zeroOrOne;
        while ((zeroOrOne = bufferedReader.read()) > 0) {
            if (zeroOrOne == 48) {
                counter++;
            } else {
                maxLength = Math.max(maxLength, counter);
                counter = 0;
            }
        }
        return maxLength;
    }

}
//    Egy repülőgéppel átszeljük az óceánt és a közben méréseket végzünk.
//    Tudjuk, hogy partól indulunk és parthoz érünk. A méréseket adott időközönként egyenletesen végezzük.
//    A mérések azt mutatják, hogy sziget vagy óceán fölött repülünk éppen.
//    Az 1-es szigetet míg a 0 óceánt jelöl.
//    A map.txt állományban egy "térképet" tárolunk.
//    A feladat az, hogy "repüljünk" a térkép fölött végig és határozzuk meg a leghosszabb óceán szakasz hosszát.
//    A térkép fölött csak egyszer repülhetünk el és amikor leszálltunk már tudnunk is kell az eredményt.
//    (Magyarul ne olvasd be a file-t a memóriába) A feladatot a week08d05.Plane osztályba végezzük el. A térkép:
//    10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011
