package typeconversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle circle = new Circle();
        List<Circle> diameters = new ArrayList<>();
        System.out.println("Adja meg az 1. kör átmérőjét!");
        double diamet = scanner.nextInt();
        scanner.nextLine();
        circle.setDiameter((int) diamet);

        System.out.println("Adja meg az 2. kör átmérőjét!");
        double diamet2 = scanner.nextInt();
        scanner.nextLine();
        circle.setDiameter((int) diamet2);

        System.out.println(circle.perimeter());
        System.out.println(circle.area());


    }
}
