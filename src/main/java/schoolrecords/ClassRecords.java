package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = new Random(5);
        if (students == null) {
            throw new IllegalStateException("No students to search");
        }
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
         for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public double calculateClassAverage() {
        double sum = 0;
        for (Student studentMark: students) {
            sum += studentMark.calculateAverage();
        }
        return  (int) (((double) sum / students.size())*100)/ (double) 100;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0.0;
        double sumsum = 0.0;
        int count = 0;
        double tempAverage = 0;
        int count2 = 0;
        for (Student student: students) {
            for (Mark mark: student.getMarks()) {
                if (mark.getSubject().getSubjectName() == subject.getSubjectName()) {
                    sum += mark.getMarkType().getValue();
                    count ++;
                    tempAverage = sum / count;
                }
            }
            if (sum > 0) {count2++;}
            sum = 0.0;
            count = 0;
            sumsum += tempAverage;
            tempAverage = 0.0;
        }
        if (sumsum == 0) {
            return 0.0;
        } else {
            return  (int) ((sumsum / count2)*100)/ (double) 100;
        }
    }

    public Student findStudentByName (String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        Student foundStudent = null;

        for (Student student: students){
            if (student.getName().contains(name)) {foundStudent = student;}
        }
//        if (foundStudent == null) {throw new IllegalStateException("Student by this name cannot be found! " + name);}

        return foundStudent;
    }

    public String listStudentNames() {
        List<String> studentsList = new ArrayList<>();
        for (Student student:students) {
            studentsList.add(student.getName());
        }
//        return String.format("%s, %s, %s", studentsList.get(0), studentsList.get(1), studentsList.get(2));
        return studentsList.toString().substring(1, studentsList.toString().length()-1);
    }

    public List<StudyResultByName> listStudyResults () {
        List<StudyResultByName> studyResults = new ArrayList<>();
        for (Student student:students) {
            studyResults.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResults;
    }

    public Student repetition() {
        return students.get(rnd.nextInt(students.size()));
    }
}
