package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String pathString) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(pathString)))) {
            String name;
            int borderCountries;
            String line;
            while ((line = br.readLine()) != null) {
                name = line.split(" ")[0];
                borderCountries = Integer.parseInt(line.split(" ")[1]);
                countryList.add(new Country(name, borderCountries));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOFCountries() {
        return getCountryList().size();
    }

    public Country mostBorderCountries() {
        Country country = countryList.get(0);
        for (Country actualCountry : countryList) {
            if (actualCountry.getBorderCountries() > country.getBorderCountries()) {
                country = actualCountry;
            }
        }
        return country;
    }

    public static void main(String[] args) {
        CountryStatistics cs = new CountryStatistics();
        cs.readFromFile("/country.txt");
        System.out.println(cs.getCountryList().size());
    }
}
