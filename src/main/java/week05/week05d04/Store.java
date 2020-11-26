package week05.week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        for (Product pr: products) {
            if (product.getName().equals(pr.getName())){
                return false;
            }
        }
        if (product.getExpiringDate().isBefore(LocalDate.now())) {
            return false;
        }
        products.add(product);
        return true;
    }

    public int getNumberOfExpired() {
        int counter = 0;
        for (Product product : products) {
            if (product.getExpiringDate().isBefore(LocalDate.now())) {
                counter++;
            }
        }
        return counter;
    }
}
