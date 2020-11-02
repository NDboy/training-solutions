package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Hours?");
        int hours = scanner.nextInt();

        System.out.println("Minutes?");
        int minutes = scanner.nextInt();

        System.out.println("Seconds?");
        int seconds = scanner.nextInt();


        System.out.println("Another hours?");
        int hours2 = scanner.nextInt();

        System.out.println("Another minutes?");
        int minutes2 = scanner.nextInt();

        System.out.println("Another seconds?");
        int seconds2 = scanner.nextInt();

        Time time = new Time(hours, minutes, seconds);
        Time anotherTime = new Time(hours2, minutes2, seconds2);

        System.out.println("Az első időpont: " + time.toString() + " = " + time.getInMinutes() + " perc");

        System.out.println("A második időpont: " + anotherTime.toString() + " = " + anotherTime.getInSeconds() + " másodperc");

        System.out.println("Az első korábbi, mint a második: " + time.earlierThan(anotherTime));



    }
}
