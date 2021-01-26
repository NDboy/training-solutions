package week13.week13d02;

public enum FlightAction {

    ARRIVAL("Arrival"), DEPARTURE("Departure");

    private String value;

    FlightAction(String value) {
        this.value = value;
    }
}
