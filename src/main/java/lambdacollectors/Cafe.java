package lambdacollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return new ArrayList<>(coffeeOrders);
    }

    public void add(CoffeeOrder coffeeOrder) {
        coffeeOrders.add(coffeeOrder);
    }

//    private List<Coffee> combineCoffeeLists() {
//        List<Coffee> coffeeListSum = new ArrayList<>();
//        for (CoffeeOrder coffeeOrder: coffeeOrders){
//            coffeeListSum.addAll(coffeeOrder.getCoffeeList());
//        }
//        return coffeeListSum;
//    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
//        return combineCoffeeLists().stream()
//                .collect(Collectors.groupingBy(Coffee::getType, Collectors.counting()));
        return coffeeOrders.stream()
                .flatMap(a -> a.getCoffeeList().stream()).collect(Collectors.groupingBy(Coffee::getType, Collectors.counting()));
    }

    public double getAverageOrder() {
        return coffeeOrders.stream()
                .collect(Collectors.summarizingInt(a -> a.getCoffeeList().size())).getAverage();
    }
}
