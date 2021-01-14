package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void readGradesFromFile(String pathString) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(pathString))){
            String line = null;
            String name = null;
            int gradesLength = 0;
            while ((line = bufferedReader.readLine()) != null) {
                List<Integer> grades = new ArrayList<>();
                name = line.split(" ")[0];
                gradesLength = line.split(" ").length;
                for (int i = 1; i < gradesLength; i++) {
                    grades.add(Integer.parseInt(line.split(" ")[i]));
                }
                students.add(new Student(name, grades));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
    }

    public double classAverage() {
        double sum = 0.0;
        double counter = 0.0;
        for (Student student: students) {
            sum += student.average();
            counter++;
        }
        if (counter == 0.0) {
            return 0.0;
        }
        return sum / counter;
    }

}
