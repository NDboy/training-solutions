package collectionsmap;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogParser {

    private static final int NUMBER_OF_ELEMENTS = 3;
    private static final int POSITION_OF_IP_ADDRESS = 0;
    private static final int POSITION_OF_ENTRY_DATE = 1;
    private static final int POSITION_OF_LOGIN = 2;
    private static final String SEPARATOR = ":";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    private List<Entry> stringSplitter(String str) {
        List<Entry> entries = new ArrayList<>();
        String[] lines = str.split("\n");
        for (String item: lines) {
            String [] elements = item.split(SEPARATOR);
            if (elements.length != NUMBER_OF_ELEMENTS) {
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            String ipAddress = elements[POSITION_OF_IP_ADDRESS];
            String dateString = elements[POSITION_OF_ENTRY_DATE];
            String login = elements[POSITION_OF_LOGIN];
            LocalDate entryDate;
            try {
                entryDate = LocalDate.parse(dateString, DATE_FORMAT);
            } catch (DateTimeException dte) {
                throw new IllegalArgumentException("Incorrect log: incorrect date", dte);
            }
            entries.add(new Entry(ipAddress, entryDate, login));
        }
        return entries;
    }

    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> entriesMap = new TreeMap<>();
        List<Entry> entries = stringSplitter(log);

        for (Entry entry : entries) {
            if (entriesMap.containsKey(entry.getIpAddress())) {
                entriesMap.get(entry.getIpAddress()).add(entry);
            } else {
                List<Entry> value = new ArrayList<>();
                value.add(entry);
                entriesMap.put(entry.getIpAddress(), value);
            }
        }
        return entriesMap;
    }

}
