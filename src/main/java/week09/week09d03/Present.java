package week09.week09d03;

public enum Present {
    TOY, ELECTRONIC, HOUSEKEEPING, DECORATION;

    public static Present of(int value) {
        return values()[value];
    }

}
