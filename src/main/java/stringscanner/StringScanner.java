package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }


    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString) || delimiter == null) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner sc = new Scanner(intString).useDelimiter(delimiter);
        int sum = 0;
        try {
            while (sc.hasNext()) {
                sum += sc.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sum;
    }


    public int readAndSumValues(String intString) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner sc = new Scanner(intString);
        int sum = 0;
        try {
            while (sc.hasNext()) {
                sum += sc.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sum;
    }


    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        StringBuilder newTextWithOccurrences = new StringBuilder();
        Scanner sc = new Scanner(text);
        String line = "";
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.contains(word)) {
                newTextWithOccurrences.append(line + "\n");
            }
        }
        return newTextWithOccurrences.toString().trim();
    }
}
