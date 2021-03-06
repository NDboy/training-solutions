package activity;

public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude < -90.0 || latitude > 90.0 || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
