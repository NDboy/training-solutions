package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Student(String name) {
        this.marks = marks;
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;

    }


    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        int sum = 0;
        for (Mark mark: marks) {
            sum += mark.getMarkType().getValue();
        }
        return  (int) (((double) sum / marks.size())*100)/ (double) 100;
    }

    public double calculateSubjectAverage(Subject subject) {
        if (!marks.isEmpty()) {
            double sum = 0.0;
            int count = 0;
            for (Mark mark : marks) {
                if (mark.getSubject().equals(subject)) {
                    sum += mark.getMarkType().getValue();
                    count++;
                }
            }
            if (sum == 0) {
                return 0.0;
            } else {
                return (double) sum / count;
            }
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return name + " marks: " + getMarks();
    }






}
