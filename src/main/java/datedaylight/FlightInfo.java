package datedaylight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private String dateString;
    private final String PATTERN = "HHmm, dd MMM yyyy";
    private String pattern;
    private Locale locale;
    private ZoneId zone;
    private LocalDateTime localDateTime;
    private ZonedDateTime zonedDateTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        this.dateString = dateString;
        this.pattern = pattern;
        this.locale = locale;
        this.zone = zone;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern, locale);
        localDateTime = LocalDateTime.parse(dateString, dtf);
        zonedDateTime = ZonedDateTime.of(localDateTime, zone);
    }

    private boolean isEmpty (String str) {
        return str == null || str.isBlank();
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        Duration duration = Duration.ofHours(flightHours).plusMinutes(flightMinutes);
        ZonedDateTime arrival = zonedDateTime.plus(duration);
        return arrival.withZoneSameInstant(zone);
    }

    public ZonedDateTime getDepartureDateTime() {

        return ZonedDateTime.of(localDateTime, zone);
    }
}
