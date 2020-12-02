package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    private List<SimpleTime> timeTable = new ArrayList<>();
    private int firstHour;
    private int lastHour;
    private int everyMinute;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        int i = firstHour;
        while (i <= lastHour) {
            timeTable.add(new SimpleTime(i, everyMinute));
            i++;
        }
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        int diff = 0;
        SimpleTime better = null;
        for (SimpleTime time : timeTable) {
            if (diff == 0 || (Math.abs(time.difference(actual)) < Math.abs(diff) && time.difference(actual) > 0)) {
                better = time;
                diff = time.difference(actual);
            }
        }
        if (better.difference(actual) < 0) {
            throw new IllegalStateException("No more buses today!");
        }
        return better;
    }

    public SimpleTime firstBus() {
        return nextBus(new SimpleTime(0,0));
    }

}
