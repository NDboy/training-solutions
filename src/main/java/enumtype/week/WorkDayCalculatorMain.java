package enumtype.week;


public class WorkDayCalculatorMain {
    public static void main(String[] args) {
        WorkdayCalculator workdayCalculator = new WorkdayCalculator();
        System.out.println(workdayCalculator.dayTypes(Day.TUESDAY, 12));
    }
}
