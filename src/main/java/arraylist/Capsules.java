package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {
    private List <String> colors = new ArrayList<>();

    public void addLast(String color) {
        colors.add(color);
    }

    public void addFirst(String color) {
        colors.add(0, color);
    }

    public void removeFirst(String color) {
        colors.remove(0);
    }

    public void removeLast(String color) {
        int last = colors.size();
        colors.remove(last);
    }

    public List<String> getColors() {
        return colors;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.colors.add("green");
        capsules.colors.add("red");
        capsules.colors.add("purple");
        capsules.addLast("pink");
        capsules.addFirst("magenta");

        System.out.println(capsules.colors);
        System.out.println(capsules.getColors());


    }




}
