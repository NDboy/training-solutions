package introconstructors;

public class TaskMain {
    public static void main(String[] args) {
        Task task = new Task("bevásárlás", "Auchan, Lidl, zöldséges");
        task.start();
        task.setDuration(90);
        System.out.println(task.getStartDateTime());
        System.out.println(task);

    }
}
