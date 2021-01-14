package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    public double average() {
        double sum = 0.0;
        double counter = 0.0;
        for (Integer grade: gradeList) {
            sum += grade;
            counter++;
        }
        if (counter == 0.0) {
            return 0.0;
        }
        return sum / counter;
    }

    public boolean isIncreasing() {
        int buffer = 0;
        for (Integer grade: gradeList) {
            if (grade >= buffer) {
                buffer = grade;
            } else {
                return false;
            }
        }
        return true;
    }
}
