package week06.week06d01;

public class MinusPlus {

    private double minusSum;
    private double plusSum;

    public MinusPlus(double minusSum, double plusSum) {
        this.minusSum = minusSum;
        this.plusSum = plusSum;
    }

    public double getMinusSum() {
        return minusSum;
    }

    public double getPlusSum() {
        return plusSum;
    }

    @Override
    public String toString() {
        return "minusSum=" + minusSum +
                ", plusSum=" + plusSum;
    }
}
