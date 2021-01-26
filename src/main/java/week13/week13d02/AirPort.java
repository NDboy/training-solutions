package week13.week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AirPort {

    private List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void flightsFileReader(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            processLines(bufferedReader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void processLines(BufferedReader bufferedReader) throws IOException{
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            flights.add(stringToFlight(line));
        }
    }

    private Flight stringToFlight(String flightString) {
        String[] flightArray = flightString.split(" ");
        String flightNumber = flightArray[0];

        FlightAction flightAction = FlightAction.valueOf(flightArray[1].toUpperCase());
        String city = flightArray[2];

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:m");
        LocalTime time = LocalTime.parse(flightArray[3], dtf);
        return new Flight(flightNumber, flightAction, city, time);
    }

    public FlightAction getMoreFlightAction () {
        int arrivalCounter = 0;
        for (Flight flight: flights) {
            if (flight.getFlightAction() == FlightAction.ARRIVAL) {
                arrivalCounter++;
            }
        }
        if (arrivalCounter > flights.size()) {
            return FlightAction.ARRIVAL;
        }
        return FlightAction.DEPARTURE;
    }

    public Flight findFlightByNumber(String flightNumber) {
        for (Flight flight: flights) {
            if (flight.getFlightNumber().equals(flightNumber));
            return flight;
        }
        throw new IllegalArgumentException("No flight found");
    }

    public List<Flight> flightActionsByCity(String city, FlightAction flightAction) {
        List<Flight> foundFlights = new ArrayList<>();
        for (Flight flight: flights) {
            if (city.equals(flight.getCity()) && flightAction == flight.getFlightAction()) {
                foundFlights.add(flight);
            }
        }
        return foundFlights;
    }

    public Flight earliestStartingFlight() {
        Flight flightTemp = null;
        LocalTime timeBuffer = LocalTime.of(23, 59);
        for (Flight flight: flights) {
            if (flight.getTime().isBefore(timeBuffer) && flight.getFlightAction() == FlightAction.DEPARTURE) {
                timeBuffer = flight.getTime();
                flightTemp = flight;
            }
        }
        return flightTemp;
    }

}

//    Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló gépről van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos ideje.
//        ​
//        A fájl:
//        FC5354 Arrival Dublin 18:16
//        KH2442 Departure Berlin 15:54
//        ID4963 Departure Amsterdam 15:22
//        CX8486 Arrival Brussels 10:37
//        EJ9251 Departure  Toronto 11:30
//        KJ7245 Departure Bern 6:18
//        JN6048 Arrival Moscow 18:39
//        MN5047 Arrival Athens 9:35
//        ​
//        Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
//        Feladatok:
//        1. Olvasd be a fájl tartalmát a memóriába.
//        2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
//        3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
//        4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába adjuk viassza az összes abba városba induló/érkező repülőt.
//        5. Adjuk vissza a legkorábban induló repülőt!
