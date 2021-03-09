package week06.week06d05;

public class Bottle {
    private BottleType bottleType;
    private int filledUntil;

    public Bottle(BottleType bottleType) {
        this.bottleType = bottleType;
    }

    public BottleType getBottleType() {
        return bottleType;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }

    public void fill(int fillAmount) {
        filledUntil += fillAmount;
        if (filledUntil > bottleType.getMaximumAmount()) {
            throw new IllegalArgumentException("Too much liquid");
        }
    }


}
