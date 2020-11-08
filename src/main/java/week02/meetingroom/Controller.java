package week02.meetingroom;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MeetingRoom meetingRoom = new MeetingRoom();
        Office office = new Office(new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hány darab tárgyalót szeretne rögzíteni?");
        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            MeetingRoom meetingRoomVar = new MeetingRoom();
            System.out.println((i + 1) + ". tárgyaló neve?");
            String n = scanner.nextLine();
            meetingRoomVar.setName(n);

            System.out.println((i + 1) + ". tárgyaló szélessége (m)?");
            int w = scanner.nextInt();
            meetingRoomVar.setWidth(w);

            System.out.println((i + 1) + ". tárgyaló hosszúsága (m)?");
            int l = scanner.nextInt();
            scanner.nextLine();
            meetingRoomVar.setLength(l);
            office.addMeetingRoom(meetingRoomVar);
        }

        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafelé sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        System.out.println("Melyik menüpontot választod?");

        int menu = scanner.nextInt();
        if (menu == 1) {
            List<String> names = office.printNames();
            System.out.println(names);
        } else if (menu == 2) {
            List<String> names = office.printNamesReverse();
            System.out.println(names);
        } else if (menu == 3) {
            List<String> names = office.printEventNames();
            System.out.println(names);
        } else if (menu == 4) {
            String area = office.printAreas();/*név+szélesség+hosszúság+terület*/
            System.out.println("A tárgyalók neve, szélessége, hosszúsága és a területe: " + area);
        } else if (menu == 5) {
            scanner.nextLine();
            System.out.println("Melyik tárgyalót keresed?");
            String menu5Name = scanner.nextLine();
            office.printMeetingRoomsWithName(menu5Name);
        } else if (menu == 6) {
            scanner.nextLine();
            System.out.println("Melyik tárgyalót keresed?");
            String menu6Name = scanner.nextLine();
            office.printMeetingRoomsContains(menu6Name);
        } else if (menu == 7) {
            scanner.nextLine();
            System.out.println("Mekkora tárgyalót keresel? (m2)?");
            int menu7Name = scanner.nextInt();
            office.printAreasLargerThan(menu7Name);
        }
    }
}
