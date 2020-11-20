package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        boolean b = false;
        for (Subject subject1 : taughtSubjects) {
            if (subject1.getSubjectName().equals(subject.getSubjectName())) {
                b = true;
            }
        }
        return b;
    }
}
