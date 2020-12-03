package week06.week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget{
    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    private boolean isValidMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }


    public List<Item> getItemsByMonth(int month) {
        if(!isValidMonth(month)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getMonth() == month) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

}



//    Készíts az week06d04 csomagban egy Budget osztályt,
//    amely a konstruktorában Item példányokat vár listában (List).
//    Az Item tartalmazza az alábbi attribútumokat: int price, int month, String name.
//    A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát.
//    Írjunk egy metódust, getItemsByMonth néven, mely egy hónapot vár (1-12) és visszaadja
//    az Itemeket az adott hónapban! Bónusz feladat: ellenőrizzük a bemeneti paramétereket és írjunk tesztet!
