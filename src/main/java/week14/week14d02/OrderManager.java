package week14.week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {

    private final Map<String, List<String>> orders = new TreeMap<>();

    public Map<String, List<String>> getOrders() {
        return new TreeMap<>(orders);
    }

    public void loadFileToMap(String pathString) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(pathString))){
            String line;
            while ((line = br.readLine()) != null) {
                putOrderToMap(line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
    }


    private void putOrderToMap(String line) {
        String regNumberKey = line.split(" ")[0];
        String listString = line.split(" ")[1];
        List<String> products = Arrays.asList(listString.split(","));
        orders.put(regNumberKey, products);
    }


    public List<String> findSortedProductListByRegNumber(String regNumber) {
        List<String> products = new ArrayList<>(orders.get(regNumber));
        products.sort(Comparator.naturalOrder());
        return products;
    }


    public int countSoldProductByName(String product) {
        return (int) (combineValueLists().stream().filter(i -> i.equals(product)).count());
    }


    private List<String> combineValueLists() {
        List<String> productsSum = new ArrayList<>();
        for (List<String> productList : orders.values()){
            productsSum.addAll(productList);
        }
        return productsSum;
    }


    public int countProductsInOrder(String regNumber) {
        return orders.get(regNumber).size();
    }


    public Map<String, Long> makeStatisticsInMap() {
//        Map<String, Integer> statistics = new TreeMap<>();
//        for (String product : combineValueLists()) {
//            if (!statistics.containsKey(product)) {
//                statistics.put(product, 1);
//            } else {
//                int newCount = statistics.get(product);
//                statistics.put(product, newCount + 1);
//            }
//        }
        return combineValueLists().stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));

    }


}

//    Mai Junior/Mid-level feladat:
//        Adott egy fájl melyben online bevásárlások találhatók. A fájl a még ki nem szállított rendeléseket tartalmazza.
//        Egy sorban egy egyedi azonosító és utána a termékek neve van felsorololva. Minden vásárlás legalább 2 termékből áll.
//        ```
//        A233 bread,tomato,flour,sugar
//        A312 sugar,beer,apple,pear
//        B3402 meet,soda,cola,bbq_sauce
//        B341 pasta,passata,basil,cheese
//        A10 corn,hot_dog,rolls
//        CM231 beer,chips
//        C123 pepper,salt,rosmary,pizza_dough,passata,oregano
//        W34111 pasta,sugar,rosmary,cheese,meet,carrot,potato,tomato
//        K8921 wine,soda
//        ```
//        Olvasd be a fájlt és tárold el az adatokat a memóriában, majd oldd meg a következő feladatokat.
//        1. Egyedi azonosító alapján legyenek lekérdezhetőek a vásárolt termékek ABC sorrendben.
//        2. Számoljuk össze, egy termék neve alapján, hogy abból a termékből mennyit adtak el.
//        3. Adjuk vissza egy vásárlási azonosító alapján, hogy hány termék szerepel a vásárlásban.
//        4. Készíts statisztikát melyben visszaadod, hogy az egyes termékek hányszor szerepelnek a fájlban.

