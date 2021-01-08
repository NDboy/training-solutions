package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint point) {
        trackPoints.add(point);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = 0.0;
        double maxLong = 0.0;
        for (TrackPoint point : trackPoints) {
            maxLat = Math.max(maxLat, point.getCoordinate().getLatitude());
            maxLong = Math.max(maxLong, point.getCoordinate().getLongitude());
        }
        return new Coordinate(maxLat, maxLong);
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = 0.0;
        double minLong = 0.0;
        for (TrackPoint point : trackPoints) {
             minLat= Math.min(minLat, point.getCoordinate().getLatitude());
            minLong = Math.min(minLong, point.getCoordinate().getLongitude());
        }
        return new Coordinate(minLat, minLong);
    }

    public double getDistance() {
        double distanceSum = 0.0;
        TrackPoint buffer = trackPoints.get(0);
        for (TrackPoint point: trackPoints) {
            distanceSum += buffer.getDistanceFrom(point);
            buffer = point;
        }
        return distanceSum;
    }


    public double getFullDecrease() {
        double decreaseSum = 0.0;
        double elevationBuffer = trackPoints.get(0).getElevation();
        for (TrackPoint point : trackPoints) {
            if (point.getElevation() < elevationBuffer) {
                decreaseSum += elevationBuffer - point.getElevation();
            }
            elevationBuffer = point.getElevation();
        }
        return decreaseSum;
    }

    public double getRectangleAreaTheReal() {
        final double ZERO_ELEVATION = 0.0;

        double aSide = new TrackPoint(new Coordinate(findMinimumCoordinate().getLatitude(), findMaximumCoordinate().getLongitude()), ZERO_ELEVATION)
                .getDistanceFrom(new TrackPoint(findMinimumCoordinate(), ZERO_ELEVATION));

        double bSide = new TrackPoint(new Coordinate(findMinimumCoordinate().getLatitude(), findMaximumCoordinate().getLongitude()), ZERO_ELEVATION)
                .getDistanceFrom(new TrackPoint(findMaximumCoordinate(), ZERO_ELEVATION));

        return aSide * bSide;
    }

    public double getRectangleArea() {
        return (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude()) * (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());

    }

    public double getFullElevation() {
        double elevationSum = 0.0;
        double elevationBuffer = trackPoints.get(0).getElevation();
        for (TrackPoint point : trackPoints) {
            if (point.getElevation() > elevationBuffer) {
                elevationSum += point.getElevation() - elevationBuffer;
            }
            elevationBuffer = point.getElevation();
        }
        return elevationSum;
    }
}
