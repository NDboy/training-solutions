package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FaultList {

    private final static int NOT_LINE_NUMBER = -1;

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("List not found!");
        }
        List<String> faults = new ArrayList<>();
        for (String line : lines) {
            ProcessingResult result = stringParser(line);
            if (result != ProcessingResult.COMMENT && result != ProcessingResult.NO_ERROR) {
                faults.add(lineNumber(line.split(",")[0]) + "," + result.getCode());
            }
        }
        return faults;
    }

    private ProcessingResult stringParser(String line) {
        String [] lineArray = line.split(",");
        if (lineNumber(lineArray[0]) == NOT_LINE_NUMBER) {
            return ProcessingResult.COMMENT;
        }
        if (lineArray.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }
        if (!isDouble(lineArray[1]) && !isDateFormat(lineArray[2])) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        }
        if (!isDouble(lineArray[1])) {
            return ProcessingResult.VALUE_ERROR;
        } else if (!isDateFormat(lineArray[2])) {
            return ProcessingResult.DATE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private int lineNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return NOT_LINE_NUMBER;
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDateFormat(String str) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
            df.parse(str);
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }

}
