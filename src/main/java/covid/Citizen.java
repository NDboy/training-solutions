package covid;

import java.time.LocalDateTime;

public class Citizen {

    private int id;
    private String name;
    private ZipCode zipCode;
    private int age;
    private String email;
    private long ssn;
    private int numberOfVaccination;
    private LocalDateTime lastVaccDateTime;

    public Citizen(String name, ZipCode zipCode, int age, String email, long ssn) {
        this.name = name;
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public Citizen(int id, String name, long ssn, int numberOfVaccination, LocalDateTime lastVaccDateTime) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccDateTime = lastVaccDateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public long getSsn() {
        return ssn;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDateTime getLastVaccDateTime() {
        return lastVaccDateTime;
    }


}
