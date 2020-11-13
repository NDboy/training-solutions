package stringbasic;

import introexception.patient.SsnValidator;

import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate dateOfBirth;
    private Sex sex;
    private String regNumber;

    public Pet(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth, Sex sex, String regNumber) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.sex = sex;
        if (regNumber.length() != 6) {
            throw new IllegalArgumentException("The registration number must be 6 characters long");
        }
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
