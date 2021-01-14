package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }


    private double distanceByOneType(ActivityType activityType) {
        double distance = 0.0;
        for (Activity activity : activities) {
            if (activity.getType() == activityType) {
                distance += activity.getDistance();
            }
        }
        return distance;
    }


    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < ActivityType.values().length; i++) {

            double distance = distanceByOneType(ActivityType.values()[i]);
            reports.add(new Report(ActivityType.values()[i], distance));
        }
        return reports;
    }


    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                counter++;
            }
        }
        return counter;
    }


    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                counter++;
            }
        }
        return counter;
    }
}
