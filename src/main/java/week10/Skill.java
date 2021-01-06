package week10;

public class Skill {
    public String name;
    public int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return name + " (" + level + ")";
    }
}
