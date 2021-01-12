package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Register {
    private String name;
    private int mark;

    public void newMark(Path path, int mark) {
        try {
            if (Files.exists(path)) {
                Files.writeString(path, Integer.toString(mark) + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(path, Integer.toString(mark));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }

    public void average(Path path) {
        List<String> marks = new ArrayList<>();
        double markSum = 0.0;
        double average = 0.0;
        try {
            marks = Files.readAllLines(path);
            for (String mark: marks) {
                markSum += Double.parseDouble(mark);
            }
            average = markSum / marks.size();
            Files.writeString(path, String.format(Locale.ENGLISH,"average: %.1f", average), StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }



}
