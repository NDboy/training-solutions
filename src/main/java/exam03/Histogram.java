package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null){
                int number = Integer.parseInt(line);
                for (int i = 0; i < number; i++) {
                    stringBuilder.append('*');
                }
                stringBuilder.append("\n");
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return stringBuilder.toString();
    }
}
