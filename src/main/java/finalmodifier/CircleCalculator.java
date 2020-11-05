package finalmodifier;

public class CircleCalculator {
    public static final double PI = 3.14;
    private double r;

    public double getR() {
        return r;
    }

    public double calculatePerimeter(double r) {
        return 2 * r * PI;
    }

    public double calculateArea(double r) {
        return r * r * PI;
    }

}
