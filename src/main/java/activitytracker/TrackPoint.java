package activitytracker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrackPoint {
    private long id;
    private long activityId;
    private LocalDateTime time;
    private double lat;
    private double lon;

    public TrackPoint(long id, LocalDateTime time, double lat, double lon) {
        throwExceptionAtInvalidLatLon(lat, lon);
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, long activityId, LocalDateTime time, double lat, double lon) {
        throwExceptionAtInvalidLatLon(lat, lon);
        this.id = id;
        this.activityId = activityId;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(LocalDateTime time, double lat, double lon) {
        throwExceptionAtInvalidLatLon(lat, lon);
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    private void throwExceptionAtInvalidLatLon(double latit, double longi) {
        if (latit < -90 || latit > 90) {
            throw new IllegalArgumentException("Invalid latitude!");
        }
        if (longi < -180 || longi > 180) {
            throw new IllegalArgumentException("Invalid longitude!");
        }
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", activityId= " + activityId +
                ", time= " + time +
                ", lat= " + lat +
                ", lon= " + lon;
    }
}
