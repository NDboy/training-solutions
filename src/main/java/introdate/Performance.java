package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private String artist;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance(String artist, int year, int month, int day, int starthour, int startminute,int endhour, int endminute) {
        this.artist = artist;
        this.date = LocalDate.of(year, month, day);
        this.startTime = LocalTime.of(starthour, startminute);
        this.endTime = LocalTime.of(endhour, endminute);
    }

    public String getInfo() {
        return artist + ": " + date + " " + startTime + " - " + endTime;
    }

}
