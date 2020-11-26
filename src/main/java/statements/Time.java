package statements;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getInMinutes() {
        return hours * 60 + minutes;
    }

    public int getInSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public boolean earlierThan(Time anotherTime) {
        int thisTimeInSeconds = this.getInSeconds();
        int anotherTimeInSeconds = anotherTime.getInSeconds();
        return thisTimeInSeconds < anotherTimeInSeconds;
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
