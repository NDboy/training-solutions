package meetingroom;

// ebben az osztályban többféle metódus típust ki akartam próbálni, működik!!!!

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms;

    public Office(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {meetingRooms.add(meetingRoom);}


    public List<String> printNames() {
        List<String> names = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRooms) {
            names.add(meetingRoom.getName());
        }
        return names;
    }


    public List<String> printNamesReverse() {
        List<String> names = new ArrayList<>();
        for (int i = meetingRooms.size()-1; i >= 0; i--) {
            names.add(meetingRooms.get(i).getName());
        }
        return names;
    }


    public List<String> printEventNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < meetingRooms.size(); i = i +2) {
            names.add(meetingRooms.get(i).getName());
        }
        return names;
    }


    public String printAreas() {
        List area = new ArrayList<>();
        for (int i = 0; i < meetingRooms.size(); i++) {
            area.add(meetingRooms.get(i).getName());
            area.add(meetingRooms.get(i).getWidth());
            area.add(meetingRooms.get(i).getLength());
            area.add(meetingRooms.get(i).getArea());
        }
        return area.toString();
    }

    public void printMeetingRoomsWithName(String name) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getName().equals(name)) {
                System.out.println("A tárgyaló szélessége (m): " + meetingRooms.get(i).getWidth());
                System.out.println("A tárgyaló hosszúsága (m): " + meetingRooms.get(i).getLength());
                System.out.println("A tárgyaló területe (m2): " + meetingRooms.get(i).getArea());

            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getName().indexOf(part) > -1) {
                System.out.println("A tárgyaló neve: " + meetingRooms.get(i).getName()); /*ez a sor nem volt benne a feladatban, de így életszerűbb!*/
                System.out.println("A tárgyaló szélessége (m): " + meetingRooms.get(i).getWidth());
                System.out.println("A tárgyaló hosszúsága (m): " + meetingRooms.get(i).getLength());
                System.out.println("A tárgyaló területe (m2): " + meetingRooms.get(i).getArea());

            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getArea() >=/*a feladatban > volt, de sztem így életszerűbb*/ area) {
                System.out.println("A tárgyaló neve: " + meetingRooms.get(i).getName());
                System.out.println("A tárgyaló szélessége (m): " + meetingRooms.get(i).getWidth());
                System.out.println("A tárgyaló hosszúsága (m): " + meetingRooms.get(i).getLength());
                System.out.println("A tárgyaló területe (m2): " + meetingRooms.get(i).getArea());
            }
        }
    }
}
