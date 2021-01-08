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

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        ActivityType activityType = ActivityType.BIKING;
        double distance = 0.0;
        for (int i = 0; i < 4; i++) {
            for (Activity activity: activities) {
                if (activity.getType() == activityType) {
                    distance += activity.getDistance();
                }
            }
            reports.add(new Report(activityType, distance));
            distance = 0.0;
            activityType = activityType.next();
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
