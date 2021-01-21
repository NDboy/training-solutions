package collectionsqueue.collectionsdeque;

import collectionsqueue.collectionspriorityqueue.Job;
import collectionsqueue.collectionspriorityqueue.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobDeque = new ArrayDeque<>();
        for (Job job: jobs) {
            if (job.isUrgent()) {
                jobDeque.addFirst(job);
            } else {
                jobDeque.addLast(job);
            }
        }
        return jobDeque;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) {
        Job firstJob;
        if ((firstJob = jobs.pollFirst()) == null) {
            throw new NoJobException("No job available, get a rest!");
        }
        return firstJob;
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) {
        Job lastJob;
        if ((lastJob = jobs.pollLast()) == null) {
            throw new NoJobException("No job available, get a rest!");
        }
        return lastJob;
    }
}
