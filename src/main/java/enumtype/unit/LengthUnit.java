package enumtype.unit;

public enum LengthUnit {

    MILLIMETER(1, true),
    CENTIMETER(10, true),
    METER(1000, true),
    YARD(9144, false),
    FOOT(3048, false),
    INCH(254, false);

    private final int inMillimeter;

    private final boolean siUnit;

    LengthUnit(int inMillimeter, boolean siUnit) {
        this.inMillimeter = inMillimeter;
        this.siUnit = siUnit;
    }

    public int getInMillimeter() {
        return inMillimeter;
    }

    public boolean isSiUnit() {
        return siUnit;
    }
}
