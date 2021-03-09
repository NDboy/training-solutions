package week06.week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ItemSenior> items;

    public ShoppingCart(List<ItemSenior> items) {
        this.items = items;
    }

    public List<ItemSenior> getItems() {
        return items;
    }

    public void addItem(String name, int quantity) {
        ItemSenior is = new ItemSenior(name, quantity);
        if (!items.contains(is)) {
            items.add(is);
        } else {
            int originalItemIndex = items.indexOf(is);
            ItemSenior originalItem = items.get(originalItemIndex);
            items.set(originalItemIndex, new ItemSenior(name, quantity + originalItem.getQuantity()));
        }
    }

    public int getItem(String name) {
        return items.stream()
                .filter(a -> name.equals(a.getName()))
                .findAny()
                .orElse(new ItemSenior(null,0))
                .getQuantity();
    }
}
