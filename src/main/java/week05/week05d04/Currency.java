package week05.week05d04;

public enum Currency {
    HUF(1.0), USD(300.0);
    private double value;

    Currency(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
