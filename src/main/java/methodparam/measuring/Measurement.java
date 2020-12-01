package methodparam.measuring;

public class Measurement {
    private double [] measurements;

    public Measurement(double[] measurements) {
        this.measurements = measurements;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] > lower && measurements[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = 0;
        for (double measurement: measurements) {
            if (min == 0 || measurement < min) {
                min = measurement;
            }
        }
        return min;
    }

    public double maximum() {
        double max = 0;
        for (double measurement: measurements) {
            if (max == 0 || measurement > max) {
                max = measurement;
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        double min = 0;
        double max = 0;
        for (double measurement: measurements) {
            if (max == 0 || measurement > max) {
                max = measurement;
            } else if (min == 0 || measurement < min) {
                min = measurement;
            }
        }
        return new ExtremValues(min, max);
    }



}
