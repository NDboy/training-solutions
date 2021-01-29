package week13.week13d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateMerger {


    private static String templateMaker(String originalTemplate) {
        Pattern namePattern = Pattern.compile("\\{nev}");
        Pattern yearPattern = Pattern.compile("\\{ev}");
        Matcher templateMatcher = namePattern.matcher(originalTemplate);
        StringBuffer stringBuffer = new StringBuffer();
        while (templateMatcher.find()) {
            templateMatcher.appendReplacement(stringBuffer, "%s");
        }
        String nameChangedString = templateMatcher.appendTail(stringBuffer).toString();
        Matcher templateMatcher2 = yearPattern.matcher(nameChangedString);
        StringBuffer stringBuffer2 = new StringBuffer();
        while (templateMatcher2.find()) {
            templateMatcher2.appendReplacement(stringBuffer2, "%d");
        }
        return templateMatcher2.appendTail(stringBuffer2).toString();

    }

    private String insertEmployeesToTemplate(List<Employee> employees, String template) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee: employees) {
            stringBuilder.append(String.format(templateMaker(template), employee.getName(), employee.getYearOfBirth()) + "\n");
        }
        return stringBuilder.toString();
    }

    public String merge(Path file, List<Employee> employees) {
        String template;
        try (BufferedReader br = Files.newBufferedReader(file)){
            template = br.readLine();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return insertEmployeesToTemplate(employees, template);
    }


}


