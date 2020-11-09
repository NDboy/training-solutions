package enumtype.week;

public class WorkDayCalculatorMain {
    public static void main(String[] args) {
        WorkDayCalculator workDayCalculator = new WorkDayCalculator();

        System.out.println(workDayCalculator.dayTypes(Day.TUESDAY, 3));
    }
}
