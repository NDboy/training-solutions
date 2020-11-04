package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString () {
        int days [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,};
        return Arrays.toString(days);
    }

    public List<String> daysOfWeek () {
        return Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap");
    }

    public String multiplicationTableAsString(int size) {
        int [] [] multiplicator = new int [size] [size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicator [i] [j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicator);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] numbers1, int[] numbers2) {

        int[] n1 = Arrays.copyOf(numbers1, numbers1.length);
        int[] n2 = Arrays.copyOf(numbers2, numbers2.length);

        return Arrays.equals(n1, n2);

    }




    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.daysOfWeek());
        System.out.println(arraysMain.multiplicationTableAsString(3));
        double[] day = {1, 2, 3, 4};
        double[] anotherDay = {1, 2, 3, 4, 5};
        System.out.println(arraysMain.sameTempValues(day,anotherDay));
        int[] numbers1 = {23, 32, 45, 54};
        int[] numbers2 = {23, 45, 32, 54};
        System.out.println(arraysMain.wonLottery(numbers1, numbers2));
        System.out.println(Arrays.toString(numbers2));
    }
}
