package classsctructureconstructors;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Store store1 = new Store("TV");
        store1.store(20);
        System.out.println(store1.getProduct() +" kezdő készlet: "+ store1.getStock());

        Store store2 = new Store("Rádió");
        store2.store(20);
        System.out.println(store2.getProduct() +" kezdő készlet: "+ store2.getStock());

        store1.store(10);
        store1.dispatch(15);
        store2.store(17);
        store2.dispatch(1);

        System.out.println("TV készlet jelenleg: " + store1.getStock());
        System.out.println("Rádió készlet jelenleg: " + store2.getStock());

    }
}
