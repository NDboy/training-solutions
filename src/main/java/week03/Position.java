package week03;

import java.util.ArrayList;
import java.util.Arrays;
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
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {

        List<Position> employees = new ArrayList<>();
        employees.add(new Position("Jack", 200000));
        employees.add(new Position("Joe", 300000));
        employees.add(new Position("John", 400000));

        for (Position a: employees) {
            if (a.getBonus() > 350000) {
                System.out.println(a);
            }

        }


    }





}
