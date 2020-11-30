package methodstructure.bmi;

public class BodyMass {
    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return getWeight() / Math.pow(getHeight(), 2);
    }

    public BmiCategory body() {
        BmiCategory category = null;
        if (bodyMassIndex() < 18.5) {
            category = BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex() > 25.0) {
            category = BmiCategory.OVERWEIGHT;
        } else {
            category = BmiCategory.NORMAL;
        }
        return category;
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return bodyMassIndex() < bodyMass.bodyMassIndex();
    }


}
