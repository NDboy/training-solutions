package week13.week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LessonManager {

    private List<Lesson> lessons = new ArrayList<>();

    public void lessonLoader() {
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of("beosztas.txt")))){
            String line;
            String teacher = null;
            String subject = null;
            String className = null;
            int amount;
            int counter = 0;

            while ((line = reader.readLine()) != null) {
                counter++;
                if (counter % 4 == 1) {
                    teacher = line;
                } else if (counter % 4 == 2) {
                    subject = line;
                } else if (counter % 4 == 3) {
                    className = line;
                }else if (counter % 4 == 0) {
                    amount = Integer.parseInt(line);
                    lessons.add(new Lesson(teacher, subject, className, amount));
                }
            }
            System.out.println(lessons.size());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int sumLessonsByTeacher(String teacher) {
        int sum = 0;
        for (Lesson lesson: lessons) {
            if(lesson.getTeacher().equals(teacher)) {
                sum += lesson.getAmount();
            }
        }
        return sum;
    }

}





//    Adott a következő szerkezetű fájl, beosztas.txt:
//        Albatrosz Aladin
//        biologia
//        9.a
//        2
//        Albatrosz Aladin
//        osztalyfonoki
//        9.a
//        1
//        Csincsilla Csilla
//        matematika
//        9.b
//        2
//        A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg.
//        Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
//        Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten. (edited)
