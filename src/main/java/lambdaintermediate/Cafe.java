package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }


    public BigDecimal getTotalIncome() {
        return coffeeOrders.stream().
                flatMap(l -> l.getCoffeeList().stream()).reduce(BigDecimal.valueOf(0), (i, a) -> i.add(a.getPrice()), (i1, i2) -> i1.add(i2))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate localDate) {
        return coffeeOrders.stream().filter(a -> (a.getDateTime().toLocalDate().equals(localDate))).
                flatMap(l -> l.getCoffeeList().stream()).reduce(BigDecimal.valueOf(0), (i, a) -> i.add(a.getPrice()), (i1, i2) -> i1.add(i2))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType coffeeType) {
        return coffeeOrders.stream().flatMap(l -> l.getCoffeeList().stream()).filter(a -> a.getCoffeeType() == coffeeType)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime dateTime) {
        return coffeeOrders.stream().filter(a -> a.getDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate localDate) {
        return coffeeOrders.stream().filter(a -> a.getDateTime().toLocalDate().equals(localDate))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime)).limit(5).collect(Collectors.toList());
    }
}
