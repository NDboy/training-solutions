package week09.week09d03;

import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;
    private final static int MIN_AGE = 14;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent(int seed) {
        Random rnd = new Random(seed);
        int presentValue = 0;
        if (getAge() >= MIN_AGE) {
            presentValue = rnd.nextInt(3) + 1;
        } else {
            presentValue = rnd.nextInt(4);
        }
        present = Present.of(presentValue);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
