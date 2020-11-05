package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator circleCalculator = new CircleCalculator();
        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println(circleCalculator.calculatePerimeter(3.5));
        System.out.println(circleCalculator.calculateArea(3.5));
        System.out.println(cylinderCalculator.calculateVolume(3.5, 2));
        System.out.println(cylinderCalculator.calculateSurfaceArea(3.5, 2));
        System.out.println(circleCalculator.PI);
    }
}
