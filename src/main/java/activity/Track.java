package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
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
        return (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude()) *
                (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());

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


    public void loadFromGpx(InputStream inputStream) {
        double latitude = 0.0;
        double longitude = 0.0;
        double elevation = 0.0;
        boolean foundCoordinate = false;
        boolean foundElevation = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("<trkpt ")) {
                    latitude = Double.parseDouble(line.substring(15,25));
                    longitude = Double.parseDouble(line.substring(32,42));
                    foundCoordinate = true;
                }
                if (line.trim().startsWith("<ele")) {
                    elevation = Double.parseDouble(line.substring(9,14));
                    foundElevation = true;
                }
                if (foundCoordinate && foundElevation) {
                    trackPoints.add(new TrackPoint(new Coordinate(latitude, longitude), elevation));
                    latitude = 0.0;
                    longitude = 0.0;
                    elevation = 0.0;
                    foundCoordinate = false;
                    foundElevation = false;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        catch (NullPointerException npe) {
            throw new IllegalArgumentException("Wrong argument", npe);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wrong argument", nfe);
        }

    }

//    Írj egy loadFromGpx() metódust is, mely egy szabványos GPX fájlt tölt be!
//    Itt azt figyeld, hogy a sor a <trkpt és <ele szöveggel kezdődik-e!
//    Itt beégetheted, hogy a számok hanyadik karaktertől hanyadik karakterig tartanak.
//    Egy Coordinate példányt hozz létre, ha belefutsz a <trkpt sorba!
//    Egy TrackPoint példányt hozz létre, ha belefutsz a <ele sorba, és add hozzá a listához!
//    Egy példa állományt az src/test/resources könyvtárban találsz.


}
