package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    private void writeList(Writer writer, List<String> words) {
        PrintWriter pw = new PrintWriter(writer);
        for (String word : words) {
                pw.print(word);
                pw.println(word.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter sw = new StringWriter();
        try (sw){
            writeList(sw, words);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not close writer", ioe);
        }
        return sw.toString();
    }

}
