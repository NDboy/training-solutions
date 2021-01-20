package week12.week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void loadList(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                for (String str: strings) {
                    numbers.add(Integer.parseInt(str));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOnlyOne () {
        if (numbers == null || numbers.size() < 1) {
            throw new IllegalArgumentException("empty list");
        }
        int counter = 0;
        int smallest = 0;
        for (Integer number: numbers) {
            for (Integer number2: numbers) {
                if (number == number2) {
                    counter++;
                }
            }
            if (counter == 1 && (smallest == 0 || number < smallest)) {
                smallest = number;
            }
            counter = 0;
        }
        return smallest;
    }


//    public static void main(String[] args) {
//        NumberStat ns = new NumberStat();
//        List<Integer> numbers = Arrays.asList(1,1,5,3,4,5,6,5,6,4,1,6,5,4,2,7);
//        System.out.println(ns.numberOnlyOne(numbers));
//    }


}

//    Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus,
//    ami paraméterül vár egy egész számokból álló listát.
//    Add vissza azt a számot amelyik pontosan egyszer szerepel a listában.
//    Ha több ilyen szám van akkor a kisebbet! Ellenőrizd, hogy olyan listát fogadunk el,
//    ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
//        pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
//        Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma.
//        A fent megírt metódus ezen a listán dolgozzon. A lista elemeit fájlból töltsük fel.
//        A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:
//        1,1,4
//        2,3,5
//        2,2,5,5,6
//        12,2,1,0
//         0,1
