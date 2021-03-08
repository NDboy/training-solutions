package week04.week04d01;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName) {
        fullName = firstName + " " + fullName.split( " ")[1];
    }

    public static void main(String[] args) {
        NameChanger nc = new NameChanger("Varga József");
        System.out.println(nc.fullName);
        nc.changeFirstName("Kovács");
        System.out.println(nc.fullName);

    }
}
