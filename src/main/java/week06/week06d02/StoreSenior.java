package week06.week06d02;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreSenior {
    private List<Product> products;

    public StoreSenior(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Map<Category, Long> getProductByCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }
}
