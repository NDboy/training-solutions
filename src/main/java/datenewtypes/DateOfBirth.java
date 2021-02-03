package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.regex.Pattern;

public class DateOfBirth {
    private LocalDate date;
//    private DateTimeFormatter dateTimeFormatter;
//    private Locale locale;

    public DateOfBirth(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String date, String pattern, Locale locale) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern, locale));
    }

    public DateOfBirth(String date, String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public LocalDate getDateOfBirth() {
        return date;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate laterDate) {
        return laterDate.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }


    public int countDaysSinceBirth(LocalDate localDate) {
        if (localDate.isBefore(date)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return (int)(ChronoUnit.DAYS.between(date, localDate));
    }

    public int countDaysBetween(DateOfBirth newDateOfBirth) {
        return (int) (ChronoUnit.DAYS.between(date, newDateOfBirth.getDateOfBirth()));
    }
}
