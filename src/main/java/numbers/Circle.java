package numbers;

public class Circle {
    private  int diameter;
    public static final double PI = 3.14;

    public Circle(/*int diameter*/) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return PI * diameter;
    }

    public double area() {
        return PI * Math.pow(diameter, 2);
    }

}
