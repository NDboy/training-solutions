package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        int j = 0;
        for (int i = 0; i < items.size(); i++) {
            if (barcode.equals(items.get(i).getBarcode())) {
                j = i;
            }
        }
        items.remove(j);
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }


}
