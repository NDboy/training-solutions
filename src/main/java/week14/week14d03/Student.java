package week14.week14d03;

import java.util.*;

public class Student {

    private Map<Subjects, List<Integer>> marks = new TreeMap<>();
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Map<Subjects, List<Integer>> marks) {
        this.marks = marks;
        this.name = name;
    }

    public Map<Subjects, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void putMark(Subjects subject, int mark) {
        if (!marks.containsKey(subject)) {
            marks.put(subject, Arrays.asList(mark));
        } else {
            marks.get(subject).add(mark);
        }
    }




}


//        Készíts egy diák (`Student`) osztályt melyben egy diák jegyeit tárolod egy Map-ben.
//        A map kulcsa a tantárgy, értéke pedig az adott tantárgy jegyeinek listája.
//        Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg.
//        Legyen benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
//        Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található.
//        Készíts egy lekérdező metódust a `ClassNoteBook` osztályban, legyen a neve `sortNotebook`,
//        mely a diákok listáját ABC sorrendben adja vissza.
