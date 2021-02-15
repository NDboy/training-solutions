package exam03;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }


    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("The boat is full");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier() * getBasicPrice();
    }

    public Passenger findPassengerByName(String passengerName) {
        return passengers.stream()
                .filter(a -> a.getName().equals(passengerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No passenger found"));
    }

    public List<String> getPassengerNamesOrdered() {
        List<Passenger> listCopyToOrder = new ArrayList<>(passengers);
        return listCopyToOrder.stream()
                .map(Passenger::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream()
                .map(a -> (a.getCruiseClass().getMultiplier() * getBasicPrice()))
                .reduce(0.0, Double::sum);

    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        return passengers.stream().
                collect(Collectors.groupingBy(Passenger::getCruiseClass, Collectors.summingInt(a->1)));
    }


}