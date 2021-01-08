package activity;

public class TrackPoint {

    private Coordinate coordinate;
    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint point) {
        final int R = 6371;

        double latDistance = Math.toRadians(this.getCoordinate().getLatitude() - point.getCoordinate().getLatitude());
        double lonDistance = Math.toRadians(this.getCoordinate().getLongitude() - point.getCoordinate().getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(point.getCoordinate().getLatitude())) * Math.cos(Math.toRadians(this.getCoordinate().getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;

        double height = this.getElevation() - point.getElevation();

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }



}
