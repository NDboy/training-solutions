package exceptions.polinom;

public class Polynomial {

    private double [] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] stringArr) {
        if (stringArr == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double [] coefficients = new double[stringArr.length];
        try {
            for (int i = 0; i < stringArr.length; i++) {
                coefficients[i] = Double.parseDouble(stringArr[i]);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
        this.coefficients = coefficients;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        double n = coefficients.length - 1;
        double sum = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += Math.pow(x, n - (double) i) * coefficients[i];
        }
        return sum;
    }
}
