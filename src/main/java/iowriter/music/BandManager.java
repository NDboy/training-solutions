package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();

    public List<Band> getBands() {
        return bands;
    }

    public void readBandsFromFile(Path path) {
        String line;
        String name;
        int year;
        try (BufferedReader br = Files.newBufferedReader(path)){
            while ((line = br.readLine()) != null) {
                name = line.split(";")[0];
                year = Integer.parseInt(line.split(";")[1]);
                bands.add(new Band(name, year));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void writeBandsBefore(Path path, int year) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            for (Band band : bands) {
                if (band.getYear() < year) {
                    bw.write(String.format("%s;%d%n", band.getName(), band.getYear()));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        BandManager bm = new BandManager();
        bm.readBandsFromFile(Path.of("bands_and_years.txt"));
        System.out.println(bm.getBands().size());
        System.out.println(bm.getBands().get(1).getName());

        Path path = Path.of("testing.txt");
        bm.writeBandsBefore(path, 1980);
    }

}
