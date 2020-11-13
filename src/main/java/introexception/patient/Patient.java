package introexception.patient;

public class Patient {
    private String name;
    private String ssn;
    private int yearOfBirth;

    public Patient(String name, String ssn, int yearOfBirth) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        if (!new SsnValidator().isValidSsn(ssn)) {
            throw new IllegalArgumentException("The SSN is invalid.");
        }
        this.ssn = ssn;
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("The year of birth: " +yearOfBirth+ "is invalid.");
        }
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
