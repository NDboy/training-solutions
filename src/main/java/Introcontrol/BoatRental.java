package Introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Az érkező csapat létszáma?");
        int number = scanner.nextInt();

        if (0 < number && number < 3) {
            System.out.println("A kétszemélyes csónakot elvitték, még 8 hely maradt.");
        } else if (number == 3) {
            System.out.println("A háromszemélyes csónakot elvitték, még 7 hely maradt.");
        } else if (3 < number && number < 6) {
            System.out.println("Az ötszemélyes csónakot elvitték, még 5 hely maradt.");
        } else if (5 < number && number < 8) {
            System.out.println("Az ötszemélyes és a kétszemélyes csónakot elvitték, még 3 hely maradt.");
        } else if (number == 8) {
            System.out.println("Az ötszemélyes és a háromszemélyes csónakot elvitték, még 2 hely maradt.");
        } else if (8 < number && number <=10) {
            System.out.println("Az összes csónakot elvitték, nem maradt több hely.");
        } else {
            System.out.println("Az összes csónakot elvitték, és " + (number - 10) + "fő maradt a parton.");
        }
    }
}
