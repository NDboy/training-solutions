package dateduration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {

    private List<Duration> durationList = new ArrayList<>();

    public void addWorkTime(Duration duration) {
        durationList.add(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        durationList.add(Duration.ofDays(days).plusHours(hours).plusMinutes(minutes));
    }

    public void addWorkTime(String durationString) {
        throwExceptionIfStringIsEmpty(durationString);
        try {
            durationList.add(Duration.parse(durationString));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString, dtpe);
        }
    }

    private void throwExceptionIfStringIsEmpty (String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
    }

    public Duration getWorkDuration() {
        Duration duration = Duration.ZERO;
        for (Duration dur : durationList) {
            duration = duration.plus(dur);
        }
        return duration;
    }

    public int calculateWorkHours() {
        return (int)(getWorkDuration().toHours());
    }

    @Override
    public String toString() {
        Duration workObject = Duration.ZERO;
        workObject = workObject.plus(getWorkDuration());
        long days = workObject.toDays();
        workObject = workObject.minusDays(days);
        long hours = workObject.toHours();
        workObject = workObject.minusHours(hours);
        long minutes = workObject.toMinutes();
        return String.format("Days: %d, hours: %d, minutes: %d", days, hours, minutes);

    }
}
