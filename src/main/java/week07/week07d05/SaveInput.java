package week07.week07d05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SaveInput {

    private StringBuilder stringBuilder = new StringBuilder();

    public void appendLineToStringBuilder(String lineString) {
        stringBuilder.append(lineString + "\n");
    }

    public void saveStringBuilderToFile(String pathString) {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(pathString))){
            bw.write(stringBuilder.toString());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        SaveInput si = new SaveInput();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Enter %d. text line%n", i);
            si.appendLineToStringBuilder(scanner.nextLine());
        }
        System.out.println("Enter the file name to save the text");
        si.saveStringBuilderToFile(scanner.nextLine());
    }

}
