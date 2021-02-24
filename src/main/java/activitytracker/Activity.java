package activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType type;

    public Activity(long id, LocalDateTime startTime, String desc, ActivityType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(Activity activity, long id) {
        this.id = id;
        this.startTime = activity.startTime;
        this.desc = activity.desc;
        this.type = activity.type;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + " " + startTime + " " + desc + " " + type;
    }
}
