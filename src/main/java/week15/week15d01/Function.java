package week15.week15d01;

import java.util.HashMap;
import java.util.Map;

public class Function {

    public Result findMax(Map<Double, Double> numbers) {
        double maxValue = Double.MIN_VALUE;
        Result result = null;
        for (double i : numbers.keySet()) {
            if (maxValue < numbers.get(i)) {
                maxValue = numbers.get(i);
                result = new Result(i, numbers.get(i));
            }
        }
        return result;
    }

}

//    Adott egy függvénygrafikon a koordináta rendszerben.
//    A grafikon néhány pontját megkapjuk egy Map-ben.
//    A map kulcsa az x koordináta értéke pedig az y koordináta.
//    Döntsük el, hogy a kapott pontok küzül,
//    hol van a függvénynek maximum helye és ott mennyi az értéke. (edited)
