package controlselection.month;


public class DayInMonth {
    private int year;
    private String month;


    public DayInMonth(/*int year, String month*/) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }


    public int getDayInMonth(int year, String month) {
        month = month.toLowerCase();
        int numberOfDays;
        switch (month) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                numberOfDays = 31;
                break;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                numberOfDays = 30;
                break;
            case "február":
                numberOfDays = (year % 4 == 0) && (year % 400 == 0) ? 29 : 28;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return numberOfDays;
    }

    public static void main(String[] args) {
        System.out.println(new DayInMonth().getDayInMonth(2000, "feBRuár"));

    }
}
