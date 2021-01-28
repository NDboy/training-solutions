package lambdaintro;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File folder) {

        File[] fileArray = folder.listFiles(file
                -> file.isFile() && (file.getName().toLowerCase().endsWith(".xlsx")
                || file.getName().toLowerCase().endsWith(".pptx")
                || file.getName().toLowerCase().endsWith(".docx")));
        List<File> result = Arrays.asList(fileArray);
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
