package ioprintwriter.talentshow;

public class Production {
    private int number;
    private String name;

    public Production(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getId() {
        return number;
    }

    public String getName() {
        return name;
    }
}
