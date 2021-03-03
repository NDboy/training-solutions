package covid;

import java.time.LocalDateTime;

public class Vaccination {
    private int citizenId;
    private LocalDateTime dateTime;
    private Status status;
    private String note;
    private VaccinationType vaccinationType;

    public Vaccination(int citizenId, LocalDateTime dateTime, Status status, String note, VaccinationType vaccinationType) {
        this.citizenId = citizenId;
        this.dateTime = dateTime;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public Vaccination(int citizenId, LocalDateTime dateTime, Status status, VaccinationType vaccinationType) {
        this.citizenId = citizenId;
        this.dateTime = dateTime;
        this.status = status;
        this.vaccinationType = vaccinationType;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccinationType getVaccinationType() {
        return vaccinationType;
    }

    @Override
    public String toString() {
        return ", citizenId=" + citizenId +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", vaccinationType=" + vaccinationType;
    }
}
