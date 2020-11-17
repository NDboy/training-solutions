package stringscanner;

import java.util.Scanner;

public class StringScanner {
    private String intString;
    private String delimiter;
    private String text;
    private String word;

    private boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public StringScanner(String intString, String delimiter, String text, String word) {
        if (intString.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.intString = intString;
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.delimiter = delimiter;
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.text = text;
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.word = word;
    }

    public int readAndSumValues(String intString, String delimiter) {
        Scanner s = new Scanner(intString).useDelimiter(delimiter);
        int sum = 0;
        while (s.hasNextInt()) {
            sum = sum + s.nextInt();
        }
        return sum;

    }


}
