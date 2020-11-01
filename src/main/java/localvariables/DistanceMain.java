package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(2.4, true);
        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        var km = distance.getDistanceInKm();
        var holeKm = (int) km;
        System.out.println(holeKm);

    }
}
