package stringconcat.stringconcat;

public enum Title {
    MR("Mr."), MS("Ms."), DR("Dr.");

    private String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
