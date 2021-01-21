package collectionsqueue.collectionspriorityqueue;

import org.jetbrains.annotations.NotNull;

public class Job implements Comparable{
    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        this.urgent = priority < 5;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Job job = (Job) o;
        if (priority > ((Job) o).priority) {
            return 1;
        } else if (priority == ((Job) o).priority) {
            return 0;
        } else {
            return -1;
        }
    }
}
