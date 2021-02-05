package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class PensionCalculator {

    private Period period = Period.ZERO;

    public void addEmploymentPeriod(Period period) {
        this.period = this.period.plus(period);
    }

    public Period sumEmploymentPeriods() {
        return period.normalized();
    }

    public Period modifyByDays(Period period, int days) {
        return period.plusDays(days).normalized();
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        throwExceptionIfArgumentIsNull(fromDate, toDate);
        return Period.between(fromDate, toDate);
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        throwExceptionIfStringIsEmpty(fromDate, toDate, pattern);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return Period.between(LocalDate.from(dtf.parse(fromDate)), LocalDate.from(dtf.parse(toDate)));
    }

    private void throwExceptionIfStringIsEmpty (String fromDate, String toDate, String pattern) {
        if (fromDate == null || fromDate.isBlank()) {
            throw new IllegalArgumentException("Empty from date string, cannot use: ");
        }
        if (toDate == null || toDate.isBlank()) {
            throw new IllegalArgumentException("Empty to date string, cannot use: ");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

    }

    private void throwExceptionIfArgumentIsNull (Object... objects) {
        for (Object object: objects) {
            if (object == null) {
                throw new NullPointerException("Null parameters are not allowed!");
            }
        }
    }



}
