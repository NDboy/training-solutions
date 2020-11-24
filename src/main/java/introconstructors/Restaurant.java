package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.fillMenu();
        this.name = name;
        this.capacity = numberOfTables * 4;
    }

    public void fillMenu () {
        menu = Arrays.asList("Hambi", "Kolbi", "Savanyú", "Üccsi");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }


}
