package collectionsqueue.collectionspriorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> jobQueue = new PriorityQueue<>();
        for (Job job: jobs) {
            jobQueue.offer(job);
        }
        return jobQueue;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        Job mostImportant;
        if ((mostImportant = jobs.poll()) == null) {
            throw new NoJobException("No job available, get a rest!");
        }
        return mostImportant;
    }
}
