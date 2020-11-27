package schoolrecords;

public class StudyResultByName {

    private String studentName;
    private double studyAverage;

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }

    public StudyResultByName(String studentName, double studyAverage) {
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudyAverage(double studyAverage) {
        this.studyAverage = studyAverage;
    }

    @Override
    public String toString() {
        return studentName + " átlaga: " + studyAverage;
    }
}
