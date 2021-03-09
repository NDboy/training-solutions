package week06.week06d01;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SeparatedSum {

    public static MinusPlus sum(String str) {
        Map<Boolean, Double> resultMap = Arrays.stream(str.split(";"))
                .map(a -> Double.parseDouble(a.replace(",", "."))).collect(Collectors.partitioningBy(a -> a < 0.0, Collectors.summingDouble(Double::doubleValue)));
        return new MinusPlus(resultMap.get(true), resultMap.get(false));
    }



    public static void main(String[] args) {
        System.out.println(sum("121,212;145,4;45,154;-44,01"));
    }
}
