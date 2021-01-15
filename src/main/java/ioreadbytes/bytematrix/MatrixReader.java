package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {


    private List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

    public void readBytesAndCreateMatrix(String pathString) {
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Path.of(pathString)))) {
            byte[] bytes = new byte[1000];
            int size;
            while ((size = bis.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int counter = 0;
        int[] counterArray = new int[1000];
        for (byte[] bytes : myMatrix) {
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == 48) {
                    counterArray[i]++;
                }
            }
        }
        for (int i : counterArray) {
            if (i > 4) {
                counter++;
            }
        }
        return counter;
    }


}
