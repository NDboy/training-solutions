package Introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        String menu = scanner.nextLine();

        if (menu.equals("1")) {
            System.out.println("Felhasználók listázása");
        } else if (menu.equals("2")) {
            System.out.println("Felhasználó felvétele");
        } else {
            System.out.println("");
        }
    }
}
