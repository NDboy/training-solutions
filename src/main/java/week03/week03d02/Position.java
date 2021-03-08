package week03.week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return name + " " +  bonus;
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();

        positions.add(new Position("employee1", 100_000));
        positions.add(new Position("employee2", 150_000));
        positions.add(new Position("employee3", 200_000));
        positions.add(new Position("employee4", 250_000));

        for (Position position: positions) {
            if (position.getBonus() > 150_000) System.out.println(position);
        }
    }
}
