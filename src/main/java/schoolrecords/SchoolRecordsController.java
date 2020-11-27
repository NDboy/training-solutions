package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    private ClassRecords classRecords;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public SchoolRecordsController(String className) {
        this.classRecords = new ClassRecords(className, new Random());
        this.subjects = subjects;
        this.tutors = tutors;
    }

    public boolean initSchool(Subject subject) {
        for (Subject subject1: subjects) {
            if (subject1.getSubjectName().equals(subject.getSubjectName())) {
                return false;
            }
        }
        subjects.add(subject);
        return true;
    }

     public boolean initSchool(Tutor tutor) {
        for (Tutor tutor1: tutors) {
            if (tutor1.getName().equals(tutor.getName())) {
                return false;
            }
        }
        tutors.add(tutor);
        return true;
    }

    public Tutor findTutorByName(String str) {
        Tutor foundTutor = null;
        for (Tutor tutor: tutors) {
            if (str.equals(tutor.getName())) {
                foundTutor = tutor;
            }
        }
        return foundTutor;
    }

    public Subject findSubjectByName(String str) {
        Subject foundSubject = null;
        for (Subject subject: subjects) {
            if (str.equals(subject.getSubjectName())) {
                foundSubject = subject;
            }
        }
        return foundSubject;
    }

    public MarkType findMarkType(int num) {
        MarkType foundMark = null;
        for (MarkType markType: MarkType.values()) {
            if (num == markType.getValue()) {
                foundMark = markType;
            }
        }
        return foundMark;
    }




    public static void main(String[] args) {
        ClassRecords classRecords = new ClassRecords("First class", new Random());
        SchoolRecordsController src = new SchoolRecordsController("First class");
        src.initSchool(new Subject("Történelem"));
        src.initSchool(new Subject("Matematika"));
        src.initSchool(new Subject("Fizika"));
        src.initSchool(new Tutor("Kovács Ferenc", new ArrayList<>()));
        src.initSchool(new Tutor("Vargáné Aranka", new ArrayList<>()));



        Tutor tutor = new Tutor("Nagy Csilla",
                Arrays.asList(new Subject("Földrajz"),
                        new Subject("Matematika"),
                        new Subject("Biológia"),
                        new Subject("Zene"),
                        new Subject("Fizika"),
                        new Subject("Kémia")));

        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, new Subject("Földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("Matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.D, new Subject("Földrajz"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("Biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("Matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("Zene"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("Fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("Kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("Földrajz"), tutor));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);






        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("\n\n1. Diákok nevének listázása\n" +
                    "2. Diák név alapján keresése\n" +
                    "3. Diák létrehozása\n" +
                    "4. Diák név alapján törlése\n" +
                    "5. Diák feleltetése\n" +
                    "6. Osztályátlag kiszámolása\n" +
                    "7. Tantárgyi átlag kiszámolása\n" +
                    "8. Diákok átlagának megjelenítése\n" +
                    "9. Diák átlagának kiírása\n" +
                    "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                    "11. Kilépés");

            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu == 1) {
                System.out.println(classRecords.listStudentNames());
            } else if (menu == 2) {
                System.out.println("Adja meg a diák nevét!");
                String studentName = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(studentName));
            } else if (menu == 3) {
                System.out.println("Adja meg a diák nevét!");
                String studentName = scanner.nextLine();
                classRecords.addStudent(new Student(studentName));
            } else if (menu == 4) {
                System.out.println("Adja meg a törölni kívánt diák nevét!");
                String studentName = scanner.nextLine();
                classRecords.removeStudent(classRecords.findStudentByName(studentName));
            } else if (menu == 5) {
                Student student = classRecords.repetition();
                System.out.println("Adja meg az érdemjegyet!");
                int markType = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Adja meg a tantárgy nevét!");
                String subject = scanner.nextLine();
                System.out.println("Adja meg az oktató nevét!");
                String tutor1 = scanner.nextLine();
                student.grading(new Mark(src.findMarkType(markType), src.findSubjectByName(subject), src.findTutorByName(tutor1)));
            } else if (menu == 6) {
                System.out.println(classRecords.calculateClassAverage());
            } else if (menu == 7) {
                System.out.println("Adja meg a tantárgy nevét!");
                String subject = scanner.nextLine();
                System.out.println(classRecords.calculateClassAverageBySubject(src.findSubjectByName(subject)));
            } else if (menu == 8) {
                System.out.println(classRecords.listStudyResults());
            } else if (menu == 9) {
                System.out.println("Adja meg a diák nevét!");
                String studentName = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(studentName).calculateAverage());
            } else if (menu == 10) {
                System.out.println("Adja meg a diák nevét!");
                String studentName = scanner.nextLine();
                System.out.println("Adja meg a tantárgy nevét!");
                String subject = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(studentName).calculateSubjectAverage(src.findSubjectByName(subject)));
            }
        } while (menu < 11);
        System.out.println("Vége a mókának!");
    }
}
