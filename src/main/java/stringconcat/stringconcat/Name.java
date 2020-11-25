package stringconcat.stringconcat;

public class Name {
    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGivenName() {
        return givenName;
    }

    public Title getTitle() {
        return title;
    }

    public boolean isEmpty(String a) {
        return a == null || "".equals(a);
    }

    public String concatNameWesternStyle() {
        String westernStyleName = "";
        if (title != null) {
            westernStyleName += title.getValue();
            westernStyleName += " ";
        }
        westernStyleName += getGivenName();
        westernStyleName += " ";
        if (!isEmpty(getMiddleName())) {
            westernStyleName += getMiddleName();
            westernStyleName += " ";
        }
        westernStyleName += getFamilyName();
        return westernStyleName;
    }

    public String concatNameHungarianStyle() {
        String hungarianStyleName = "";
        if (title != null) {
            hungarianStyleName = hungarianStyleName.concat(title.getValue() + " ");
        }
        hungarianStyleName = hungarianStyleName.concat(getFamilyName() + " ");
        if (!isEmpty(getMiddleName())) {
            hungarianStyleName = hungarianStyleName.concat(getMiddleName() + " ");
        }
        hungarianStyleName = hungarianStyleName.concat(getGivenName());
        return hungarianStyleName;
    }


}
