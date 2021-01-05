package week10.week10d02;

import java.util.List;

public class MaxTravel2 {

    public int getMaxIndex(List<Integer> passengers) {
        int[] passengersSum = new int[30];
        int maxIndex = 0;
        int maxValue = 0;
//        for (int i = 0; i < passengers.size(); i++) {
//            passengersSum[passengers.get(i)] ++;
//        }
        for (int item : passengers) {
            passengersSum[item] ++;
        }
        for (int i = 0; i < passengersSum.length; i++) {
            if(passengersSum[i] > maxValue) {
                maxValue = passengersSum[i];
                maxIndex = i;
            }
        }
        return maxIndex;

    }
}
