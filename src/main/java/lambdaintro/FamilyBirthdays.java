package lambdaintro;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... dates) {
        this.birthdays = Arrays.asList(dates);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        for (LocalDate localDate : birthdays) {
            if (date.get(ChronoField.MONTH_OF_YEAR) == localDate.get(ChronoField.MONTH_OF_YEAR)
            && date.get(ChronoField.DAY_OF_MONTH) == localDate.get(ChronoField.DAY_OF_MONTH)) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        List<LocalDate> sortedDates = new ArrayList<>(birthdays);
        sortedDates.sort(Comparator.comparing(LocalDate::getMonth).thenComparing(LocalDate::getDayOfMonth));
        for (LocalDate localDate: sortedDates) {
            if (date.get(ChronoField.MONTH_OF_YEAR) < localDate.get(ChronoField.MONTH_OF_YEAR)
                    || (date.get(ChronoField.MONTH_OF_YEAR) == localDate.get(ChronoField.MONTH_OF_YEAR) && date.get(ChronoField.DAY_OF_MONTH) <= localDate.get(ChronoField.DAY_OF_MONTH))) {

                return ChronoLocalDate.from(LocalDate.of(date.get(ChronoField.YEAR), localDate.get(ChronoField.MONTH_OF_YEAR), localDate.get(ChronoField.DAY_OF_MONTH))).compareTo(LocalDate.from(date));
            }
        }
        return (int) ChronoUnit.DAYS.between((LocalDate.from(date)), LocalDate.of(date.get(ChronoField.YEAR) + 1, sortedDates.get(0).get(ChronoField.MONTH_OF_YEAR), sortedDates.get(0).get(ChronoField.DAY_OF_MONTH)));
    }
}
