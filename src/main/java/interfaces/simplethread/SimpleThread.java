package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable{

    @Override
    public void run() {
        while (nextStep()) {
            nextStep();
        }
    }

    private List<String> tasks;

    public List<String> getTasks() {
        return tasks;
    }

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private boolean nextStep() {
        if (tasks != null && !tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        } else {
            return false;
        }
    }
}
