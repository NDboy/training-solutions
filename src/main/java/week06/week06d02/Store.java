package week06.week06d02;

import java.util.List;

public class Store {
    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getProductByCategoryName(Category category) {
        int counter = 0;
        for (Product product: products) {
            if (product.getCategory() == category) {
                counter++;
            }
        }
        return counter;
    }

    public int getProductByCategoryNameWithStream(Category category) {
        return (int)products.stream()
                .filter(a -> a.getCategory() == category)
                .count();
    }
}
