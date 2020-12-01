package methodpass.trooper;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Invalid argument");
        }
        troopers.add(trooper);
    }

    public boolean isEmpty(String a) {
        return a == null || a.isBlank();
    }

    private Trooper findTrooperByName(String name) {
        Trooper tr = null;
        for (Trooper trooper : troopers) {
            if (name.equals(trooper.getName())) {
                tr = trooper;
            }
        }
        return tr;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper troop = null;
        double dist = 0.0;
        for (Trooper trooper : troopers) {
            if (dist == 0.0 || trooper.distanceFrom(target) < dist) {
                dist = trooper.distanceFrom(target);
                troop = trooper;
            }
        }
        return troop;
    }


    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }


    public void moveTrooperByName(String name, Position target) {
        if (isEmpty(name) || target == null) {
            throw new IllegalArgumentException("Invalid argument");
        }
        moveTrooper(findTrooperByName(name), target);
    }


    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Invalid argument");
        }
        moveTrooper(findClosestTrooper(target), target);
    }
}
