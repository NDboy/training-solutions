package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {
    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }


    public int getNumberOfProducts() {
        return products.stream().mapToInt(i -> i.getAmount()).sum();
    }

    public double getAveragePrice() {
        if (products.size() == 0) {
            return 0.0;
        }
        double sum = products.stream().mapToDouble(i -> i.getPrice()).sum();
        return sum / products.size();
    }

    public String getExpensiveProductStatistics(double minPrice) {

            IntSummaryStatistics statistics = products.stream().filter(i -> i.getPrice() >= minPrice).mapToInt(i -> i.getAmount()).summaryStatistics();
            if (statistics.getCount() == 0) {
                return "Nincs ilyen termék.";
            }
            return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                    statistics.getCount(), statistics.getMin(), statistics.getMax(), statistics.getSum());
    }
}
