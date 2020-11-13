package stringbuilder;

public enum Title {
    MR("Mr."), PROF("Prof."), MS("Ms."), DR("Dr.");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}
