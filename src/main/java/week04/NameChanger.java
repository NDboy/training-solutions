package week04;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String changeFirstName(String firstName) {
        fullName = firstName + fullName.substring(fullName.indexOf(" "));
        return fullName;
    }

}
