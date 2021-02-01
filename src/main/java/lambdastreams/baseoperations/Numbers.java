package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Comparator.comparingInt(a -> a));
    }

    public int sum() {
        return numbers.stream().reduce(0, (a, b) -> a + b);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().collect(HashSet::new, Set::add, Set::addAll);

//        return numbers.stream().collect(Collectors.toSet());
//        return new HashSet<>(numbers);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(a -> a >= 0);

    }
}
