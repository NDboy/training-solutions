package week15.week15d04;

import java.time.LocalDate;

public class WeeklyData {
    private LocalDate dateRep;
    private String yearWeek;
    private int casesWeekly;
    private int deathWeekly;
    private String countryAndTerritory;
    private String geoId;
    private String countryCode;
    private int popData2019;
    private String continent;
    private double noteRate;

    public WeeklyData(String yearWeek, int casesWeekly, String countryAndTerritory) {
        this.yearWeek = yearWeek;
        this.casesWeekly = casesWeekly;
        this.countryAndTerritory = countryAndTerritory;
    }

    public String getYearWeek() {
        return yearWeek;
    }

    public int getCasesWeekly() {
        return casesWeekly;
    }

    public String getCountryAndTerritory() {
        return countryAndTerritory;
    }

    @Override
    public String toString() {
        return "yearWeek='" + yearWeek + '\'' +
                ", casesWeekly=" + casesWeekly +
                ", countryAndTerritory='" + countryAndTerritory;
    }
}
