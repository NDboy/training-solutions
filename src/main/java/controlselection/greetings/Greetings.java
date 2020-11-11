package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {
    private int actualHour;
    private int actualMinute;
    private LocalTime time;

    public static final LocalTime morningStart = LocalTime.of(5,0);
    public static final LocalTime dayStart = LocalTime.of(9,0);
    public static final LocalTime eveningStart = LocalTime.of(18,30);
    public static final LocalTime nightStart = LocalTime.of(20,0);

    public Greetings(int actualHour, int actualMinute) {
        this.actualHour = actualHour;
        this.actualMinute = actualMinute;
        this.time = LocalTime.of(actualHour, actualMinute);
    }

    public int getActualHour() {
        return actualHour;
    }

    public int getActualMinute() {
        return actualMinute;
    }

    public LocalTime getTime() {
        return time;
    }

    public String findGreeting(int actualHour, int actualMinute) {
        this.time = LocalTime.of(actualHour, actualMinute);
        String actualGreeting;
        if (time.isBefore(morningStart)) {
            actualGreeting = "Jó éjt!";
        } else if (time.isBefore(dayStart)) {
            actualGreeting = "Jó reggelt!";
        } else if (time.isBefore(eveningStart)) {
            actualGreeting = "Jó napot!";
        } else if (time.isBefore(nightStart)) {
            actualGreeting = "Jó estét!";
        } else {
            actualGreeting = "Jó éjt!";
        }
        return actualGreeting;
    }


    public static void main(String[] args) {
        Greetings greetings = new Greetings(20,0);
        System.out.println(greetings.findGreeting(greetings.getActualHour(), greetings.getActualMinute()));

    }
}
