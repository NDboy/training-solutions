package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        for (Pet p : pets) {
            if (areEquals(p,pet)) {
                return;
            }
        }
        pets.add(pet);
    }


    private boolean areEquals(Pet p1, Pet p2) {
        return p1.getRegNumber().equals(p2.getRegNumber());
    }
}
