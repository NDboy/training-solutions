package finalmodifier;

public class CylinderCalculator {
    private double r;
    private double h;

    public double getR() {
        return r;
    }

    public double calculateVolume(double r, double h) {
        return h * r * r * CircleCalculator.PI;
    }

    public double calculateSurfaceArea(double r, double h) {
        return h * 2 * r * CircleCalculator.PI + 2 * r * r * CircleCalculator.PI;
    }

}
