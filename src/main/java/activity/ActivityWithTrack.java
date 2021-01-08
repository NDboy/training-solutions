package activity;

public class ActivityWithTrack implements Activity{
    private ActivityType activityType;
    private Track track;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.activityType = activityType;
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
