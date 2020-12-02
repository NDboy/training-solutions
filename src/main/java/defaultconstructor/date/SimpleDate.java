package defaultconstructor.date;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isCorrect(int year, int month, int day) {
        return year >= 1900 && month >= 1 && month <= 12 && day >= 1 && day <= calculateMonthLength(year, month);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int calculateMonthLength(int year, int month) {
        int day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                day = 29;
            } else {
                day = 28;
            }
        }
        return day;
    }
}
