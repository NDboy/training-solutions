package week15.week15d02;

public enum Subject {
    TORTENELEM("tortenelem"), FOLDRAJZ("foldrajz"), MATEMATIKA("matematika"), MAGYAR("magyar"), KEMIA("kemia");

    private String value;

    Subject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
