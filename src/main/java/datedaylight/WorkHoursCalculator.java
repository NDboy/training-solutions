package datedaylight;

import java.time.*;

public class WorkHoursCalculator {

    private ZonedDateTime zonedDateTime;
    private LocalDateTime localDateTime;
    private final int START_MINUTE = 0;
    private ZoneId zone;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        this.zone = zone;
        localDateTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, START_MINUTE);
        this.zonedDateTime = ZonedDateTime.of(localDateTime, zone);
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        ZonedDateTime endDateTime = ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, START_MINUTE), zone);
        Duration duration = Duration.between(zonedDateTime, endDateTime);
        return duration.toHours();
    }

    public ZonedDateTime getStartDateTime() {
        return zonedDateTime;
    }
}
