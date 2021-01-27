package week13.week13d03;

public class Lesson {

    private String teacher;
    private String subject;
    private String className;
    private int amount;

    public Lesson(String teacher, String subject, String className, int amount) {
        this.teacher = teacher;
        this.subject = subject;
        this.className = className;
        this.amount = amount;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassName() {
        return className;
    }

    public int getAmount() {
        return amount;
    }
}
