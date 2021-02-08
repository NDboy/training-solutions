package week15.week15d01;

public class Result {
    private double key;
    private double value;

    public Result(double key, double value) {
        this.key = key;
        this.value = value;
    }

    public double getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "key: " + key + " , value: " + value;
    }
}
