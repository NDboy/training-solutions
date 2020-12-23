package week09.week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> personList = new ArrayList<>();

    public SantaClaus(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void getThroughChimneys() {
        for (Person person: personList) {
            person.setPresent(5);
        }
    }

    @Override
    public String toString() {
        return "personList: " + personList;
    }
}

