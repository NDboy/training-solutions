package week08.week08d02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void loadFileToListWithStream(Path path) {
        try(Stream<String> linesStream = Files.lines(path)) {
            linesStream
                    .map(this::createCountryFromString)
                    .forEach(countries::add);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private Country createCountryFromString(String lineString) {
        String name = lineString.split(" ")[0];
        int pop = Integer.parseInt(lineString.split(" ")[1]);
        int flag = Integer.parseInt(lineString.split(" ")[2]);
        int neigh = Integer.parseInt(lineString.split(" ")[3]);
        return new Country(name, pop, flag, neigh);
    }

    public Country maxPopulationWithStream() {
        return getCountries().stream()
                .max(Comparator.comparing(Country::getPopulation))
                .orElse(null);
    }

    public static void main(String[] args) {
        CountryStatistics cs = new CountryStatistics();
        cs.loadFileToListWithStream(Path.of("countries.txt"));
        System.out.println(cs.maxPopulationWithStream());
    }
}

//    Adott a countries.txt állomány, melyet helyezz el a projekt gyökérkönyvtárába.
//    A fájlban az adatok a következők:
//    ország_neve népesség hány_színű_a_zászló szomszédos_országok_száma.
//    Készíts a week08d02 csomagba egy CountryStatistics osztályt melyben van egy metódus,
//    ami az adatokat beolvassa egy listába. A lista legyen az osztály privát attribútuma,
//    és legyen hozzá getter metódus, figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát.
//    Készíts egy metódust maxPopulaton() néven, ami a listából visszaadja a legnagyobb népességű ország minden adatát.
