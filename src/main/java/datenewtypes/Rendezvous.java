package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime localTime;

    public Rendezvous(String time, String pattern) {
        throwExceptionIfPatternIsEmpty(pattern);
        try {
            this.localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }
    }

    public Rendezvous(int hour, int minute) {
        this.localTime = LocalTime.of(hour, minute);
    }

    private void throwExceptionIfPatternIsEmpty (String patternString) {
        if (patternString == null || patternString.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }

    public String toString(String pattern) {
        throwExceptionIfPatternIsEmpty(pattern);
        return localTime.format(DateTimeFormatter.ofPattern(pattern));
    }


    public int countMinutesLeft(LocalTime timeNow) {
        if (timeNow.isAfter(localTime)) {
            throw new MissedOpportunityException("Too late!");
        }
        return (int) (ChronoUnit.MINUTES.between(timeNow, localTime));
    }

    public void pushLater(int hour, int minute) {
        localTime = localTime.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        localTime = localTime.minusHours(hour).minusMinutes(minute);
    }
}
